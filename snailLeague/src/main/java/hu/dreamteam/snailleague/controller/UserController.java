package hu.dreamteam.snailleague.controller;

import hu.dreamteam.snailleague.exception.ResourceNotFoundException;
import hu.dreamteam.snailleague.model.User;
import hu.dreamteam.snailleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get users
    @GetMapping("/users/get")
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    // get user by id
    @GetMapping("/users/getbyid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    // create user
    @PostMapping("/users/create")
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    // update user
    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Validated @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setMoneyAmount(userDetails.getMoneyAmount());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    // delete user
    @DeleteMapping("/users/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        this.userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    @GetMapping("/users/leaderboard")
    public List<User> userLeaderboard() {
        List<User> userList = userRepository.findAll();
        Collections.sort(userList);
        return userList;
    }
}
