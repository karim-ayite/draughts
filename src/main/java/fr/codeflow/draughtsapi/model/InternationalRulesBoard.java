package fr.codeflow.draughtsapi.model;

public class InternationalRulesBoard extends Board {

    private static final int NB_ROWS = 10;
    private static final int NB_COLUMNS = 10;

    @Override
    public void initBoard() {
        this.squares = new Square[NB_ROWS][NB_COLUMNS];

        for (int rowIndex=0;rowIndex<NB_ROWS;rowIndex++){
            for (int columnIndex=0;columnIndex<NB_COLUMNS;columnIndex = columnIndex+2){
                this.squares[rowIndex][columnIndex] = new Square();
            }
        }
    }
}
