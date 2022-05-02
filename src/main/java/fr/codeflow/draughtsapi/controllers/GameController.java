package fr.codeflow.draughtsapi.controllers;

import fr.codeflow.draughtsapi.model.DraughtsGame;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import fr.codeflow.draughtsapi.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @Operation(summary = "Create a new game in the given rules")
    @PostMapping("/games")
    DraughtsGame newGame(@Valid @RequestBody NewGameRequest newGameRequest) {
        return gameService.createNewGame(newGameRequest);
    }

}
