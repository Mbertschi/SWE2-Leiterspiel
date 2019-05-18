package business;

import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Dice extends Pane {

 public static final int MAX_Value = 6;
 public static final int MIN_Value = 1;
 public  final SimpleIntegerProperty  valueProperty = new SimpleIntegerProperty();






    public  Dice(){

        Rectangle rect = new Rectangle(50,50);
        rect.setFill(Color.BLACK);
        Text text = new Text();
        text.setFill(Color.RED);
        this.setTranslateY(25);
        this.setTranslateX(25);
        text.textProperty().bind(valueProperty.asString());
        getChildren().addAll(rect,text);
        this.setOnMouseClicked(event -> roll());


    }

    public void roll(){
        RotateTransition rt = new RotateTransition(Duration.seconds(1),this);
        rt.setFromAngle(30);
        rt.setToAngle(360);
        rt.setOnFinished(event -> {
            valueProperty.set((int)(Math.random()*(MAX_Value-MIN_Value+1))+MIN_Value);});
        rt.play();

    }



}