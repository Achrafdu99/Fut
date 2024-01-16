package com.example.PlayerService.controllers;

        import com.example.PlayerService.entity.Player;
        import com.example.PlayerService.services.PlayerService;
        import io.swagger.v3.oas.annotations.Operation;
        import io.swagger.v3.oas.annotations.Parameter;
        import io.swagger.v3.oas.annotations.responses.ApiResponse;
        import io.swagger.v3.oas.annotations.responses.ApiResponses;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerControllers {
    private final PlayerService playerService;

    @Autowired
    public PlayerControllers (PlayerService playerService) {
        this.playerService= playerService;
    }

    @Operation(summary="Get a list of all playerss")
    @GetMapping
    public List<Player> getAllPlayers () {
        return playerService.getAllPlayers();
    }
    @Operation(summary = "Get a player by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the players"),
            @ApiResponse(responseCode = "404", description = "Players not found")
    })
    @GetMapping("/{id}")
    public Player getPlayerById (@Parameter(description = "Id of the player to be obtained") @PathVariable Long id) {
        return playerService.getPlayerById(id).orElse(null);
    }
    @Operation(summary = "Add a new player")
    @PostMapping
    public Player addPlayer (@Parameter(description = "Player to add")@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @Operation(summary = "Update a player by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the player and update"),
            @ApiResponse(responseCode = "404", description = "Player not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Player>  updatePlayer (@Parameter(description = "Player to update")@PathVariable Long id, @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(id, player);
        if(updatedPlayer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPlayer);

    }
    @Operation(summary = "Delete a play")
    @DeleteMapping("/{id}")
    public void deletPlayer (@Parameter(description = "Id of the player to be deleted")@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

}
