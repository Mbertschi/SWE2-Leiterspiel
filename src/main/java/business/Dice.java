package business;

import UI.FXMLControllerScenePlayfield;
import com.sun.tools.javac.Main;
import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Dice extends Pane {

    private static final int MAX_Value = 6;
    private static final int MIN_Value = 1;
    private final SimpleIntegerProperty valueProperty = new SimpleIntegerProperty();
    private Text text;
    private Rectangle rect;
    MainController mainController = new MainController();

    public Dice() {
        rect = new Rectangle(65,65);
        rect.setFill(Color.BLACK);
        text = new Text();
        text.setFill(Color.WHITE);
        text.setLayoutY(42);
        text.setLayoutX(25);
        text.setFont(Font.font("Verdana", 25));
        this.setTranslateY(50);
        this.setTranslateX(50);

        text.textProperty().bind(this.valueProperty.asString());
        getChildren().addAll(rect,text);
        this.setOnMouseClicked(event -> roll());
    }

    public void roll() {
        RotateTransition rt = new RotateTransition(Duration.seconds(0.2),this);
        rt.setFromAngle(30);
        rt.setToAngle(360);
        int randomNumber = (int)(Math.random()*(MAX_Value-MIN_Value+1))+MIN_Value;

        rt.setOnFinished(event -> {
            this.valueProperty.set(randomNumber);
        });

        rt.play();

        this.mainController.addValueOfRollDiceAndAddToPlayer(randomNumber);
    }
}