package fr.codeflow.draughtsapi.services;

import fr.codeflow.draughtsapi.model.Square;
import org.springframework.stereotype.Component;

@Component
public class BoardFactory {

    private static final int NB_ROWS = 10;
    private static final int NB_COLUMNS = 10;

    public Square[][] createSquare(){
       var  squares = new Square[NB_ROWS][NB_COLUMNS];

        for (int rowIndex=0;rowIndex<NB_ROWS;rowIndex++){
            for (int columnIndex=0;columnIndex<NB_COLUMNS;columnIndex = columnIndex+2){
                squares[rowIndex][columnIndex] = new Square();
            }
        }

        return squares;
    }
}
