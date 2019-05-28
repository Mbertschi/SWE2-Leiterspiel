package UI;

import business.Converter;
import business.Dice;
import business.MainController;
import business.Player;
import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.UserDataHandler;
import persistence.PlayerList;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

class CircleCopy {
    private Circle circle;

    public CircleCopy(Circle playerCircle) {
        this.circle = playerCircle; // you can access
    }

    public Circle getCircleCopy() {
        return this.circle;
    }
}

public class FXMLControllerScenePlayfield {

    @FXML
    private GridPane playfield;

    public FXMLControllerScenePlayfield() {
    }

    public void initializeFirstPlayfieldCell(List<Player> fieldPlayers) {

        this.playfield = Router.getInstance().getPlayField();
        Group fieldGroup = getFieldNumberFromPlayfield(playfield, 1);

        //CircleCopy circleCopy = new CircleCopy(fieldPlayers.get(1).getCircle());
        //fieldGroup.getChildren().add(circleCopy.getCircleCopy());

        int i = 1;
        for(Player player : fieldPlayers){
            Circle playerCircle = player.getCircle();
            playerCircle.setRadius(6);
            playerCircle.setLayoutY(30);
            playerCircle.setLayoutX(i * 6);
            CircleCopy circleCopy = new CircleCopy(playerCircle);
            fieldGroup.getChildren().addAll(circleCopy.getCircleCopy());
            i++;
        }

    }

    public void addValueOfDiceToPlayer(int diceNumber) {
        Player player = this.getPlayerWhoIsInTurn();
        Integer newPlayerFieldNumber = player.getPlayerPlayFieldCellNumber() + diceNumber;
        Group fieldGroup = getFieldNumberFromPlayfield(this.playfield, newPlayerFieldNumber);
        fieldGroup.getChildren().addAll(player.getCircle());
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

}
