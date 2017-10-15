package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller{
    protected static Stage primaryStage = null;
    protected Parent root = null;
    protected SplitPane splitBox;
    protected Pane panel1;
    protected Pane panel2;
    protected AnchorPane panel3;
    protected MenuBar menu;

    //Controller() {}

    Controller (){
        this.primaryStage = Main.primaryStage;
        this.root = Main.root;

        //example
        AnchorPane commonbox = (AnchorPane) root.lookup("#commonBox");

        //init workspace containers
        splitBox = (SplitPane) root.lookup("#splitBox");
        panel1 = (Pane) root.lookup("#gap");
        panel2 = (Pane) root.lookup("#py");
        panel3 = (AnchorPane) root.lookup("#planeThird");
        menu = (MenuBar) root.lookup("#Menu");

        //Get Max Values of containers
        panel1.prefWidthProperty().bind(splitBox.heightProperty().divide(2));
        panel2.prefWidthProperty().bind(splitBox.heightProperty().divide(2.5));
        panel1.maxWidthProperty().bind(splitBox.heightProperty().divide(2));
        panel2.maxWidthProperty().bind(splitBox.heightProperty().divide(2.5));
        panel3.maxWidthProperty().bind(splitBox.heightProperty().divide(0.75));


    }
}