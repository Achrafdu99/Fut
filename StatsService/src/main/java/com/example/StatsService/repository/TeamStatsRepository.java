package com.example.StatsService.repository;

import com.example.StatsService.entity.TeamStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamStatsRepository extends JpaRepository <TeamStats, Long> {
    Optional<TeamStats> findByTeamIDAndSeason(Long teamId, Long season);

}
