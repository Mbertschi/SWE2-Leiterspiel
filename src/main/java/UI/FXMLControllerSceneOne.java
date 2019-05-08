package UI;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.MainController;
import business.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;



public class FXMLControllerSceneOne {

    @FXML
    private Label label1;

    @FXML
    private TextField amountPlayerTextfield;


    // Go to SceneTwo
    public void addAmountButton(ActionEvent event) throws IOException {
        Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneTwoPlayerName.fxml"));

        Scene windowSceneTwo = new Scene(sceneTwo);
        // Stage Information

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneTwo);
        window.show();

    }

    private void continueAmountPlayerButton() {
        MainController mainController = new MainController();
        int amountPlayerValue = Integer.parseInt(amountPlayerTextfield.getText());
        mainController.SetAmountPlayer(amountPlayerValue);
    }
}

