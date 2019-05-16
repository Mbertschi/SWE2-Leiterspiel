package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLControllerSceneTreePlayerListAndStartGame {
    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneOneInitializePlayers.fxml"));
        Scene windowSceneTwo = new Scene(sceneTwo);
        // Stage Information
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window2.setScene(windowSceneTwo);
        window2.show();

    }
    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {
        Parent sceneFive = FXMLLoader.load(getClass().getResource("SceneFivePlayField.fxml"));
        Scene windowSceneFive = new Scene(sceneFive);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(windowSceneFive);
        window.show();

    }
}
