package UI;

import business.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import persistence.PlayerList;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    private List<Circle> playerCircles;
    private void setPlayerCircles(Circle colorCircle) {
        this.playerCircles.add(colorCircle);
    }
    public List<Circle> getPlayerCircles() {
        return this.playerCircles;
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
        this.playerCircles = new ArrayList<>();

        for (int x = 0; x < amountPlayers; x++) {
            // add textfields
            Double xValue = 100.0;
            Double yValue = 180 + x * 40.0;
            Integer playerNumber = x + 1;
            TextField textfield = new TextField("Spieler"+ playerNumber);
            textfield.setLayoutX(xValue);
            textfield.setLayoutY(yValue);
            // add Circles
            Circle circle = new ColorCircle().createCircle();

            this.setPlayerCircles(circle);

            Double circleXValue = xValue - 30;
            Double circleYValue = yValue + 13.5;
            circle.setLayoutX(circleXValue);
            circle.setLayoutY(circleYValue);

            pane.getChildren().add(textfield);
            pane.getChildren().add(circle);
            this.setPane(pane);
            // add in setCircles
        }

        Scene windowScene = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(windowScene);
        window.show();
    }

    public void toPlayfieldScene(ActionEvent event, String fxmlScene)throws IOException {
        Dice dice = new Dice();
        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));

        Pane pane = new Pane();
        pane.getChildren().add(scene);

        // add Dice to Scene
        dice.setTranslateX(500);
        dice.setTranslateY(500);
        pane.getChildren().add(dice);

        GridPane playerPane = new GridPane();
        playerPane.setPrefHeight(350);
        playerPane.setPrefWidth(200);
        playerPane.setLayoutX(850);
        playerPane.setLayoutY(150);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setMinWidth(175);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(50);

        playerPane.getColumnConstraints().addAll(col1,col2);
        playerPane.getRowConstraints().addAll(row1,row2);

        Player player = new Player();

        for(int i = 0; i < PlayerList.getInstance().sizeOfList(); i++){

            player = player.getPlayer(i);

            Circle circle = player.getCircle();
            playerPane.setConstraints(circle, 0, i);
            playerPane.getChildren().addAll(circle);

            Label label = new Label();
            label.setText(player.getName());
            playerPane.setConstraints(label, 1, i);
            playerPane.getChildren().addAll(label);


        }

        pane.getChildren().add(playerPane);

        // add playField to Scene
        Playfield playfield = new Playfield();
        GridPane gp = playfield.CreateLevelOne();
        pane.getChildren().add(gp);


        Scene windowScene = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(windowScene);
        window.show();



    }





}
