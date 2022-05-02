package fr.codeflow.draughtsapi.factories;

import fr.codeflow.draughtsapi.model.DraughtsGame;
import fr.codeflow.draughtsapi.model.Player;

public interface GameFactory {

    DraughtsGame createGame(Player player1, Player player2);
}
