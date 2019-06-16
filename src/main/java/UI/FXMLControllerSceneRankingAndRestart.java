package UI;

import business.Player;
import javafx.event.ActionEvent;
import persistence.PlayerList;

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
    public void closeApplication(){
        System.exit(0);
    }

    public void changeToLastScene() throws IOException {
        Router.getInstance().toLastScene("SceneRankingAndRestart");

    }


}

