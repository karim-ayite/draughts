package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GenericBoardFactoryTest {

    private  BoardFactory boardFactory;

    @BeforeEach
    void setUp(){
        this.boardFactory = new GenericBoardFactory();
    }
    
    @Test
    //2.2. The game is played on the dark squares of the board. Thus, 50 squares are active.
    void Should_Have50ActiveSquare_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int nbActiveSquare = 0;
        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                var currentSquare = board[rowIndex][columnIndex];
                if (currentSquare.isActive()) {
                    nbActiveSquare++;
                }
            }
        }

        Assertions.assertEquals(50, nbActiveSquare);
    }

    @Test
    //2.2. The game is played on the dark squares of the board. Thus, 50 squares are active.
    void Should_Have100Squares_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int nbSquares = 0;
        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                nbSquares++;
            }
        }

        Assertions.assertEquals(100, nbSquares);
    }

    @Test
    //2.4. The board must be placed between the two players in such a way that the long diagonal starts at the left-hand side of each player. This way, the first square at the left hand, for each player is a dark square.
    void Should_Success_When_1SquareOn2IsActive() {

        var board = boardFactory.createSquare();

        var game = new Game();
        game.setBoard(board);

        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                if (board[rowIndex][columnIndex].isActive() && columnIndex+1 < board[rowIndex].length) {
                    Assertions.assertFalse(board[rowIndex][columnIndex + 1].isActive());
                }
            }
        }

    }

    @Test
    //2.2. The game is played on the dark squares of the board. Thus, 50 squares are active.
    void Should_HaveDarkSquareNumberFrom1To50_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int squareNumber = 0;
        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                var square = board[rowIndex][columnIndex];
                if (square.isActive()){ // A Dark square
                    squareNumber++;
                    Assertions.assertEquals(squareNumber, square.getNumber());
                }

            }
        }
    }

    @Test
    // 2.6.1. The numbers on the bases or promotion rows are numbered 1 through 5, and 46 through 50;
    void Should_HavePromotionRowNumbered1Through5_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int promotionRowIndex = 0;

        var square = board[promotionRowIndex][0];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(1, square.getNumber());
        }

        square = board[promotionRowIndex][board[promotionRowIndex].length-3];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(4, square.getNumber());
        }

        square = board[promotionRowIndex][board[promotionRowIndex].length-1];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(5, square.getNumber());
        }

    }

    @Test
    // 2.6.1. The numbers on the bases or promotion rows are numbered 1 through 5, and 46 through 50;
    void Should_HaveBaseRowNumbered46Through50_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int baseRowIndex = 9;

        var square = board[baseRowIndex][0];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(46, square.getNumber());
        }

        square = board[baseRowIndex][board[baseRowIndex].length-3];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(49, square.getNumber());
        }

        square = board[baseRowIndex][board[baseRowIndex].length-1];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(50, square.getNumber());
        }

    }

    @Test
    // 2.6.2. The 5 squares of the sides, or the first and the last columns, are numbered at the left
    //6-16-26-36-46 and at the right 5-15-25-35-45;
    void Should_HaveFirstColumnNumbered_6_16_26_36_46_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int firstColumnRow = 0;

        var square = board[0][firstColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(6, square.getNumber());
        }

        square = board[3][firstColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(16, square.getNumber());
        }

        square = board[5][firstColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(26, square.getNumber());
        }

        square = board[7][firstColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(36, square.getNumber());
        }

        square = board[9][firstColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(46, square.getNumber());
        }

    }

    @Test
    // 2.6.2. The 5 squares of the sides, or the first and the last columns, are numbered at the left
    //6-16-26-36-46 and at the right 5-15-25-35-45;
    void Should_HaveFirstColumnNumbered_5_15_25_35_45_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int lastColumnRow = 9;

        var square = board[0][lastColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(5, square.getNumber());
        }

        square = board[3][lastColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(15, square.getNumber());
        }

        square = board[5][lastColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(25, square.getNumber());
        }

        square = board[7][lastColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(35, square.getNumber());
        }

        square = board[9][lastColumnRow];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(45, square.getNumber());
        }
    }

    @Test
    // 2.6.3. The squares at the end of the long diagonal are numbered 5 and 46 and are called the corners of the board.
    void Should_HaveSquareAtTheEndOfLongDiagonalNumbered_5_46_When_InitIsOK() {

        var board = boardFactory.createSquare();


        var square = board[0][9];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(5, square.getNumber());
        }

        square = board[9][0];
        if (square.isActive()){ // A Dark square
            Assertions.assertEquals(46, square.getNumber());
        }
    }

    @Test
    // 2.7. International draughts is played with 20 white or light coloured men, and 20 black or dark coloured men.
    void Should_Have20LightMen_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int nbLightMen = 0;
        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                var square = board[rowIndex][columnIndex];
                if (square.isActive() && square.getPiece() != null && square.getPiece().isLightColor()){ // A Dark square
                    Assertions.assertTrue(square.getNumber() >= 31 && square.getNumber() <= 50);
                    nbLightMen++;
                }
            }
        }
        Assertions.assertEquals(20, nbLightMen);
    }

    @Test
    // 2.7. International draughts is played with 20 white or light coloured men, and 20 black or dark coloured men.
    void Should_Have20DarkMen_When_InitIsOK() {

        var board = boardFactory.createSquare();

        int nbDarkMen = 0;
        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                var square = board[rowIndex][columnIndex];
                if (square.isActive() && square.getPiece() != null && !square.getPiece().isLightColor()){ // A Dark square
                    Assertions.assertTrue(square.getNumber() >= 1 && square.getNumber() <= 20);
                    nbDarkMen++;
                }
            }
        }
        Assertions.assertEquals(20, nbDarkMen);
    }

    @Test
    // 2.8. At the start of the game, the 20 black men are put on the squares with the numbers 1 to 20 and the 20 white
    // men on those numbered 31 to 50. The squares with the numbers 21 to 30 are empty, or free.
    void Should_HaveSquareFrom21To30_When_InitIsOK() {

        var board = boardFactory.createSquare();

        for (int rowIndex = 0; rowIndex < Arrays.stream(board).count(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                var square = board[rowIndex][columnIndex];
                if (square.getNumber() >= 21 && square.getNumber() <= 30){ // A Dark square
                    Assertions.assertNull(square.getPiece());
                }
            }
        }
    }
}