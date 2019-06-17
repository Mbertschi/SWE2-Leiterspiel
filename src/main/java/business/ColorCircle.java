package business;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class ColorCircle {

    public ColorCircle() {
    }

    public Circle createCircle(Color playerColor){
        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setFill(playerColor);
        circle.setStroke(Color.BLACK);
        return circle;
    }

}

