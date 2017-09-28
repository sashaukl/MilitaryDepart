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

        //SplitPane mainBox = SplitPane.getPrefWidth();
        StackPane commonbox = ( StackPane) root.lookup("#commonBox");
        commonbox.setAlignment(Pos.TOP_LEFT);


        //SplitPane splitBox = (SplitPane) root.lookup("#splitBox");
        Pane panel1 = (Pane) root.lookup("#gap");

        panel1.setMinWidth(100);
        //AnchorPane panel2 = (AnchorPane) root.lookup("#py");
       // AnchorPane panel3 = (AnchorPane) root.lookup("#planeThird");
        MenuBar menu = (MenuBar) root.lookup("#Menu");

        //panel1.setMinHeight(commonbox.getHeight()- menu.getHeight());

        // SplitPane.setResizableWithParent(panel1,false);

        //splitBox.
        //primaryStage.getHeight();



        //panel3.setLayoutY();
        //panel1
        //panel2.setPrefHeight(primaryStage.getHeight());
        //panel3.setPrefHeight(primaryStage.getHeight());
        // HBox Box = HBox root.lookup("#");

        //Button btn = new Button("df");
        //100/100
        //btn.setLayoutX(panel1.getWidth() - panel1.getWidth();



       // System.out.println(panel1.getPrefWidth());


        //ta.setPrefSize(ta.getPrefWidth() + 600, ta.getPrefHeight() + 500);
        //ta.setPrefWidth(ta.getPrefWidth() + 100);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
