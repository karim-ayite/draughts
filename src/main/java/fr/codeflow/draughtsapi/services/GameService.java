package fr.codeflow.draughtsapi.services;

import fr.codeflow.draughtsapi.factories.InternationalRulesBoardFactory;
import fr.codeflow.draughtsapi.model.DraughtsGame;
import fr.codeflow.draughtsapi.model.InternationalRulesGame;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private InternationalRulesBoardFactory internationalRulesBoardFactory;

    public DraughtsGame createNewGame(NewGameRequest newGameRequest) {
        InternationalRulesGame internationalRulesGame = new InternationalRulesGame();
        internationalRulesGame.setPlayer1(newGameRequest.getPlayer1());
        internationalRulesGame.setPlayer2(newGameRequest.getPlayer2());
        internationalRulesGame.setBoard(internationalRulesBoardFactory.createBoard(newGameRequest.getRules()).orElseThrow());
        return internationalRulesGame;
    }
}
