package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SceneInitializePlayers.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Test...delete this line
        stage.setTitle("Leiterspiel - von R & M");
        stage.setScene(scene);
        stage.show();
    }
    private void closeProgramm(){

    }
    public static void main(String[] args) {
        launch(args);
    }

}