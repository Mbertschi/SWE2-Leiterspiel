package business;


import UI.FXMLControllerScenePlayfield;
import persistence.PlayerList;

import java.util.List;

public class MainController {

        public MainController(){
        }

        public void getValueOfRollDiceAndAddToPlayer(int diceNumber) {
                FXMLControllerScenePlayfield fxmlControllerScenePlayfield = new FXMLControllerScenePlayfield();
                fxmlControllerScenePlayfield.setPlayersOnFirstCell();
                System.out.println("Der Wert des gewürfelten Werts beträgt: " + diceNumber);
        }

        public List<Player> getPlayerList() {
                return PlayerList.getInstance().getPlayerList();
        }
}