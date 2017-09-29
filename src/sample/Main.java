package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //FXMLLoader loader =  new FXMLLoader(getClass().getResource("PracticeScreen.fxml"));
        //Parent root = loader.load();





        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("САЭС");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);



        primaryStage.show();
        //example



         AnchorPane commonbox = (AnchorPane) root.lookup("#commonBox");


        //init workspace containers
        SplitPane splitBox = (SplitPane) root.lookup("#splitBox");
        AnchorPane panel1 = (AnchorPane) root.lookup("#gap");
        AnchorPane panel2 = (AnchorPane) root.lookup("#py");
        AnchorPane panel3 = (AnchorPane) root.lookup("#planeThird");
        MenuBar menu = (MenuBar) root.lookup("#Menu");

        //Get Max Values of containers
        panel1.maxWidthProperty().bind(splitBox.heightProperty().divide(2) );
        panel2.maxWidthProperty().bind(splitBox.heightProperty().divide(2.5) );
        panel3.maxWidthProperty().bind(splitBox.heightProperty().divide(0.75) );

        //test field



    }



    public static void main(String[] args) {
        launch(args);
    }
}
