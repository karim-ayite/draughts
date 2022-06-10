package fr.codeflow.draughtsapi.domain.game;


import fr.codeflow.draughtsapi.domain.board.Square;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Game {

    @Id
    private String id;

    private String player1Id;

    private String player2Id;

    private PiecesColor player1PiecesColor;

    private LocalDateTime creationDate;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int turnDurationInSeconds;

    private GameStatus status;

    private Square[][] board;

}
