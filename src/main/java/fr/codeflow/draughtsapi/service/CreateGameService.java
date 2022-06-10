package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import fr.codeflow.draughtsapi.domain.game.PiecesColor;

import java.util.List;

public interface CreateGameService {
    Game createGame(String playerId, PiecesColor piecesColor, String nickname);


}
