package com.example.MatchService.services;
import com.example.MatchService.entity.Match;
import com.example.MatchService.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatchs(){
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById (Long id) {
        return matchRepository.findById(id);
    }
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match matchDetails) {
        Optional<Match> existingPlayer = matchRepository.findById(id);

        if (existingPlayer.isEmpty()) {
            return null;
        }

        Match matchToUpdate = existingPlayer.get();
        matchToUpdate.setMatchDate(matchDetails.getMatchDate());
        matchToUpdate.setPlace(matchDetails.getPlace());
        matchToUpdate.setTeamHomeId(matchDetails.getTeamHomeId());
        matchToUpdate.setTeamAwayId(matchDetails.getTeamAwayId());
        matchToUpdate.setScore(matchDetails.getScore());

        return matchRepository.save(matchToUpdate);
    }
    public void deleteMatche (Long id) {
        matchRepository.deleteById(id);
    }


}
