package com.zenflash.dto;

import lombok.*;

@Data
@Builder
public class GameResultDTO {
    private boolean correct;
    private long xpGained;
    private int newCombo;
    private int currentLevel;
    private long totalXp;
    private String message;
}