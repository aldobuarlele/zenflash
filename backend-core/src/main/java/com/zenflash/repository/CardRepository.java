package com.zenflash.repository;

import com.zenflash.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    @Query("SELECT c FROM Card c WHERE c.nextReviewAt <= :now")
    List<Card> findAllDue(ZonedDateTime now);
}