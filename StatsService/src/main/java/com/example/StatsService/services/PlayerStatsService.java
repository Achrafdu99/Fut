package com.example.StatsService.services;

import com.example.StatsService.clients.PlayerClient;
import com.example.StatsService.dto.PlayerDetailsWithStats;
import com.example.StatsService.entity.Player;
import com.example.StatsService.entity.PlayerStats;
import com.example.StatsService.repository.PlayerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatsService {
    @Autowired
    private PlayerStatsRepository playerStatsRepository;

    @Autowired
    private PlayerClient playerClient;

    public PlayerDetailsWithStats getPlayerStatsByPlayerID(Long playerID) {
        PlayerStats stats = playerStatsRepository.findByPlayerID(playerID);
        Player player = playerClient.getTeamById(playerID);
        return new PlayerDetailsWithStats(player, stats);
    }

}
