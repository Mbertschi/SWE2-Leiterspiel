package business;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class ColorCircle {

    public ColorCircle(){

    }




    public Circle createCircle(){
        Circle circle = new Circle();
        circle.setRadius(10);
        Random rand = new Random();
        Double r = rand.nextDouble();
        Double g = rand.nextDouble();
        Double b = rand.nextDouble();
        Color randomColor = new Color(r,g,b,1.0);
        circle.setFill(randomColor);
        circle.setStroke(Color.BLACK);
// set property color
        return circle;
    }

}

