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

public class FXMLControllerSceneRankingAndRestart {
    Router router = new Router();
    public void backToSceneOne(ActionEvent event) throws IOException {
     router.toNextScene(event, "SceneInitializePlayers");

    }
    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {
     Router.getInstance().toNextScene(event,"ScenePlayfield");

    }

    //Applikation beenden


}

