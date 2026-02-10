package com.zenflash.service;

import com.zenflash.domain.Card;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;

@Service
public class SrsService {

    public Card calculateNextReview(Card card, int quality) {
        int repetitions = card.getRepetitions();
        double ef = card.getEasinessFactor();
        int interval = card.getIntervalDays();

        if (quality >= 3) {
            if (repetitions == 0) {
                interval = 1;
            } else if (repetitions == 1) {
                interval = 6;
            } else {
                interval = (int) Math.round(interval * ef);
            }
            repetitions++;
        } else {
            repetitions = 0;
            interval = 1;
        }

        ef = ef + (0.1 - (5 - quality) * (0.08 + (5 - quality) * 0.02));
        if (ef < 1.3) ef = 1.3;

        card.setRepetitions(repetitions);
        card.setEasinessFactor(ef);
        card.setIntervalDays(interval);
        card.setNextReviewAt(ZonedDateTime.now().plusDays(interval));

        return card;
    }
}