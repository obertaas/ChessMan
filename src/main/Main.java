package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
    Pane pane;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //new ShowWindow(primaryStage, "ChessMan", "main.fxml");
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/mainWindow.fxml"));
        window.setTitle("ChessMan");
        Scene scene = new Scene(root);
        window.setScene(scene);
        //scene.getStylesheets().add("main/style.css");
        window.show();

        //Pane pane = root.

    }



    public static void main(String[] args) {
        launch(args);
    }
}
