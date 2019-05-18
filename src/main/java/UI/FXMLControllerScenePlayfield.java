package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLControllerScenePlayfield {
    Router router = new Router();
    public void toSceneSix(ActionEvent event) throws IOException {
     router.toNextScene(event,"SceneRankingAndRestart");

    }


}
