package business;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


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

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                Rectangle rt = playfieldCell.CreateCell();
                gridPane.setRowIndex(rt, row);
                gridPane.setColumnIndex(rt, col);
                this.gridPane.getChildren().addAll(rt);
            }
        }
        return this.gridPane;
    }

}
