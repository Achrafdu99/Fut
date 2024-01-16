package com.example.MatchService.controllers;
import com.example.MatchService.entity.Match;
import com.example.MatchService.services.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matchs")
public class MatchControllers {
    private final MatchService matchService;

    @Autowired
    public MatchControllers (MatchService matchService) {
        this.matchService= matchService;
    }

    @Operation(summary="Get a list of all matchs")
    @GetMapping
    public List<Match> getAllMatchs () {
        return matchService.getAllMatchs();
    }
    @Operation(summary = "Get a Match by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Matchs"),
            @ApiResponse(responseCode = "404", description = "Matchs not found")
    })
    @GetMapping("/{id}")
    public Match getMatchById (@Parameter(description = "Id of the Match to be obtained") @PathVariable Long id) {
        return matchService.getMatchById(id).orElse(null);
    }
    @Operation(summary = "Add a new Match")
    @PostMapping
    public Match addMatch (@Parameter(description = "Match to add")@RequestBody Match match) {
        return matchService.saveMatch(match);
    }

    @Operation(summary = "Update a match by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the match and update"),
            @ApiResponse(responseCode = "404", description = "Match not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Match>  updateMatch (@Parameter(description = "Match to update")@PathVariable Long id, @RequestBody Match match) {
        Match updatedMatch = matchService.updateMatch(id, match);
        if(updatedMatch == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMatch);

    }
    @Operation(summary = "Delete a Match")
    @DeleteMapping("/{id}")
    public void deletMatch (@Parameter(description = "Id of the Match to be deleted")@PathVariable Long id) {
        matchService.deleteMatche(id);
    }


}
