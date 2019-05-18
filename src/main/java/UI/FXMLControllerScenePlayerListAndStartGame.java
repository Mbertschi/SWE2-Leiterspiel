package UI;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLControllerScenePlayerListAndStartGame {

    Router router = new Router();
    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
       router.toNextScene(event,"SceneInitializePlayers");

    }
    //Go to SceneFive
    public void goToSceneFive(ActionEvent event) throws IOException {

        List<String> playerNames = new ArrayList<>();
        Pane pane = Router.getInstance().getPane();
        for (Node child : pane.getChildren()) {
            if (child instanceof TextField) {
                // ToDo : Save in Persistence from mainController in business
                String playerName = ((TextField) child).getText();
                playerNames.add(playerName);
            }
        }
        System.out.println(playerNames);
        router.toPlayfielScene(event,"ScenePlayfield");
    }




    // ToDo : delete unused import classes

}
