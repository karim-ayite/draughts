package fr.codeflow.draughtsapi.utils;

import fr.codeflow.draughtsapi.domain.board.Square;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class BoardPrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void print(Square[][] board) {
        printBoard(board);
    }

    private void printBoard(Square[][] internationalRulesBoard) {
        var boardAsString = new StringBuilder("\n");

        for (int rowIndex = 0; rowIndex < Arrays.stream(internationalRulesBoard).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < internationalRulesBoard[rowIndex].length; columnIndex++) {

                var content = "   ";

                Square currentSquare = internationalRulesBoard[rowIndex][columnIndex];

                if (currentSquare.getPiece() != null ){
                    if (currentSquare.getPiece().isLightColor()){
                        content = " L ";
                    } else
                        content = " D ";
                }
                if (currentSquare.isActive()) {
                    boardAsString
                            .append(ANSI_BLACK_BACKGROUND)
                            .append(content)
                            .append(ANSI_RESET);
                } else {
                    boardAsString.append(ANSI_WHITE_BACKGROUND)
                            .append(content)
                            .append(ANSI_RESET);
                }
            }
            boardAsString.append("\n");
        }
        log.info(boardAsString.toString());
    }

}
