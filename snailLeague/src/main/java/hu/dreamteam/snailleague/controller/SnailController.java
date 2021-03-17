package hu.dreamteam.snailleague.controller;

import hu.dreamteam.snailleague.repository.SnailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class SnailController {

    @Autowired
    private SnailRepository snailRepository;

    // create snail

    // get snails

    // get snails by user id

    // set snail to user id

    // update snail to user id

    // delete snail from user id

    // get snail's stats (speed, stamina, skin)

    // set snail's stats (speed, stamina, skin)

    // ...
}
