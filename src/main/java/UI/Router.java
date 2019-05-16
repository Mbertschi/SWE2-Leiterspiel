package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Router {

    public void toNextScene(ActionEvent event, String fxmlScene)throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        Scene windowScene = new Scene(scene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowScene);
        window.show();
    }

    public void toNextScene(ActionEvent event, String fxmlScene, Boolean createPlayerInputs)throws IOException {

        if(createPlayerInputs) {
            Parent scene = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
            // new add textfield to pane
            TextField tf = new TextField();
            GridPane pane = new GridPane();

            pane.getChildren().add(scene);
            pane.getChildren().add(tf);

            Scene windowScene = new Scene(pane);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(windowScene);
            window.show();
        }
    }



}
