package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.PiecesColor;

public interface CreateGameService {
    Game createGame(String playerId, PiecesColor piecesColor, String nickname);


}
