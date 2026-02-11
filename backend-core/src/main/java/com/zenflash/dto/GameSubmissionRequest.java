package com.zenflash.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class GameSubmissionRequest {
    private UUID cardId;
    private boolean correct;
    private double timeTaken;
    private int currentCombo;
}