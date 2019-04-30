package UI;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import business.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private int amountPlayerTextfield;

    @FXML
    private Button addAmountButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
        //label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");

        //addAmountButton.(continueAmountPlayerButton();
    }


    public void continueAmountPlayerButton() {
        MainController mainController = new MainController();
        mainController.SetAmountPlayer(amountPlayerTextfield);
    }

}