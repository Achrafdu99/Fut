package com.example.StatsService.services;

import com.example.StatsService.entity.TeamStats;
import com.example.StatsService.repository.TeamStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamStatsService {

    @Autowired
    private TeamStatsRepository teamStatsRepository;

    public Optional<TeamStats> getTeamStats (Long teamId, Long season) {
        return teamStatsRepository.findByTeamIDAndSeason(teamId, season);
    }
}
