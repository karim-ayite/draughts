package fr.codeflow.draughtsapi.services;

import fr.codeflow.draughtsapi.model.DraughtsGame;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private BoardFactory boardFactory;

    public DraughtsGame createNewGame(NewGameRequest newGameRequest) {
        DraughtsGame internationalRulesGame = new DraughtsGame();
        internationalRulesGame.setPlayer1(newGameRequest.getPlayer1());
        internationalRulesGame.setPlayer2(newGameRequest.getPlayer2());
        internationalRulesGame.setBoard(boardFactory.createSquare());
        return internationalRulesGame;
    }
}
