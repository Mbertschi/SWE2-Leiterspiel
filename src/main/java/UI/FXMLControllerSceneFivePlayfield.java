package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLControllerSceneFivePlayfield {
    // To SceneSix
    public void toSceneSix(ActionEvent event) throws IOException {
        Parent sceneSix = FXMLLoader.load(getClass().getResource("SceneSixRankingAndRestart.fxml"));

        Scene windowSceneSix = new Scene(sceneSix);
        // Stage Information

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneSix);
        window.show();

    }
}
