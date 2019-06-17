package business;


import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import persistence.DataFieldState;


public class Playfield {

    private GridPane gridPane;

    public GridPane CreateLevelOne() {

        PlayfieldCell playfieldCell = new PlayfieldCell();
        this.gridPane = new GridPane();
        this.gridPane.setLayoutX(100);
        this.gridPane.setLayoutY(150);
        this.gridPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Integer rowNum = 6;
        Integer colNum = 10;
        Integer cellNumber = 60;
        Integer backWardCell = 9;


        for (int row = 0; row < rowNum; row++) {

            for (int col = 0; col < colNum; col++) {

                Group fieldCell = playfieldCell.CreateCell(cellNumber, Color.WHITE);

                switch(cellNumber) {
                    case 1: fieldCell = playfieldCell.CreateCell(cellNumber, Color.LIGHTGREEN);
                        break;
                    // Latter 1
                    case 4: fieldCell = playfieldCell.CreateCell(cellNumber, Color.DARKOLIVEGREEN);
                        break;
                    case 25: fieldCell = playfieldCell.CreateCell(cellNumber, Color.DARKOLIVEGREEN);
                        break;
                    // Latter 2
                    case 12: fieldCell = playfieldCell.CreateCell(cellNumber, Color.DARKGREEN);
                        break;
                    case 33: fieldCell = playfieldCell.CreateCell(cellNumber, Color.DARKGREEN);
                        break;
                    // Snake 1
                    case 20: fieldCell = playfieldCell.CreateCell(cellNumber, Color.INDIANRED);
                        break;
                    case 38: fieldCell = playfieldCell.CreateCell(cellNumber, Color.INDIANRED);
                        break;
                    // Snake 2
                    case 27: fieldCell = playfieldCell.CreateCell(cellNumber, Color.RED);
                        break;
                    case 45: fieldCell = playfieldCell.CreateCell(cellNumber, Color.RED);
                        break;
                    // Snake 3
                    case 37: fieldCell = playfieldCell.CreateCell(cellNumber, Color.DARKRED);
                        break;
                    case 55: fieldCell = playfieldCell.CreateCell(cellNumber, Color.DARKRED);
                        break;
                    case 60: fieldCell = playfieldCell.CreateCell(cellNumber, Color.LIGHTGREEN);
                        break;
                    default: break;
                }

                if(row == 1 || row == 3 || row == 5) {
                    this.gridPane.setConstraints(fieldCell, backWardCell, row);
                    this.gridPane.getChildren().addAll(fieldCell);
                    backWardCell = backWardCell - 1;
                }
                else {
                    backWardCell = 9;
                    this.gridPane.setConstraints(fieldCell, col, row);
                    this.gridPane.getChildren().addAll(fieldCell);
                }
                cellNumber = cellNumber - 1;
            }
        }

        return this.gridPane;
    }



    // Console

    public int getStartField() {
        return startField;
    }



    private int startField = 1;

    public int getFinishField() {
        return finishField;
    }



    private int finishField = 60;

    public int getField( int x){


        return DataFieldState.getInstance().showList(x);
    }

    public void addDefaultfield(int i){


        for(int x=0; x==i; x++) {
            DataFieldState.getInstance().addStartfield();
        }
    }

}