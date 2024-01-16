package com.example.TeamService.services;


import com.example.TeamService.entity.Team;
import com.example.TeamService.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository= teamRepository;
    }
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }
    public Optional<Team> getTeamById (Long id) {
        return teamRepository.findById(id);
    }
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
    public Team updatePlayer(Long id, Team teamDetails) {
        Optional<Team> existingTeam = teamRepository.findById(id);

        if (existingTeam.isEmpty()) {
            return null;
        }

        Team teamToUpdate = existingTeam.get();
        teamToUpdate.setTeamName(teamDetails.getTeamName());
        teamToUpdate.setCountry(teamDetails.getCountry());
        teamToUpdate.setFondationYear(teamDetails.getFondationYear());
        teamToUpdate.setManager(teamDetails.getManager());

        return teamRepository.save(teamToUpdate);
    }
    public void deleteTeam (Long id) {
        teamRepository.deleteById(id);
    }

}
