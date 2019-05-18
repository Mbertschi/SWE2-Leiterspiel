package UI;

import business.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLControllerScenePlayfield {

    @FXML
    Pane pane;
    Router router = new Router();





    public void toSceneSix(ActionEvent event) throws IOException {
     router.toNextScene(event,"SceneRankingAndRestart");

    }



}
