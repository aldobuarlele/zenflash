package com.zenflash.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer currentLevel;
    private Long totalXp;
    private Integer currentStreak;
    private Integer highestCombo;

    private ZonedDateTime lastPlayedAt;
    private String rankTitle;

    @Builder.Default
    private ZonedDateTime createdAt = ZonedDateTime.now();
}