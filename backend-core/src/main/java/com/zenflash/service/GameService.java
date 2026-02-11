package com.zenflash.service;

import com.zenflash.domain.Card;
import com.zenflash.domain.UserStats;
import com.zenflash.dto.GameQuestionDTO;
import com.zenflash.dto.GameResultDTO; 
import com.zenflash.repository.CardRepository;
import com.zenflash.repository.UserStatsRepository; 
import jakarta.transaction.Transactional; 
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final CardRepository cardRepository;
    private final UserStatsRepository userStatsRepository; 
    private final SrsService srsService; 

    public List<GameQuestionDTO> generateGameSession(int limit) {
        List<Card> dueCards = cardRepository.findCardsToReview(ZonedDateTime.now());

        if (dueCards.size() < limit) {
            dueCards.addAll(cardRepository.findAll().stream()
                    .limit(limit - dueCards.size())
                    .collect(Collectors.toList()));
        }

        return dueCards.stream().limit(limit).map(card -> {
            List<String> options = new ArrayList<>();
            options.add(card.getBackText());

            List<String> distractors = cardRepository.findAll().stream()
                    .filter(c -> !c.getId().equals(card.getId()))
                    .map(Card::getBackText)
                    .distinct()
                    .collect(Collectors.toList());

            Collections.shuffle(distractors);
            options.addAll(distractors.stream().limit(3).collect(Collectors.toList()));

            Collections.shuffle(options);

            return GameQuestionDTO.builder()
                    .cardId(card.getId())
                    .prompt(card.getFrontText())
                    .correctAnswer(card.getBackText())
                    .options(options)
                    .build();
        }).collect(Collectors.toList());
    }


    @Transactional
    public GameResultDTO submitAnswer(UUID cardId, boolean isCorrect, double timeTaken, int currentCombo) {
        UserStats stats = userStatsRepository.findFirstByOrderByCreatedAtAsc()
                .orElseThrow(() -> new RuntimeException("User stats not found"));
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        long xpGained = 0;
        int newCombo = isCorrect ? currentCombo + 1 : 0;
        int quality = isCorrect ? 5 : 1;

        if (isCorrect) {
            double effectiveTime = Math.max(timeTaken, 1.0);
            xpGained = Math.round((100.0 * newCombo) / effectiveTime);

            stats.setTotalXp(stats.getTotalXp() + xpGained);
            if (newCombo > stats.getHighestCombo()) {
                stats.setHighestCombo(newCombo);
            }
        }

        srsService.calculateNextReview(card, quality);

        int oldLevel = stats.getCurrentLevel();
        int newLevel = (int) (stats.getTotalXp() / 1000) + 1;
        stats.setCurrentLevel(newLevel);
        stats.setLastPlayedAt(ZonedDateTime.now());

        cardRepository.save(card);
        userStatsRepository.save(stats);

        return GameResultDTO.builder()
                .correct(isCorrect)
                .xpGained(xpGained)
                .newCombo(newCombo)
                .currentLevel(newLevel)
                .totalXp(stats.getTotalXp())
                .message(newLevel > oldLevel ? "LEVEL UP! 🚀" : (isCorrect ? "Correct!" : "Wrong answer, keep practicing!"))
                .build();
    }
}