package business;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PlayfieldCell {

    public Group CreateCell(Integer cellId, Color color) {

        String cellValue = cellId.toString();

        Text text = new Text(cellValue);
        text.setLayoutX(15);
        text.setLayoutY(15);

        Group fieldCell = new Group();
        fieldCell.maxWidth(50);
        fieldCell.maxHeight(50);

        Rectangle rt = new Rectangle();
        rt.setId(cellValue);
        rt.setFill(color);
        rt.setStroke(Color.BLACK);
        rt.setWidth(50);
        rt.setHeight(50);

        fieldCell.getChildren().add(rt);
        fieldCell.getChildren().add(text);
        return fieldCell;
    }

}
