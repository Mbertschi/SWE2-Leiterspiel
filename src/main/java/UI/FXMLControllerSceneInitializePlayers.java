package UI;


import java.io.IOException;
import business.Converter;
import business.Rules;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;



public class FXMLControllerSceneInitializePlayers {

    // ToDo : Set error message on this label for output
    @FXML
    private Label errorMessage;

    @FXML
    private TextField amountPlayerTextfield;

    @FXML
    private TextField playerName;



    // Go to SceneTwo
    public void addAmountButton(ActionEvent event) throws IOException {

         String amountPlayerValue = amountPlayerTextfield.getText();

        // ToDo 1): Move this and from all the controller the same code into the router (param: nameScene.xml)
        if(Rules.validateNumberOfPlayer(amountPlayerValue)) {
            Integer amountPlayers = Converter.convertStringToInt(amountPlayerValue);
            Router router = Router.getInstance();
            router.toNextScene(event, "ScenePlayerListAndStartGame", amountPlayers);
        }
        else {
            this.errorMessage.setText("ERROR: Eingabe überprüfen");

        }
    }

    // ToDo : Put this into the abstract class gamerules in the business layer


}

