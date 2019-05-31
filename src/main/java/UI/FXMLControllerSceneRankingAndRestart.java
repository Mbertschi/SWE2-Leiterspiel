package UI;

import javafx.event.ActionEvent;

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

