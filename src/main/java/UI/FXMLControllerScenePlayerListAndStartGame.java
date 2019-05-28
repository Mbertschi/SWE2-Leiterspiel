package UI;


import business.Player;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import persistence.PlayerList;
import java.io.IOException;
import java.util.List;

public class FXMLControllerScenePlayerListAndStartGame {

    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
        Router router = new Router();
        router.toNextScene(event,"SceneInitializePlayers");
    }

    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {
        Integer counter = 0;
        Integer playerNumber;
        Integer playerPlayFieldCellNumber = 1;
        Pane pane = Router.getInstance().getPane();
        for (Node child : pane.getChildren()) {
            if (child instanceof TextField) {
                playerNumber = counter + 1;
                String playerName = ((TextField) child).getText();
                Circle circle = Router.getInstance().getPlayerCircles().get(counter);
                Player player = new Player(playerNumber, playerName, circle, playerPlayFieldCellNumber);
                player.addPlayertoList(player);
                counter++;
            }
        }
        Router.getInstance().toPlayfieldScene(event,"ScenePlayfield");
    }
    // ToDo : delete unused import classes
}
