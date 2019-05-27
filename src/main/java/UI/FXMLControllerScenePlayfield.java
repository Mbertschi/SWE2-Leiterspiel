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

public class FXMLControllerScenePlayfield {

    @FXML
    GridPane playfield;

    public void setPlayersOnFirstCell() {
        Router router = Router.getInstance();
        this.playfield = router.getPlayField();
        Group fieldGroup = getFirstField(this.playfield, 1);
        MainController mainController = new MainController();
        List<Player> fieldPlayers = new LinkedList<>();
        fieldPlayers = mainController.getPlayerList();

        //for(Player player : fieldPlayers){
        for(var i = 0; i < fieldPlayers.size(); i++) {
            Circle playerCircle = fieldPlayers.get(i).getCircle();
            fieldGroup.getChildren().addAll(playerCircle);
        }
    }

    private Group getFirstField(GridPane gridPane, Integer data) {
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
