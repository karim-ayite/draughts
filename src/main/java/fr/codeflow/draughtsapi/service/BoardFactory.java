package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.board.Square;

public interface BoardFactory {
    Square[][] createSquare();

}
