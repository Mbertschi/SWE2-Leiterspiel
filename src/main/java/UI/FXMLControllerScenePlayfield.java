package UI;

import business.Converter;
import business.Player;
import business.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import persistence.PlayerList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLControllerScenePlayfield {

    @FXML
    private GridPane playfield;
    private void setPlayfield(GridPane playfield) {
        this.playfield = playfield;
    }
    private GridPane getPlayfield() {
        return this.playfield;
    }

    private boolean firstTurn = true;

    // ToDo : Create List with colorCircles and PlayerNumbers
    private List<Circle> playerCircles = new ArrayList<>();
    private void setPlayerCircles(Circle playerCircle) {
        this.playerCircles.add(playerCircle);
    }
    private List<Circle> getPlayerCircles() {
        return this.playerCircles;
    }

    public FXMLControllerScenePlayfield() {
    }

    public void initializeFirstPlayfieldCell(List<Player> fieldPlayers) {

        setPlayfield(Router.getInstance().getPlayField());
        Group fieldGroup = getFieldGroupFromPlayfield(this.playfield, 1);

        int i = 1;
        for(Player player : fieldPlayers){

            Circle playerCircle = new ColorCircle().createCircle(player.getPlayerColor());
            playerCircle.setRadius(6);
            playerCircle.setLayoutY(30);
            playerCircle.setLayoutX(i * 6);
            playerCircle.setId(player.getPlayerNumber().toString());

            setPlayerCircles(playerCircle);

            fieldGroup.getChildren().addAll(playerCircle);

            PlayerList.getInstance().setPlayerNumbers(player);
            i++;
        }
        Router.getInstance().setPlayerCircles(this.getPlayerCircles());
    }

    public void addValueOfDiceToPlayer(int diceNumber) {
        if(firstTurn) {
            Player player = this.getFirstPlayer();
            this.setPlayerOnNewField(player, diceNumber);
        }
        else {
            Player player = this.getPlayerWhoIsInTurn();
            this.setPlayerOnNewField(player, diceNumber);
        }

    }

    private void setPlayerOnNewField(Player player, int diceNumber) {
        Integer newPlayerFieldNumber = player.getPlayerPlayFieldCellNumber() + diceNumber;

        boolean lastField = false;
        if(newPlayerFieldNumber >= 60) {
            newPlayerFieldNumber = 60;
            lastField = true;
        }

        Group fieldGroup = getFieldGroupFromPlayfield(Router.getInstance().getPlayField(), newPlayerFieldNumber);
        // ToDo : Delete the user of the playerList when he wins and if there is only one player last standing -> game is over
        List<Circle> playerCircles = Router.getInstance().getPlayerCircles();

        for(Circle circle : playerCircles) {

            Integer circleNumber = Integer.valueOf(circle.getId());
            Integer playerNumber = player.getPlayerNumber();

            if(circleNumber == playerNumber) {
                System.out.println("Fieldnumber: " + newPlayerFieldNumber);

                // Check if player has now more than the last playfield cell
                if(lastField) {
                    PlayerList.getInstance().RemovePlayerFromList(player);
                    lastField = false;
                }
                else {
                    // ToDo : handle with specialfield
                    player.setPlayerPlayFieldCellNumber(newPlayerFieldNumber);
                }
                fieldGroup.getChildren().addAll(circle);
            }

        }

    }

    private Player getFirstPlayer() {
        List<Player> playerList = PlayerList.getInstance().getPlayerList();
        for(Player player : playerList) {
            if (player.getPlayerTurn()) {
                this.firstTurn = false;
                System.out.println(player.getName());
                return player;
            }
        }
        return null;
    }

    private Player getPlayerWhoIsInTurn() {
        List<Player> playerList = PlayerList.getInstance().getPlayerList();
        for(Player player : playerList) {
            if(player.getPlayerTurn()) {
                player.setPlayerTurn(false);

                int lastPlayerId = playerList.indexOf(player);
                lastPlayerId++;
                if(lastPlayerId == playerList.size()) {
                    Player nextPlayer = playerList.get(0);
                    nextPlayer.setPlayerTurn(true);
                    System.out.println(nextPlayer.getName());
                    return nextPlayer;
                }
                else {
                    int playerNr = player.getPlayerNumber();
                    Player nextPlayer = playerList.get(playerNr);
                    nextPlayer.setPlayerTurn(true);
                    System.out.println(nextPlayer.getName());
                    return nextPlayer;
                }

            }
        }
        return null;
    }

    private Group getFieldGroupFromPlayfield(GridPane gridPane, Integer data) {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Group) {
                for(Node group : ((Group)node).getChildren()) {
                    if (group instanceof Text) {
                        String cellValue = ((Text)group).getText();
                        int groupCellValue = Converter.convertStringToInt(cellValue);
                        if(groupCellValue == data) {
                            return ((Group)node);
                        }
                    }
                }
            }
        }
        return null;
    }

    public void toNextScene(ActionEvent event) throws IOException {
        Router.getInstance().toNextScene(event,"SceneRankingAndRestart");
    }
}
