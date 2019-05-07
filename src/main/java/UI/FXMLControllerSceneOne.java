package UI;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.MainController;
import business.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;



public class FXMLControllerSceneOne {

    @FXML
    private Label label1;

    @FXML
    private TextField amountPlayerTextfield;

    @FXML
    private Button addAmountButton;

    @FXML
    private Button backToSceneTwo;

//    //@Override
//    public void initialize(URL url, ResourceBundle rb) {
//        addAmountButton.setOnAction((event) -> {
//            label1.setText("Button click hat funktioniert :)");
//            continueAmountPlayerButton();
//
//        });
//    }

    // Go to SceneTwo
    public void addAmountButton(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneTwoPlayerName.fxml"));

        Scene windowSceneTwo = new Scene(sceneTwo);
        // Stage Information

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneTwo);
        window.show();

    }
    //Go to SceneTree
    public void toSceneTree(ActionEvent event) throws IOException {
        Parent sceneTree = FXMLLoader.load(getClass().getResource("SceneTreePlayerList.fxml"));

        Scene windowSceneTwo = new Scene(sceneTree);
        // Stage Information

        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();

        window2.setScene(windowSceneTwo);
        window2.show();

    }

    //Back to SceneOne
    public void backToSceneOne(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("start.fxml"));

        Scene windowSceneTwo = new Scene(sceneTwo);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneTwo);
        window.show();

    }

    //Go to SceneFive
    public void toSceneFive(ActionEvent event) throws IOException {
        Parent sceneFive = FXMLLoader.load(getClass().getResource("SceneFivePlayField.fxml"));

        Scene windowSceneFive = new Scene(sceneFive);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneFive);
        window.show();

    }

    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneTwoPlayerName.fxml"));

        Scene windowSceneTwo = new Scene(sceneTwo);
        // Stage Information

        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();

        window2.setScene(windowSceneTwo);
        window2.show();

    }

    // Back to SceneSix
    public void toSceneSix(ActionEvent event) throws IOException {
        Parent sceneSix = FXMLLoader.load(getClass().getResource("SceneSixRankingAndRestart.fxml"));

        Scene windowSceneSix = new Scene(sceneSix);
        // Stage Information

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneSix);
        window.show();

    }





    private void continueAmountPlayerButton() {
        MainController mainController = new MainController();
        int amountPlayerValue = Integer.parseInt(amountPlayerTextfield.getText());
        mainController.SetAmountPlayer(amountPlayerValue);
    }
}

