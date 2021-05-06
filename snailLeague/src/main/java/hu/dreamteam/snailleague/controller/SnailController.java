package hu.dreamteam.snailleague.controller;

import hu.dreamteam.snailleague.exception.ResourceNotFoundException;
import hu.dreamteam.snailleague.model.Snail;
import hu.dreamteam.snailleague.model.User;
import hu.dreamteam.snailleague.model.SnailMatch;
import hu.dreamteam.snailleague.model.Skin;
import hu.dreamteam.snailleague.repository.SkinRepository;
import hu.dreamteam.snailleague.repository.SnailMatchRepository;
import hu.dreamteam.snailleague.repository.SnailRepository;
import hu.dreamteam.snailleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class SnailController {

    @Autowired
    private SnailRepository snailRepository;
    private UserRepository userRepository;
    private SnailMatchRepository snailMatchRepository;
    private SkinRepository skinRepository;

    // create snail
    @PostMapping("/snails/create")
    public Snail createSnail (@RequestBody Snail snail, @Validated @RequestParam("skin") Long skinID) throws ResourceNotFoundException {
        Skin skin = skinRepository.findById(skinID).orElseThrow(() -> new ResourceNotFoundException("Skin not found by the id: " + skinID));
        snail.setSkinId(skin);
        return this.snailRepository.save(snail);
    }

    // get snails
    @GetMapping("/snails/get")
    public List<Snail> getAllSnail() {
        return this.snailRepository.findAll();
    }

    // get snails by user id
    @GetMapping("/snails/getbyuid")
    public List<Snail> getSnailByUserId(Long userId) {
        List<Snail> allSnails = snailRepository.findAll();
        List<Snail> userSails = new ArrayList<Snail>();
        for (int i=0; i < allSnails.size(); i++){
            if(allSnails.get(i).getUserId().equals(userId)){
                userSails.add(allSnails.get(i));
            }
        }
        allSnails.clear();
        return userSails;
    }

    // set snail to user id
    @PutMapping("/snails/settouid/{id}")
    public ResponseEntity<Snail> assignSnailToUser(@PathVariable(value = "id") Long snailId, @Validated @RequestParam("user") Long userId) throws ResourceNotFoundException {
        Snail snail = snailRepository.findById(snailId).orElseThrow(() -> new ResourceNotFoundException("Snail not found by the id: " + snailId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found by the id: " + userId));

        snail.setUserId(user);

        return ResponseEntity.ok(this.snailRepository.save(snail));
    }

    // update snail
    @PutMapping("/snails/updatesnail/{id}")
    public ResponseEntity<Snail> updateSnail(@PathVariable(value = "id") Long snailId, @Validated @RequestBody Snail snailDetails) throws ResourceNotFoundException {
        Snail snail = snailRepository.findById(snailId).orElseThrow(() -> new ResourceNotFoundException("Snail not found by the id : " + snailId));

        snail.setName(snailDetails.getName());
        snail.setSpeed(snailDetails.getSpeed());
        snail.setStamina(snailDetails.getStamina());

        return ResponseEntity.ok(this.snailRepository.save(snail));
    }

    // delete snail from user id
    @PutMapping("/snails/deletesnailfromuid/{id}")
    public ResponseEntity<Snail> removeSnailFromUser(@PathVariable(value = "id") Long snailId) throws ResourceNotFoundException {
        Snail snail = snailRepository.findById(snailId).orElseThrow(() -> new ResourceNotFoundException("Snail not found by the id: " + snailId));

        snail.setUserId(null);

        return ResponseEntity.ok(this.snailRepository.save(snail));
    }

    // get snail
    @GetMapping("/snails/getsnail/{id}")
    public ResponseEntity<Snail> getSnailById(@PathVariable(value = "id") Long snailId) throws ResourceNotFoundException {
        Snail snail = snailRepository.findById(snailId).orElseThrow(() -> new ResourceNotFoundException("Snail not found by this id: " + snailId));

        return ResponseEntity.ok().body(snail);
    }

    // delete snail
    @DeleteMapping("/snails/deletesnail/{id}")
    public Map<String, Boolean> deleteSnail(@PathVariable(value = "id") Long snailId) throws ResourceNotFoundException {
        Snail snail = snailRepository.findById(snailId).orElseThrow(() -> new ResourceNotFoundException("Snail not found by the id: " + snailId));

        this.snailRepository.delete(snail);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    //snail leaderboard
    @GetMapping("/snails/leaderboard")
    public HashMap<Snail, Integer> snailLeaderboard() {
        HashMap<Snail, Integer> snailMap = new HashMap<Snail, Integer>();
        List<Snail> snailList = snailRepository.findAll();
        List<SnailMatch> snailMatches = snailMatchRepository.findAll();
        Integer wins;
        for(Snail snail: snailList){
            wins = 0;
            for(SnailMatch match: snailMatches){
                if(match.getSnail().getId().equals(snail.getId()) && match.getPlace().equals(1)){
                    wins++;
                }
            }
            snailMap.put(snail, wins);
        }
        return snailMap;
    }
}
