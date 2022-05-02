package fr.codeflow.draughtsapi.model;

import lombok.Data;

@Data
public abstract class Board {

    protected Square[][] squares;

    public abstract void initBoard();

}
