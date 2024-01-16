package com.example.StatsService.clients;

import com.example.StatsService.entity.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Service-player", url = "localhost:8082")
public interface PlayerClient {
    @GetMapping("api/players/{id}")
    Player getTeamById(@PathVariable("id") Long id);
}
