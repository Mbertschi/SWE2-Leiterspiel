package UI;

import business.Converter;
import business.Player;
import business.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
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
        newPlayerFieldNumber = this.checkNewPlayerFieldNumberForSpecialField(newPlayerFieldNumber);
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
                System.out.println(player.getName() + " hat " + diceNumber + " gewürfelt!");
                System.out.println("Neue Feldnummer: " + newPlayerFieldNumber);

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

    private Integer checkNewPlayerFieldNumberForSpecialField(Integer newPlayerFieldNumber) {
        switch(newPlayerFieldNumber) {
            // Latter 1
            case 4: return 25;
            // Latter 2
            case 12: return 33;
            // Snake 1
            case 38: return 20;
            // Snake 2
            case 45: return 27;
            // Snake 3
            case 55: return 37;
            default: return newPlayerFieldNumber;
        }
    }

    private Player getFirstPlayer() {
        List<Player> playerList = PlayerList.getInstance().getPlayerList();
        for(Player player : playerList) {
            if (player.getPlayerTurn()) {
                this.firstTurn = false;
                return player;
            }
        }
        return null;
    }

    private Player getPlayerWhoIsInTurn() {
        List<Player> playerList = PlayerList.getInstance().getPlayerList();
        for(Player player : playerList) {
            if(player.getPlayerTurn()) {

                boolean playerFound = false;
                boolean nextPlayerFound = false;
                // get next player after this one
                for(Player nextPlayer : playerList) {
                    if(nextPlayer.getPlayerTurn()) {
                        player.setPlayerTurn(false);
                        playerFound = true;
                    }

                    if(playerFound) {
                        int lastPlayerId = playerList.indexOf(nextPlayer);
                        lastPlayerId++;
                        if(!nextPlayerFound && lastPlayerId == playerList.size()) {
                            nextPlayer = playerList.get(0);
                            nextPlayer.setPlayerTurn(true);

                            GridPane playerPane = Router.getInstance().getPlayerPane();
                            Circle circle = new Circle();
                            circle.setFill(Color.BLACK);
                            playerPane.getChildren().add(nextPlayer.getPlayerNumber(), circle);

                            System.out.println("----------------------------");
                            System.out.println("Als nächstes kommt dran: " + nextPlayer.getName());
                            System.out.println("Aktuelle Feldnummer: " + nextPlayer.getPlayerPlayFieldCellNumber());
                            return nextPlayer;
                        }

                        else if(nextPlayerFound) {
                            nextPlayer.setPlayerTurn(true);
                            GridPane playerPane = Router.getInstance().getPlayerPane();
                            Circle circle = new Circle();
                            circle.setFill(Color.BLACK);
                            playerPane.getChildren().add(nextPlayer.getPlayerNumber(), circle);

                            System.out.println("----------------------------");
                            System.out.println("Als nächstes kommt dran: " + nextPlayer.getName());
                            System.out.println("Aktuelle Feldnummer: " + nextPlayer.getPlayerPlayFieldCellNumber());
                            return nextPlayer;
                        }

                        else {
                            nextPlayerFound = true;
                            continue;
                        }

                    }
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
