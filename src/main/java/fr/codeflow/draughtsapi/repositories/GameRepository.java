package fr.codeflow.draughtsapi.repositories;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameRepository extends MongoRepository<Game,String> {
    List<Game> findGameByStatus(GameStatus status);
}
