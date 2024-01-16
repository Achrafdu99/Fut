package com.example.TeamService.entity;
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
@Table(name ="teams")

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamID;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Date fondationYear;

    @Column(nullable = false)
    private String manager;

}
