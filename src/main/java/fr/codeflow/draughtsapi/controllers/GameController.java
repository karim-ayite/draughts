package fr.codeflow.draughtsapi.controllers;

import fr.codeflow.draughtsapi.model.Game;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame) {
        return new Game();
    }

}
