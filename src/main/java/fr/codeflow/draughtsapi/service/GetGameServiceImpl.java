package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import fr.codeflow.draughtsapi.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetGameServiceImpl implements GetGamesService {

    private final GameRepository gameRepository;

    public GetGameServiceImpl(GameRepository gameRepository ) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getGameByStatus(GameStatus status) {
        return this.gameRepository.findGameByStatus(status);
    }

}
