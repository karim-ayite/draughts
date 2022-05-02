package fr.codeflow.draughtsapi.controllers;

import fr.codeflow.draughtsapi.model.AbstractGame;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import fr.codeflow.draughtsapi.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    AbstractGame newGame(@RequestBody NewGameRequest newGameRequest) {
        return gameService.createNewGame(newGameRequest);
    }

}
