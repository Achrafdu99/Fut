package com.example.PlayerService.services;
import com.example.PlayerService.entity.Player;

import com.example.PlayerService.repository.PlayerRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @CircuitBreaker(name = "monDisjoncteur", fallbackMethod = "fallback")

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    @CircuitBreaker(name = "monDisjoncteur", fallbackMethod = "fallback")

    public Optional<Player> getPlayerById (Long id) {
        return playerRepository.findById(id);
    }
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Optional<Player> existingPlayer = playerRepository.findById(id);

        if (existingPlayer.isEmpty()) {
            return null;
        }

        Player playerToUpdate = existingPlayer.get();
        playerToUpdate.setPlayerName(playerDetails.getPlayerName());
        playerToUpdate.setPlayerFirstName(playerDetails.getPlayerFirstName());
        playerToUpdate.setPlayerBirthday(playerDetails.getPlayerBirthday());
        playerToUpdate.setPlayerPosition(playerDetails.getPlayerPosition());
        playerToUpdate.setTeamID(playerDetails.getTeamID());

        return playerRepository.save(playerToUpdate);
    }
    public void deletePlayer (Long id) {
        playerRepository.deleteById(id);
    }
    private Optional<Player> fallback(Long id, Throwable t) {
        Player playerInMaintenance = new Player();
        playerInMaintenance.setPlayerName("Service en maintenance. Veuillez réessayer ultérieurement.");
        return Optional.of(playerInMaintenance);
    }

}
