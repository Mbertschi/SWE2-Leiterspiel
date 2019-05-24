package UI;


import business.Player;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import persistence.PlayerList;
import java.io.IOException;

public class FXMLControllerScenePlayerListAndStartGame {

    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
        Router router = new Router();
        router.toNextScene(event,"SceneInitializePlayers");

    }

    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {
        Integer nameCounter = 0;
        Pane pane = Router.getInstance().getPane();
        for (Node child : pane.getChildren()) {
            if (child instanceof TextField) {
                String playerName = ((TextField) child).getText();
                Circle circle = Router.getInstance().getPlayerCircles().get(nameCounter);
                Player player = new Player(playerName, circle);
                player.addPlayertoList(player);
                nameCounter++;
            }

        }
       // PlayerList.getInstance().showList();
        Router.getInstance().toPlayfieldScene(event,"ScenePlayfield");

    }




    // ToDo : delete unused import classes

}
