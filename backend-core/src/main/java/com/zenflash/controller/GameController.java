package com.zenflash.controller;

import com.zenflash.dto.GameQuestionDTO;
import com.zenflash.dto.GameResultDTO;
import com.zenflash.dto.GameSubmissionRequest;
import com.zenflash.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GameController {

    private final GameService gameService;

    @GetMapping("/start")
    public List<GameQuestionDTO> startGame(@RequestParam(defaultValue = "10") int limit) {
        return gameService.generateGameSession(limit);
    }

    @PostMapping("/submit")
    public GameResultDTO submitAnswer(@RequestBody GameSubmissionRequest request) {
        return gameService.submitAnswer(
                request.getCardId(),
                request.isCorrect(),
                request.getTimeTaken(),
                request.getCurrentCombo()
        );
    }
}