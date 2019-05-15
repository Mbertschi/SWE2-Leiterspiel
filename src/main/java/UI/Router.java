package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Router {

    public void toNextScene(ActionEvent event, String fxmlScene )throws IOException {


        Parent sceneTwo = FXMLLoader.load(getClass().getResource(fxmlScene+".fxml"));
        Scene windowSceneTwo = new Scene(sceneTwo);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(windowSceneTwo);
        window.show();
    }





}
