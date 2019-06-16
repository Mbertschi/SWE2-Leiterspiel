package business;


import UI.FXMLControllerScenePlayfield;
import UI.Router;
import persistence.PlayerList;

import java.io.IOException;
import java.util.List;

public class MainController {

        private FXMLControllerScenePlayfield fxmlControllerScenePlayfield = new FXMLControllerScenePlayfield();
        private int diceNumber;

        public MainController() {
        }

        public void initializePlayersOnFirstField() {
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

        public void routeChangeToLastScene() {
                try {
                        Router.getInstance().changeToLastScene();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}