package com.example.StatsService.repository;

import com.example.StatsService.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
    PlayerStats findByPlayerID(Long playerID);


}
