package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;

import java.util.List;

public interface GetGamesService {

    List<Game> getGameByStatus(GameStatus status);

}
