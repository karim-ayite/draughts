package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import fr.codeflow.draughtsapi.domain.game.PiecesColor;
import fr.codeflow.draughtsapi.domain.player.Player;
import fr.codeflow.draughtsapi.repositories.GameRepository;
import fr.codeflow.draughtsapi.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateGameServiceImpl implements CreateGameService {

    private final GameRepository gameRepository;
    private final BoardFactory boardFactory;

    private final PlayerRepository playerRepository;

    public CreateGameServiceImpl(GameRepository gameRepository, BoardFactory boardFactory, PlayerRepository playerRepository){
        this.gameRepository = gameRepository;
        this.boardFactory = boardFactory;
        this.playerRepository = playerRepository;
    }

    @Override
    public Game createGame(String playerId, PiecesColor piecesColor, String nickname) {
        var playerIdToSave = playerId;

        if (playerId == null){
            var guestPlayer = new Player();
            guestPlayer.setNickname(nickname);
            guestPlayer = playerRepository.save(guestPlayer);
            playerIdToSave = guestPlayer.getId();
        }

        var newGame = new Game();
        newGame.setCreationDate(LocalDateTime.now());
        newGame.setPlayer1Id(playerIdToSave);
        newGame.setPlayer1PiecesColor(piecesColor);
        newGame.setStatus(GameStatus.WAITING_FOR_PLAYER);
        newGame.setBoard(boardFactory.createSquare());

        return  this.gameRepository.save(newGame);
    }


}
