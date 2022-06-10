package fr.codeflow.draughtsapi.service;

import fr.codeflow.draughtsapi.domain.board.Piece;
import fr.codeflow.draughtsapi.domain.board.Square;
import fr.codeflow.draughtsapi.domain.game.PiecesColor;
import fr.codeflow.draughtsapi.utils.BoardPrinter;
import org.springframework.stereotype.Component;

@Component
public class GenericBoardFactory implements BoardFactory {

    private static final int NB_ROWS = 10;
    private static final int NB_COLUMNS = 10;
    public static final int LIGHT_SQUARE_MIN_NUMBER = 31;
    public static final int LIGHT_SQUARE_MAX_NUMBER = 50;
    private static final int DARK_SQUARE_MIN_NUMBER = 1;
    private static final int DARK_SQUARE_MAX_NUMBER = 20;


    public Square[][] createSquare(){
       var  squares = new Square[NB_ROWS][NB_COLUMNS];
        int n = 1;
        int activateSquareNumber = 1;
        for (int rowIndex=0;rowIndex<NB_ROWS;rowIndex++){
            for (int columnIndex=0;columnIndex<NB_COLUMNS;columnIndex++){
                squares[rowIndex][columnIndex] = new Square();

                var currentSquare = squares[rowIndex][columnIndex];
                currentSquare.setActive(n % 2 == 0);

                if (currentSquare.isActive()) {
                    currentSquare.setNumber(activateSquareNumber);
                    activateSquareNumber++;
                }
                n++;
            }
            n++;
        }

        placePieces(squares);

        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.print(squares);

        return squares;
    }

    private void placePieces(Square[][] squares) {

        for (int rowIndex=0;rowIndex<NB_ROWS;rowIndex++){
            for (int columnIndex=0;columnIndex<NB_COLUMNS;columnIndex++){
                var currentSquare = squares[rowIndex][columnIndex];

                if (currentSquare.isActive() && isInColorInitialSquare(currentSquare,LIGHT_SQUARE_MIN_NUMBER,LIGHT_SQUARE_MAX_NUMBER)) {
                    Piece lightPiece = createPiece(PiecesColor.LIGHT);
                    currentSquare.setPiece(lightPiece);
                } else  if (currentSquare.isActive() && isInColorInitialSquare(currentSquare,DARK_SQUARE_MIN_NUMBER,DARK_SQUARE_MAX_NUMBER)) {
                    Piece lightPiece = createPiece(PiecesColor.DARK);
                    currentSquare.setPiece(lightPiece);
                }
            }
        }
    }

    private Piece createPiece(PiecesColor piecesColor) {
        Piece lightPiece = new Piece();
        lightPiece.setColor(piecesColor);
        lightPiece.setKing(false);
        return lightPiece;
    }

    private boolean isInColorInitialSquare(Square currentSquare, int squareMinNumber, int squareMaxNumber) {
        return currentSquare.getNumber() >= squareMinNumber && currentSquare.getNumber() <= squareMaxNumber;
    }
}
