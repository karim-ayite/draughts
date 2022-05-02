package fr.codeflow.draughtsapi.factories;

import fr.codeflow.draughtsapi.model.Board;
import fr.codeflow.draughtsapi.model.DraughtsRules;

import java.util.Optional;

public interface BoardFactory {

    Optional<Board> createBoard(DraughtsRules rules);
}
