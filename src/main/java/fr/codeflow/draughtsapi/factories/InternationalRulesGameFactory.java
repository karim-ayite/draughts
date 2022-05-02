package fr.codeflow.draughtsapi.factories;

import fr.codeflow.draughtsapi.model.DraughtsGame;
import fr.codeflow.draughtsapi.model.InternationalRulesGame;
import fr.codeflow.draughtsapi.model.Player;
import org.springframework.stereotype.Component;

@Component
public class InternationalRulesGameFactory implements GameFactory {

    private static final int NB_ROWS = 10;
    private static final int NB_COLUMNS = 10;
    
    @Override
    public DraughtsGame createGame(Player player1, Player player2) {
        DraughtsGame internationalRulesGame = new InternationalRulesGame();
        internationalRulesGame.setPlayer1(player1);
        internationalRulesGame.setPlayer2(player2);
        return internationalRulesGame;
    }
}
