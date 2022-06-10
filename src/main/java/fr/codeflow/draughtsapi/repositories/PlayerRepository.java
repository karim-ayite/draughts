package fr.codeflow.draughtsapi.repositories;

import fr.codeflow.draughtsapi.domain.player.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository  extends MongoRepository<Player,String> {
}
