package fr.codeflow.draughtsapi.factories;

import fr.codeflow.draughtsapi.model.DraughtsRules;
import fr.codeflow.draughtsapi.model.AbstractGame;
import fr.codeflow.draughtsapi.model.Player;

public interface GameFactory {

    AbstractGame createGame(Player player1, Player player2);
}
