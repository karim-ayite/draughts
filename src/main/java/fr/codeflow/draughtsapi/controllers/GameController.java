package fr.codeflow.draughtsapi.controllers;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import fr.codeflow.draughtsapi.payload.request.CreateGameRequest;
import fr.codeflow.draughtsapi.service.CreateGameService;
import fr.codeflow.draughtsapi.service.GetGamesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {

    private final CreateGameService createGameService;

    private final GetGamesService getGamesService;

    GameController(@Autowired CreateGameService createGameService, GetGamesService getGamesService){
        this.createGameService = createGameService;
        this.getGamesService = getGamesService;
    }

    @Operation(summary = "Create a new game initiate by player one")
    @PostMapping("/games")
    Game createGame(@Valid @RequestBody CreateGameRequest createGameRequest) {

        return this.createGameService.createGame(createGameRequest.playerId(), createGameRequest.playerColor(),createGameRequest.nickname());
    }

    @Operation(summary = "Get all games by status")
    @GetMapping("/games")
    @ResponseBody
    List<Game> getGames(@RequestParam GameStatus status){
        return this.getGamesService.getGameByStatus(status);
    }

}
