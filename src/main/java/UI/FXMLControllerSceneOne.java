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



public class FXMLControllerSceneOne {

    // ToDo : Set error message on this label for output
    @FXML
    private Label errorMessage;

    @FXML
    private TextField amountPlayerTextfield;



     String amountPlayerValue = amountPlayerTextfield.getText();
    // Go to SceneTwo
    public void addAmountButton(ActionEvent event) throws IOException {


        // ToDo : Implement method Error Handler for input check
        if(errorHandler(amountPlayerValue)) {
            Parent sceneTwo = FXMLLoader.load(getClass().getResource("SceneTreePlayerList.fxml"));

            Scene windowSceneTwo = new Scene(sceneTwo);
            // Stage Information

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(windowSceneTwo);
            window.show();
        }
        else {
            this.errorMessage.setText("ERROR: Eingabe überprüfen");

        }
    }

    // ToDo : Make check if amountPlayer is  not numerical
    private boolean errorHandler(String amountPlayer) {
        if(!amountPlayer.isEmpty()) {
            if(isNumeric(amountPlayer)) {
                // ToDo : here numerical check
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

