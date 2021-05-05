package hu.dreamteam.snailleague.controller;

import hu.dreamteam.snailleague.exception.ResourceNotFoundException;
import hu.dreamteam.snailleague.model.Snail;
import hu.dreamteam.snailleague.model.User;
import hu.dreamteam.snailleague.model.Match;
import hu.dreamteam.snailleague.model.SnailMatch;
import hu.dreamteam.snailleague.model.UserMatch;
import hu.dreamteam.snailleague.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class MatchController {

    @Autowired
    private UserRepository userRepository;
    private SnailRepository snailRepository;
    private MatchRepository matchRepository;
    private UserMatchRepository userMatchRepository;
    private SnailMatchRepository snailMatchRepository;

    //create match
    @PostMapping("/matches/create")
    public Match createMatch (@RequestBody Match match) {
        return this.matchRepository.save(match);
    }

    //update match
    @PutMapping("/matches/update/{id}")
    public ResponseEntity<Match> matchUser(@PathVariable(value = "id") Long matchId, @Validated @RequestBody Match matchDetails) throws ResourceNotFoundException {
        Match match = matchRepository.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found by the id: " + matchId));

        match.setMapId(matchDetails.getMapId());
        match.setMatchDate(matchDetails.getMatchDate());
        match.setSnailMatches(matchDetails.getSnailMatches());
        match.setStatus(matchDetails.getStatus());
        match.setUserMatches(matchDetails.getUserMatches());

        return ResponseEntity.ok(this.matchRepository.save(match));
    }

    //get all matches
    @GetMapping("/matches/getall")
    public List<Match> getAllMatch() {
        return this.matchRepository.findAll();
    }

    //get match by id
    @GetMapping("/matches/getbyid/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable(value = "id") Long matchId) throws ResourceNotFoundException {
        Match match = matchRepository.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found for this id :: " + matchId));
        return ResponseEntity.ok().body(match);
    }

    //get matches by user id
    @GetMapping("/usermatches/getbyuid/{id}")
    public List<Match> getMatchByUserId(@PathVariable(value = "id") Long userMatchId, @Validated @RequestBody User user) throws ResourceNotFoundException {
        List<UserMatch> allUserMatches = this.userMatchRepository.findAll();
        List<Match> userMatches = new ArrayList<Match>();
        for(int i = 0; i < allUserMatches.size(); i++){
            if(allUserMatches.get(i).getUser().getId().equals(user.getId())){
                long matchId = allUserMatches.get(i).getMatch().getId();
                Match match = this.matchRepository.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found by id: " + matchId));
                userMatches.add(match);
            }
        }
        return userMatches;
    }

    //get matches by snail id
    @GetMapping("/snailmatches/gebysid/{id}")
    public List<Match> getMatchBySnailId(@PathVariable(value = "id") Long snailMatchId, @Validated @RequestBody Snail snail) throws ResourceNotFoundException {
        List<SnailMatch> allSnailMatches = this.snailMatchRepository.findAll();
        List<Match> snailMatches = new ArrayList<Match>();
        for(int i = 0; i < allSnailMatches.size(); i++){
            if(allSnailMatches.get(i).getSnail().getId().equals(snail.getId())){
                Long matchId = allSnailMatches.get(i).getMatch().getId();
                Match match = this.matchRepository.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found by id: " + matchId));
                snailMatches.add(match);
            }
        }
        return snailMatches;
    }
}
