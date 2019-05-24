package business;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PlayfieldCell {

    public Group CreateCell(Integer cellId, Color color) {

        String cellValue = cellId.toString();

        Text text = new Text(cellValue);
        text.setLayoutX(5);
        text.setLayoutY(15);

        Group fieldCell = new Group();
        fieldCell.maxWidth(70);
        fieldCell.maxHeight(70);

        Rectangle rt = new Rectangle();
        rt.setId(cellValue);
        rt.setFill(color);
        rt.setStroke(Color.BLACK);
        rt.setWidth(60);
        rt.setHeight(60);

        fieldCell.getChildren().add(rt);
        fieldCell.getChildren().add(text);
        return fieldCell;
    }

}
