package UI;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.MainController;
import business.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class FXMLController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private TextField amountPlayerTextfield;

    @FXML
    private Button addAmountButton;

    @FXML


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addAmountButton.setOnAction((event) -> {
            label1.setText("Button click hat funktioniert :)");
            continueAmountPlayerButton();

        });
    }





    private void continueAmountPlayerButton() {
        MainController mainController = new MainController();
        int amountPlayerValue = Integer.parseInt(amountPlayerTextfield.getText());
        mainController.SetAmountPlayer(amountPlayerValue);
    }
}