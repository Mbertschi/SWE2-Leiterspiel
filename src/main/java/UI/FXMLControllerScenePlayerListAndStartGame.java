package UI;


import business.Player;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.IOException;

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
                Color color = Router.getInstance().getPlayerColors().get(counter);
                // Player 1 will be the first one who will be in turn when game starts
                Boolean firstTurn = false;
                if(playerNumber == 1) {
                    firstTurn = true;
                }
                Player player = new Player(playerNumber, playerName, color, playerPlayFieldCellNumber, firstTurn);
                player.addPlayertoList(player);
                counter++;
            }
        }
        Router.getInstance().toPlayfieldScene(event,"ScenePlayfield");
    }
    // ToDo : delete unused import classes
}
