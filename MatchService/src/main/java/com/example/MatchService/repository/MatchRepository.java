package com.example.MatchService.repository;

import com.example.MatchService.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository <Match, Long> {
}
