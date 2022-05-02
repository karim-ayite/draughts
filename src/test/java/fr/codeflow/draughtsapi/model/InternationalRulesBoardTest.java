package fr.codeflow.draughtsapi.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.codeflow.draughtsapi.JSonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class InternationalRulesBoardTest {

    @Test
    //2.2. The game is played on the dark squares of the board. Thus, 50 squares are active.
    public void Should_Have50ActiveSquare_When_InitIsOK() {
        InternationalRulesBoard internationalRulesBoard = new InternationalRulesBoard();
        internationalRulesBoard.initBoard();

        System.out.print(JSonUtils.asPrettyJsonString(internationalRulesBoard));

        int nbActiveSquare = 0;
        for (int rowIndex = 0; rowIndex < Arrays.stream(internationalRulesBoard.getSquares()).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < internationalRulesBoard.getSquares()[rowIndex].length; columnIndex++) {
                var currentSquare = internationalRulesBoard.getSquares()[rowIndex][columnIndex];
                if (currentSquare != null) {
                    nbActiveSquare++;
                }
            }
        }

        Assertions.assertEquals(50, nbActiveSquare);
    }

}