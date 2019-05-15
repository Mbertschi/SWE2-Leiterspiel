package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;

public class FXMLControllerSceneSixRankingAndRestart {
    //Back to SceneOne
    public void backToSceneOne(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneOneInizilisizePlayers.fxml"));

        Scene windowSceneTwo = new Scene(sceneTwo);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneTwo);
        window.show();

    }
    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {
        Parent sceneFive = FXMLLoader.load(getClass().getResource("SceneFivePlayField.fxml"));
        Scene windowSceneFive = new Scene(sceneFive);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(windowSceneFive);
        window.show();

    }

    //Applikation beenden


}

