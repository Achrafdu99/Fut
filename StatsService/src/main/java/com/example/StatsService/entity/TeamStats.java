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
@Table(name ="teamStats")

public class TeamStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamStatID;

    @Column(nullable = false)
    private Long teamID;

    @Column(nullable = false)
    private Long season;

    @Column(nullable = false)
    private Long victories;

    @Column(nullable = false)
    private Long draws;

    @Column(nullable = false)
    private Long loses;

    @Column(nullable = false)
    private Long GoalScored;

    @Column(nullable = false)
    private Long GoalRecieved;


}

