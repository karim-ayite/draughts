package fr.codeflow.draughtsapi.model;

import lombok.Data;

@Data
public abstract class AbstractGame {

    protected Player player1;

    protected Player player2;
}
