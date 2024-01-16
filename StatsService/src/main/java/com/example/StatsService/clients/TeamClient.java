package com.example.StatsService.clients;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "SERVICE PLAYER", url = "localhost:8082")

public interface TeamClient {
}
