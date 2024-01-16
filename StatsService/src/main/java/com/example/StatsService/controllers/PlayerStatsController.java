package com.example.StatsService.controllers;

import com.example.StatsService.dto.PlayerDetailsWithStats;
import com.example.StatsService.services.PlayerStatsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayerStatsController {
    @Autowired
    private PlayerStatsService playerStatsService;

    @Operation(summary="Get player statistics along with player details by Id")
    @GetMapping("/player-stats/{playerId}")
    public ResponseEntity<PlayerDetailsWithStats> getPlayerStats(@PathVariable Long playerId) {
        PlayerDetailsWithStats playerDetailsWithStats = playerStatsService.getPlayerStatsByPlayerID(playerId);
        if (playerDetailsWithStats == null || playerDetailsWithStats.getPlayer() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(playerDetailsWithStats);
    }
}
