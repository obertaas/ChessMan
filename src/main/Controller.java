package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
    private ImageView e2_imageview;

    @FXML
    private Pane a7_pane;

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private Pane a6_pane;




    @FXML
    void newGameButtonClicked(ActionEvent event) {
        Stage mainWindow = (Stage) newGameButton.getScene().getWindow();
        String title = newGameButton.getText();
        mainWindow.setTitle(title+" yeahyeah");
    }

    @FXML
    void newSceneButtonClicked(ActionEvent event) throws IOException {
        ShowWindow window = new ShowWindow((new Stage()), "Chessboard", "../fxml/mainWindow.fxml");
    }

    @FXML
    void settingsButtonClicked(ActionEvent event) throws IOException {
        Stage window = (Stage) settingsButton.getScene().getWindow();
        window.setTitle("style things");
        window.getScene().getStylesheets().add("css/style.css");

    }

    @FXML
    void pawnSelected(MouseEvent event) throws IOException {
        System.out.println("pawn selected");
        Stage window = (Stage) mainWindow.getScene().getWindow();
        window.setTitle("pawn selected");
    }

    @FXML
    void mouseClicked(MouseEvent event) {

        ImageView image = (ImageView) event.getSource();
        Pane pane = (Pane) image.getParent();

        System.out.println("Image clicked " + image);
        //System.out.println("Image clicked " + e2_imageview);
        System.out.println("---------------");
        System.out.println("Pane clicked " + pane.toString());
        
    }




    @FXML
    void mousePressed(MouseEvent event) {
        Pane image = (Pane) event.getSource();
        image.setStyle(" -fx-background-color: green ; ");

    }

    @FXML
    void mouseDragged(MouseEvent event) {
        event.getSource();
    }

    @FXML
    void mouseReleased(MouseEvent event) {
        Pane pane = (Pane) event.getSource();
        pane.setStyle(" -fx-background-color: green ; ");
    }

    @FXML
    public void onDragDetected(MouseEvent mouseEvent) {
        System.out.println("mouse dragged");

        Pane pane = (Pane) mouseEvent.getSource();
        pane.setStyle(" -fx-background-color: green ; ");

    }

    @FXML
    void onDragDone(DragEvent event) {
        Pane pane = (Pane) event.getSource();
        pane.setStyle(" -fx-background-color: green ; ");
    }

    @FXML
    void onDragOver(DragEvent event) {
        Pane pane = (Pane) event.getSource();
        pane.setStyle(" -fx-background-color: green ; ");

    }


}

