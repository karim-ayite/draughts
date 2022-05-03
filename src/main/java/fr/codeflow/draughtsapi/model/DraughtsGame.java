package fr.codeflow.draughtsapi.model;

import lombok.Data;

@Data
public class DraughtsGame {

    private Player player1;

    private Player player2;

    private Square[][] board;


}
