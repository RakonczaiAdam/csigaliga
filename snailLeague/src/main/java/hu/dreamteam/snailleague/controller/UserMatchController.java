package hu.dreamteam.snailleague.controller;

import hu.dreamteam.snailleague.exception.ResourceNotFoundException;
import hu.dreamteam.snailleague.model.Match;
import hu.dreamteam.snailleague.model.Snail;
import hu.dreamteam.snailleague.model.User;
import hu.dreamteam.snailleague.model.UserMatch;
import hu.dreamteam.snailleague.repository.UserMatchRepository;
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
public class UserMatchController {

    @Autowired
    private UserMatchRepository userMatchRepository;
    private UserRepository userRepository;

    // create usermatch
    @PostMapping("/usermatches/create")
    public UserMatch createUserMatch(@RequestBody UserMatch userMatch) {
        return this.userMatchRepository.save(userMatch);
    }

    // get usermatches
    @GetMapping("/usermatches/get")
    public List<UserMatch> getAllUserMatches() {
        return this.userMatchRepository.findAll();
    }

    // get usermatch by id
    @GetMapping("/usermatches/getbyid/{id}")
    public ResponseEntity<UserMatch> getUserMatchById(@PathVariable(value = "id") Long userMatchId) throws ResourceNotFoundException {
        UserMatch userMatch = userMatchRepository.findById(userMatchId).orElseThrow(() -> new ResourceNotFoundException("UserMatch not found by this id: " + userMatchId));

        return ResponseEntity.ok().body(userMatch);
    }

    // update usermatch set match,user,snail
    @PutMapping("/usermatches/setmus/{id}")
    public ResponseEntity<UserMatch> updateuserMatchMatchUser(@PathVariable(value = "id") Long userMatchId, @Validated @RequestBody User user, @Validated @RequestBody Match match, @Validated @RequestBody Snail snail) throws ResourceNotFoundException {
        UserMatch userMatch = userMatchRepository.findById(userMatchId).orElseThrow(() -> new ResourceNotFoundException("UserMatch not found by the id : " + userMatchId));

        userMatch.setMatch(match);
        userMatch.setSnailId(snail);
        userMatch.setUser(user);

        return ResponseEntity.ok(this.userMatchRepository.save(userMatch));
    }

    // update usermatch assign win,money
    @PutMapping("/usermatches/updatewm/{id}")
    public ResponseEntity<UserMatch> updateUserMatchPlace(@PathVariable(value = "id") Long userMatchId, Integer money, Boolean win) throws ResourceNotFoundException {
        UserMatch userMatch = userMatchRepository.findById(userMatchId).orElseThrow(() -> new ResourceNotFoundException("UserMatch not found by the id : " + userMatchId));

        userMatch.setWon(win);
        userMatch.setMoneySet(money);

        return ResponseEntity.ok(this.userMatchRepository.save(userMatch));
    }

    // delete usermatch
    @DeleteMapping("/usermatches/delete/{id}")
    public Map<String, Boolean> deleteUserMatch(@PathVariable(value = "id") Long userMatchId) throws ResourceNotFoundException {
        UserMatch userMatch = userMatchRepository.findById(userMatchId).orElseThrow(() -> new ResourceNotFoundException("UserMatch not found by the id: " + userMatchId));

        this.userMatchRepository.delete(userMatch);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}

