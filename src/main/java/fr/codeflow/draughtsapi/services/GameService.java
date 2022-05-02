package fr.codeflow.draughtsapi.services;

import fr.codeflow.draughtsapi.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public Game createNewGame(Game game){
        return new Game();
    }
}
