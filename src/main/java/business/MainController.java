package business;


import UI.FXMLControllerScenePlayfield;
import UI.Router;
import com.sun.tools.javac.Main;
import persistence.PlayerList;
import java.util.List;

public class MainController {

        private FXMLControllerScenePlayfield fxmlControllerScenePlayfield;
        private int diceNumber;

        public MainController() {
        }

        public void initializePlayersOnFirstField() {
                this.fxmlControllerScenePlayfield = new FXMLControllerScenePlayfield();
                this.fxmlControllerScenePlayfield.initializeFirstPlayfieldCell(getPlayerList());
        }

        public void addValueOfRollDiceAndAddToPlayer(int diceNumber) {
                this.diceNumber = diceNumber;
                System.out.println("Der Wert des gewürfelten Werts beträgt: " + this.diceNumber);
                this.fxmlControllerScenePlayfield.addValueOfDiceToPlayer(this.diceNumber);
        }

        public List<Player> getPlayerList() {
                return PlayerList.getInstance().getPlayerList();
        }
}