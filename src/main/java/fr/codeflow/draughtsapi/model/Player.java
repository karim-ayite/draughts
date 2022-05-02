package fr.codeflow.draughtsapi.model;

import lombok.Data;

@Data
public class Player {
    private String username;
    private PieceColors pieceColor;
}
