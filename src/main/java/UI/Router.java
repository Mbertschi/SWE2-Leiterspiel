package UI;

import business.Dice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



import java.io.IOException;
import java.util.Random;

public class Router {

    private static Router setInstance = new Router();
    public static Router getInstance() {
        return setInstance;
    }

    @FXML
    private Pane dynamicPane;

    private void setPane(Pane pane) {
        this.dynamicPane = pane;
    }

    public Pane getPane() {
        return this.dynamicPane;
    }

    public void toNextScene(ActionEvent event, String fxmlScene)throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        Scene windowScene = new Scene(scene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowScene);
        window.show();
    }

    public void toNextScene(ActionEvent event, String fxmlScene, Integer amountPlayers)throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        // new add textfield to pane

        Pane pane = new Pane();
        pane.getChildren().add(scene);

        for (int x = 0; x < amountPlayers; x++) {
            // add circles
            Circle circle = new Circle();
            circle.setRadius(10);
            Random rand = new Random();
            Double r = rand.nextDouble();
            Double g = rand.nextDouble();
            Double b = rand.nextDouble();
            Color randomColor = new Color(r,g,b,1.0);
            circle.setFill(randomColor);
            circle.setStroke(Color.BLACK);

            // add textfields
            Double xValue = 100.0;
            Double yValue = 180 + x * 40.0;
            Integer playerNumber = x + 1;
            TextField textfield = new TextField("Spieler " + playerNumber);
            textfield.setLayoutX(xValue);
            textfield.setLayoutY(yValue);

            Double circleXValue = xValue - 30;
            Double circleYValue = yValue + 13.5;
            circle.setLayoutX(circleXValue);
            circle.setLayoutY(circleYValue);

            pane.getChildren().add(textfield);
            pane.getChildren().add(circle);
            this.setPane(pane);
        }



        Scene windowScene = new Scene(pane);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowScene);
        window.show();
    }

    public void toPlayfielScene(ActionEvent event, String fxmlScene)throws IOException {
        Dice dice = new Dice();
        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        // add Dice to Scene

        Pane pane = new Pane();
        pane.getChildren().add(scene);

        dice.setTranslateX(800);
        dice.setTranslateY(800);
        pane.getChildren().add(dice);





        Scene windowScene = new Scene(pane);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowScene);
        window.show();
    }





}
