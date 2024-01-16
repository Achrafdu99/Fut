package com.example.PlayerService.repository;

import com.example.PlayerService.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerRepository extends JpaRepository<Player, Long>{
}
