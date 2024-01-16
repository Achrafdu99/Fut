package com.example.StatsService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="playerStats")

public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerStatsID;

    @Column(nullable = false)
    private Long playerID;

    @Column(nullable = false)
    private Long season;

    @Column(nullable = false)
    private Long Goals;

    @Column(nullable = false)
    private Long yellowCard;

    @Column(nullable = false)
    private Long redCard;

}

