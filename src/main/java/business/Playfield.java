package business;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;


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
                    case 4: fieldCell = playfieldCell.CreateCell(cellNumber, Color.GREEN);
                            break;
                    case 10: fieldCell = playfieldCell.CreateCell(cellNumber, Color.YELLOW);
                        break;
                    case 20: fieldCell = playfieldCell.CreateCell(cellNumber, Color.PINK);
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

        Text text = new Text("BLABLABLA");
        this.gridPane.getChildren().addAll(text);
        return this.gridPane;
    }

}