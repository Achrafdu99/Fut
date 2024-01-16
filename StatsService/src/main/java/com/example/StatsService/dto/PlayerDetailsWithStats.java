package com.example.StatsService.dto;

import com.example.StatsService.entity.Player;
import com.example.StatsService.entity.PlayerStats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDetailsWithStats {
    private Player player;
    private PlayerStats stats;

}
