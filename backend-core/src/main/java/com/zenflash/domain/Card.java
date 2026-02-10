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

    @Builder.Default
    private Double easinessFactor = 2.5;

    @Builder.Default
    private Integer intervalDays = 0;

    @Builder.Default
    private Integer repetitions = 0;

    private ZonedDateTime nextReviewAt;

    @Builder.Default
    private ZonedDateTime createdAt = ZonedDateTime.now();}