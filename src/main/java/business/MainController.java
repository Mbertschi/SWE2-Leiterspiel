package business;


import UI.Router;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MainController {

        @FXML
        GridPane playfield;
        Dice dice;

        public MainController(){
        }

        public void getValueOfRollDiceAndAddToPlayer(int diceNumber) {
                Router router = Router.getInstance();
                this.dice = router.getDice();
                this.playfield = router.getPlayField();
                System.out.println("Der Wert des gewürfelten Werts beträgt: " + diceNumber);
        }
}