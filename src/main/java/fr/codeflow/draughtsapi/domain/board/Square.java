package fr.codeflow.draughtsapi.domain.board;

import lombok.Data;

@Data
public class Square {

    private int number;
    private boolean active;
    private Piece piece;

}
