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
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class FXMLControllerSceneOneInizialisizePlayers {

    // ToDo : Set error message on this label for output
    @FXML
    private Label errorMessage;

    @FXML
    private TextField amountPlayerTextfield;




    // Go to SceneTwo
    public void addAmountButton(ActionEvent event) throws IOException {

        String amountPlayerValue = amountPlayerTextfield.getText();

        // ToDo 1): Move this and from all the controller the same code into the router (param: nameScene.xml)
        // ToDo 2): Give the scenes and controllers a good name to understand without read their inside for what they are
        if(errorHandler(amountPlayerValue)) {
            // start
            Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneTreePlayerListAndStartGame.fxml"));

            Scene windowSceneTwo = new Scene(sceneTwo);
            // Stage Information

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(windowSceneTwo);
            window.show();
            //end
        }
        else {
            this.errorMessage.setText("ERROR: Eingabe überprüfen");

        }
    }

    // ToDo : Put this into the abstract class gamerules in the business layer
    private boolean errorHandler(String amountPlayer) {
        if(!amountPlayer.isEmpty()) {
            if(isNumeric(amountPlayer)) {
                Integer amountPlayerValue = Integer.valueOf(amountPlayer);
                if (amountPlayerValue >= 2 && amountPlayerValue <= 8) {
                    return true;
                } else {
                    return false;
                }
            }else{
               return false;
            }

        }
        else {
            return false;
        }
    }

    public static boolean isNumeric(String maybeNumeric){
        return maybeNumeric != null &&  maybeNumeric.matches("[0-9]+");

    }
    /*
    private void continueAmountPlayerButton() {
        MainController mainController = new MainController();
        int amountPlayerValue = Integer.parseInt(amountPlayerTextfield.getText());
        return mainController.SetAmountPlayer(amountPlayerValue);
    }
    */

    // private void ErrorHandler()
}

