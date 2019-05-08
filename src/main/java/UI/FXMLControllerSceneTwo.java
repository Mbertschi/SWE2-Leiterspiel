package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLControllerSceneTwo {
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
}
