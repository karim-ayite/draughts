package fr.codeflow.draughtsapi.factories;

import fr.codeflow.draughtsapi.model.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InternationalRulesBoardFactory implements BoardFactory {

    @Override
    public Optional<Board> createBoard(DraughtsRules rules) {
        if (DraughtsRules.INTERNATIONAL == rules) {
            var board = new InternationalRulesBoard();
            board.initBoard();
            return Optional.of(board);
        }
        return Optional.empty();
    }
}
