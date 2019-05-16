package UI;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.MainController;
import business.Player;
import business.Rules;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class FXMLControllerSceneOneInitializePlayers {

    // ToDo : Set error message on this label for output
    @FXML
    private Label errorMessage;

    @FXML
    private TextField amountPlayerTextfield;

    @FXML
    private TextField playerName;



    // Go to SceneTwo
    public  void addAmountButton(ActionEvent event) throws IOException {

         String amountPlayerValue = amountPlayerTextfield.getText();

        // ToDo 1): Move this and from all the controller the same code into the router (param: nameScene.xml)

        if(Rules.validateNumberOfPlayer(amountPlayerValue)) {

            Router router =new Router();
            router.toNextScene(event, "SceneTreePlayerListAndStartGame");

            Player player = new Player("");

            player.createPlayer(amountPlayerValue);
        }
        else {
            this.errorMessage.setText("ERROR: Eingabe überprüfen");

        }
    }

    // ToDo : Put this into the abstract class gamerules in the business layer



    /*
    private void continueAmountPlayerButton() {
        MainController mainController = new MainController();
        int amountPlayerValue = Integer.parseInt(amountPlayerTextfield.getText());
        return mainController.SetAmountPlayer(amountPlayerValue);
    }
    */

    // private void ErrorHandler()
}

