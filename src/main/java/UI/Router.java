package UI;

import business.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

    @FXML
    private List<Circle> playerCircles;
    public void setPlayerCircles(List<Circle> playerCircles) {
        this.playerCircles = playerCircles;
    }
    public List<Circle> getPlayerCircles() {
        return this.playerCircles;
    }

    @FXML
    private List<Color> playerColors;
    private void setPlayerColors(Color playerColor) {
        this.playerColors.add(playerColor);
    }
    public List<Color> getPlayerColors() {
        return this.playerColors;
    }

    @FXML
    private GridPane playField;
    private void setPlayField(GridPane playfield) {
        this.playField = playfield;
    }
    public GridPane getPlayField() {
        return this.playField;
    }

    @FXML
    private GridPane playerPane;
    private void setPlayerPane(GridPane playerPane) {
        this.playerPane = playerPane;
    }
    public GridPane getPlayerPane() {
        return this.playerPane;
    }

    private Dice dice;
    private void setDice(Dice dice) {
        this.dice = dice;
    }
    public Dice getDice() {
        return this.dice;
    }

    public void toNextScene(ActionEvent event, String fxmlScene)throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        Scene windowScene = new Scene(scene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowScene);
        window.show();
    }

    public void changeToLastScene() throws IOException {
        FXMLControllerSceneRankingAndRestart fxmlControllerSceneRankingAndRestart = new FXMLControllerSceneRankingAndRestart();
        fxmlControllerSceneRankingAndRestart.changeToLastScene();
    }

    public void toLastScene(String fxmlScene) throws IOException {
        Pane pane = new Pane();
        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));

        Stage window = new Stage();
        GridPane playerPane = new GridPane();
        playerPane.setLayoutX(110);
        playerPane.setLayoutY(280);
        playerPane.setMinHeight(300);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(30);
        playerPane.getColumnConstraints().addAll(col1);

        int i = 1;
        for (Player playerRanking : PlayerList.getInstance().getRankingList()){

            Label label = new Label(i + ". " + playerRanking.getName());

            // set the column constraint
            playerPane.setConstraints(label, 0, i);
            playerPane.getChildren().addAll(label);
            i++;
        }

        pane.getChildren().add(playerPane);
        pane.getChildren().add(scene);
        Scene windowScene = new Scene(pane);
        window.setScene(windowScene);
        window.show();
    }

    public void toNextScene(ActionEvent event, String fxmlScene, Integer amountPlayers)throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        // new add textfield to pane

        Pane pane = new Pane();
        pane.getChildren().add(scene);
        this.playerColors = new ArrayList<>();

        for (int x = 0; x < amountPlayers; x++) {
            // add textfields
            Double xValue = 100.0;
            Double yValue = 180 + x * 40.0;
            Integer playerNumber = x + 1;
            TextField textfield = new TextField("Spieler"+ playerNumber);
            textfield.setLayoutX(xValue);
            textfield.setLayoutY(yValue);
            // add Circles


            // ToDo : put this in a other class or function
            Random rand = new Random();
            Double r = rand.nextDouble();
            Double g = rand.nextDouble();
            Double b = rand.nextDouble();
            Color randomColor = new Color(r,g,b,1.0);
            this.setPlayerColors(randomColor);
            Circle circle = new ColorCircle().createCircle(randomColor);


            Double circleXValue = xValue - 30;
            Double circleYValue = yValue + 13.5;
            circle.setLayoutX(circleXValue);
            circle.setLayoutY(circleYValue);

            pane.getChildren().addAll(textfield, circle);
            this.setPane(pane);
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
        dice.setTranslateX(810);
        dice.setTranslateY(480);
        pane.getChildren().add(dice);
        this.setDice(dice);

        GridPane playerPane = new GridPane();
        playerPane.setPrefHeight(250);
        playerPane.setPrefWidth(130);
        playerPane.setLayoutX(810);
        playerPane.setLayoutY(140);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setMinWidth(100);
        playerPane.getColumnConstraints().addAll(col1,col2);

        Player player = new Player();

        // add playField to Scene
        Playfield playfield = new Playfield();
        GridPane playfieldGridPane = playfield.CreateLevelOne();

        for(int i = 0; i < PlayerList.getInstance().sizeOfList(); i++){

            RowConstraints row1 = new RowConstraints();
            row1.setMinHeight(40);
            playerPane.getRowConstraints().addAll(row1);

            player = player.getPlayer(i);

            Circle playerCircle = new ColorCircle().createCircle(player.getPlayerColor());
            playerPane.setConstraints(playerCircle, 0, i);
            playerPane.getChildren().addAll(playerCircle);

            Label label = new Label();
            label.setText(player.getName());
            playerPane.setConstraints(label, 1, i);
            playerPane.getChildren().addAll(label);
        }

        pane.getChildren().add(playerPane);
        this.setPlayerPane(playerPane);
        pane.getChildren().add(playfieldGridPane);
        this.setPlayField(playfieldGridPane);

        Scene windowScene = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(windowScene);
        window.show();

        MainController mainController = new MainController();
        mainController.initializePlayersOnFirstField();

    }



}
