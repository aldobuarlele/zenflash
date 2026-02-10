package com.zenflash.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String frontText;

    @Column(nullable = false)
    private String backText;

    private String reading;

    private Double easinessFactor = 2.5;

    private Integer intervalDays = 0;

    private Integer repetitions = 0;

    private ZonedDateTime nextReviewAt;

    private ZonedDateTime createdAt = ZonedDateTime.now();
}