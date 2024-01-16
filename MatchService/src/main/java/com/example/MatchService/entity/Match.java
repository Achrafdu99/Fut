package com.example.MatchService.entity;
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
@Table(name ="matchs")

public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchID;

    @Column(nullable = false)
    private Date matchDate;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private Long teamHomeId;

    @Column(nullable = false)
    private Long teamAwayId;

    @Column(nullable = false)
    private String score;



}

