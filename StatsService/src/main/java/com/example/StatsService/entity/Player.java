package com.example.StatsService.entity;
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
public class Player {

    private Long playerID;
    private String playerName;
    private String playerFirstName;
    private Date playerBirthday;
    private String playerPosition;
    private Long teamID;
}
