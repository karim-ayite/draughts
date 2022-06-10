package fr.codeflow.draughtsapi.controllers;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import fr.codeflow.draughtsapi.payload.request.CreateGameRequest;
import fr.codeflow.draughtsapi.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {

    private final GameService gameService;

    GameController(@Autowired GameService gameService){
        this.gameService = gameService;
    }

    @Operation(summary = "Create a new game initiate by player one")
    @PostMapping("/games")
    Game createGame(@Valid @RequestBody CreateGameRequest createGameRequest) {

        return this.gameService.createGame(createGameRequest.playerId(), createGameRequest.playerColor());
    }

    @Operation(summary = "Get all games by status")
    @GetMapping("/games")
    @ResponseBody
    List<Game> getGames(@RequestParam GameStatus status){
        return this.gameService.getGameByStatus(status);
    }

}
