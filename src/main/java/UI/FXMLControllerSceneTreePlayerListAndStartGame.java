package UI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLControllerSceneTreePlayerListAndStartGame {
    // Back to SceneTwo
    public void backToSceneTwo(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneOneInitializePlayers.fxml"));
        Scene windowSceneTwo = new Scene(sceneTwo);
        // Stage Information
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window2.setScene(windowSceneTwo);
        window2.show();

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
    }

    // ToDo : change methods to the router
    // ToDo : add image as playrules (römisch) to scene
    // ToDo : Refactor scene name
    // ToDo : delete unused import classes

}
