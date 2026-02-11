package com.zenflash.repository;

import com.zenflash.domain.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.Optional;

public interface UserStatsRepository extends JpaRepository<UserStats, UUID> {
    Optional<UserStats> findFirstByOrderByCreatedAtAsc();
}