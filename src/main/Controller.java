package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button newGameButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button newSceneButton;
    @FXML
    private ImageView a7_pawn;

    @FXML
    private Pane a7_pane;


    @FXML
    void newGameButtonClicked(ActionEvent event) {
        Stage mainWindow = (Stage) newGameButton.getScene().getWindow();
        String title = newGameButton.getText();
        mainWindow.setTitle(title+" yeahyeah");
        //mainWindow.getScene().getStylesheets().add("style.css");
    }

    @FXML
    void newSceneButtonClicked(ActionEvent event) throws IOException {
        //new ShowWindow((new Stage()), "Popup", "popUpWindow.fxml");
        ShowWindow window = new ShowWindow((new Stage()), "Chessboard", "../fxml/windowWithPieces.fxml");
        //window.getScene().getStylesheets().add("style.css");
    }

    @FXML
    void settingsButtonClicked(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("windowWithPieces.fxml"));
        Stage window = (Stage) a7_pane.getScene().getWindow();
        window.setTitle("style things");
        //window.getScene().getStylesheets().add(getClass().getResource( "style.css" ).toExternalForm() );
        window.getScene().getStylesheets().add("css/style.css");
        //a7_pane_code.getStylesheets().add(("style.css"));

    }

    @FXML
    void pawnSelected(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/windowWithPieces.fxml"));

        //ImageView a7_pawn_ = a7_pawn.getImage();


        // System.out.println("Pawn move");

    }
    @FXML
    void pawnDropped(DragEvent event) {

    }
}

