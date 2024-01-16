package com.example.TeamService.controllers;
import com.example.TeamService.entity.Team;
import com.example.TeamService.services.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamControllers {
    private final TeamService teamService;

    @Autowired
    public TeamControllers (TeamService teamService) {
        this.teamService= teamService;
    }

    @Operation(summary="Get a list of all teams")
    @GetMapping
    public List<Team> getAllTeams () {
        return teamService.getAllTeams();
    }
    @Operation(summary = "Get a team by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the teams"),
            @ApiResponse(responseCode = "404", description = "Teams not found")
    })
    @GetMapping("/{id}")
    public Team getPlayerById (@Parameter(description = "Id of the team to be obtained") @PathVariable Long id) {
        return teamService.getTeamById(id).orElse(null);
    }
    @Operation(summary = "Add a new team")
    @PostMapping
    public Team addTeam (@Parameter(description = "Team to add")@RequestBody Team team) {
        return teamService.saveTeam(team);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam (@Parameter(description = "Team to update")@PathVariable Long id, @RequestBody Team team) {
        Team updatedTeam = teamService.updatePlayer(id, team);
        if(updatedTeam == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTeam);

    }
    @Operation(summary = "Delete a play")
    @DeleteMapping("/{id}")
    public void deletTeam (@Parameter(description = "Id of the player to be deleted")@PathVariable Long id) {
        teamService.deleteTeam(id);
    }


}
