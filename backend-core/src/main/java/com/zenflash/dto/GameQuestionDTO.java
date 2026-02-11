package com.zenflash.dto;

import lombok.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GameQuestionDTO {
    private UUID cardId;
    private String prompt;
    private String correctAnswer;
    private List<String> options;
}