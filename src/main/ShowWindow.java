package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowWindow {

    Stage window;

    public ShowWindow(Stage stage, String title, String fxmlFileName) throws IOException {
        //Stage popUpWindow = new Stage();
        window = stage;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        window.setScene(new Scene(root));
        window.show();
    }

    public Scene getScene() {
        return window.getScene();
    }
}
