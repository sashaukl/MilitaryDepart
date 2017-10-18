package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller{
    protected static Stage primaryStage = null;
    protected Parent root = null;
    protected SplitPane splitBox;
    protected Pane panel1;
    protected Pane panel2;
    protected Pane panel3;
    protected MenuBar menu;

    Lighting lighting = new Lighting();


    //Controller() {}

    Controller (){

        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        // Create lighting effect
        lighting.setLight(light);
        lighting.setSurfaceScale(4.0);


        this.primaryStage = Main.primaryStage;
        this.root = Main.root;

        //example
        AnchorPane commonbox = (AnchorPane) root.lookup("#commonBox");

        //init workspace containers
        splitBox = (SplitPane) root.lookup("#splitBox");
        panel1 = (Pane) root.lookup("#gap");
        panel2 = (Pane) root.lookup("#py");
        panel3 = (Pane) root.lookup("#planeThird");
        menu = (MenuBar) root.lookup("#Menu");

        //Get Max Values of containers
        panel1.prefWidthProperty().bind(splitBox.heightProperty().divide(2));
        panel2.prefWidthProperty().bind(splitBox.heightProperty().divide(2.5));
        panel1.maxWidthProperty().bind(splitBox.heightProperty().divide(2));
        panel2.maxWidthProperty().bind(splitBox.heightProperty().divide(2.5));
        panel3.maxWidthProperty().bind(splitBox.heightProperty().divide(0.75));


    }
}