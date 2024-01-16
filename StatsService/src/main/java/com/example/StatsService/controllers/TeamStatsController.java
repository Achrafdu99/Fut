package com.example.StatsService.controllers;

import com.example.StatsService.entity.TeamStats;
import com.example.StatsService.services.TeamStatsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TeamStatsController {
    @Autowired
    private TeamStatsService teamStatsService;
    @Operation(summary="Get a list of teamStats by Id")
    @GetMapping("/team-stats/{teamId}/{season}")
    public ResponseEntity<TeamStats> getTeamStats(@PathVariable Long teamId, @PathVariable Long season) {
        return teamStatsService.getTeamStats(teamId, season)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
