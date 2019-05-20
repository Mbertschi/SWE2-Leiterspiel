package business;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayfieldCell {

    public Rectangle CreateCell() {
        Rectangle rt = new Rectangle();
        rt.setStroke(Color.BLACK);
        rt.setFill(Color.WHITE);
        rt.setWidth(50);
        rt.setHeight(50);
        return rt;
    }

}
