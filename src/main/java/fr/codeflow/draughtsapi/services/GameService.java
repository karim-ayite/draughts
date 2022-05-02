package fr.codeflow.draughtsapi.services;

import fr.codeflow.draughtsapi.factories.InternationalRulesGameFactory;
import fr.codeflow.draughtsapi.model.AbstractGame;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private InternationalRulesGameFactory gameFactory;

    public AbstractGame createNewGame(NewGameRequest newGameRequest) {
        return gameFactory.createGame(newGameRequest.getPlayer1(),newGameRequest.getPlayer2());
    }
}
