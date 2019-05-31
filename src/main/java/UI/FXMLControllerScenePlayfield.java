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
import java.util.List;

public class FXMLControllerScenePlayfield {

    @FXML
    private GridPane playfield;

    public FXMLControllerScenePlayfield() {
    }

    public void initializeFirstPlayfieldCell(List<Player> fieldPlayers) {

        this.playfield = Router.getInstance().getPlayField();
        Group fieldGroup = getFieldNumberFromPlayfield(playfield, 1);

        int i = 1;
        for(Player player : fieldPlayers){

            Circle playerCircle = new ColorCircle().createCircle(player.getPlayerColor());
            playerCircle.setRadius(6);
            playerCircle.setLayoutY(30);
            playerCircle.setLayoutX(i * 6);

            fieldGroup.getChildren().addAll(playerCircle);
            i++;
        }

    }

    public void addValueOfDiceToPlayer(int diceNumber) {
        Player player = this.getPlayerWhoIsInTurn();
        Integer newPlayerFieldNumber = player.getPlayerPlayFieldCellNumber() + diceNumber;
        Group fieldGroup = getFieldNumberFromPlayfield(this.playfield, newPlayerFieldNumber);
        Circle playerCircle = new ColorCircle().createCircle(player.getPlayerColor());
        fieldGroup.getChildren().addAll(playerCircle);
        // ToDo : handle with specialfield
        player.setPlayerPlayFieldCellNumber(newPlayerFieldNumber);
    }

    private Player getPlayerWhoIsInTurn() {
        List<Player> playerList = PlayerList.getInstance().getPlayerList();
        for(Player player : playerList) {
            if(player.getPlayerTurn()) {
                return player;
            }
        }
        return null;
    }

    private Group getFieldNumberFromPlayfield(GridPane gridPane, Integer data) {
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

    public void toSceneSix(ActionEvent event) throws IOException {
        Router.getInstance().toNextScene(event,"SceneRankingAndRestart");
    }

    public void closeApplication(){
        System.exit(0);
    }

}
