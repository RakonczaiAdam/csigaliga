package hu.dreamteam.snailleague.controller;

import hu.dreamteam.snailleague.exception.ResourceNotFoundException;
import hu.dreamteam.snailleague.model.Match;
import hu.dreamteam.snailleague.model.Snail;
import hu.dreamteam.snailleague.model.SnailMatch;
import hu.dreamteam.snailleague.model.UserMatch;
import hu.dreamteam.snailleague.repository.SnailMatchRepository;
import hu.dreamteam.snailleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class SnailMatchController {

    @Autowired
    private SnailMatchRepository snailMatchRepository;
    private UserRepository userRepository;

    // create snailmatch
    @PostMapping("/snailmatches/create")
    public SnailMatch createSnailMatch(@RequestBody SnailMatch snailMatch) {
        return this.snailMatchRepository.save(snailMatch);
    }

    // get snailmatches
    @GetMapping("/snailmatches/get")
    public List<SnailMatch> getAllSnailMatches() {
        return this.snailMatchRepository.findAll();
    }

    // get snailmatch by id
    @GetMapping("/snailmatches/getbyid/{id}")
    public ResponseEntity<SnailMatch> getSnailMatchById(@PathVariable(value = "id") Long snailMatchId) throws ResourceNotFoundException {
        SnailMatch snailMatch = snailMatchRepository.findById(snailMatchId).orElseThrow(() -> new ResourceNotFoundException("SnailMatch not found by this id: " + snailMatchId));

        return ResponseEntity.ok().body(snailMatch);
    }

    // update snailmatch assign match/user
    @PutMapping("/snailmatches/updatemu/{id}")
    public ResponseEntity<SnailMatch> updateSnailMatchMatchUser(@PathVariable(value = "id") Long snailMatchId, @Validated @RequestBody Snail snail, @Validated @RequestBody Match match) throws ResourceNotFoundException {
        SnailMatch snailMatch = snailMatchRepository.findById(snailMatchId).orElseThrow(() -> new ResourceNotFoundException("SnailMatch not found by the id : " + snailMatchId));

        snailMatch.setMatch(match);
        snailMatch.setSnail(snail);

        return ResponseEntity.ok(this.snailMatchRepository.save(snailMatch));
    }

    // update snailmatch assign place
    @PutMapping("/snailmatches/updateplace/{id}")
    public ResponseEntity<SnailMatch> updateSnailMatchPlace(@PathVariable(value = "id") Long snailMatchId, Integer place) throws ResourceNotFoundException {
        SnailMatch snailMatch = snailMatchRepository.findById(snailMatchId).orElseThrow(() -> new ResourceNotFoundException("SnailMatch not found by the id : " + snailMatchId));

        snailMatch.setPlace(place);

        return ResponseEntity.ok(this.snailMatchRepository.save(snailMatch));
    }

    // delete snailmatch
    @DeleteMapping("/snailmatches/delete/{id}")
    public Map<String, Boolean> deleteSnailMatch(@PathVariable(value = "id") Long snailMatchId) throws ResourceNotFoundException {
        SnailMatch snailMatch = snailMatchRepository.findById(snailMatchId).orElseThrow(() -> new ResourceNotFoundException("SnailMatch not found by the id: " + snailMatchId));

        this.snailMatchRepository.delete(snailMatch);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
