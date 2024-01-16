package com.example.PlayerService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="players")

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerID;

    @Column(nullable = false)
    private String playerName;

    @Column(nullable = false)
    private String playerFirstName;

    @Column(nullable = false)
    private Date playerBirthday;

    @Column(nullable = false)
    private String playerPosition;

    @Column(nullable = false)
    private Long teamID;

}
