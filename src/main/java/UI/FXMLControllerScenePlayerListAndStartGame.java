package UI;


import business.Player;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import persistence.PlayerList;
import java.io.IOException;

public class FXMLControllerScenePlayerListAndStartGame {

    Router router = new Router();
    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
       router.toNextScene(event,"SceneInitializePlayers");

    }
    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {


        Pane pane = Router.getInstance().getPane();
        for (Node child : pane.getChildren()) {
            if (child instanceof TextField) {
                String playerName = ((TextField) child).getText();
                Player player = new Player(playerName);
                player.addPlayertoList(player);

            }

        }
        PlayerList.getInstance().showList();
        router.toPlayfieldScene(event,"ScenePlayfield");

    }




    // ToDo : delete unused import classes

}
