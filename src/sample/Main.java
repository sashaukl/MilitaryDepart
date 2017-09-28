package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
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
        AnchorPane commonbox = (AnchorPane) root.lookup("#commonBox");
        SplitPane splitBox = (SplitPane) root.lookup("#splitBox");
        FlowPane panel1 = (FlowPane) root.lookup("#gap");
        FlowPane panel2 = (FlowPane) root.lookup("#py");
        FlowPane panel3 = (FlowPane) root.lookup("#planeThird");
        MenuBar menu = (MenuBar) root.lookup("#Menu");

        //panel1.setMinHeight(commonbox.getHeight()- menu.getHeight());
        panel1.setPrefHeight(commonbox.getHeight()- menu.getHeight());
        panel2.setPrefHeight(commonbox.getHeight()- menu.getHeight());
        panel3.setPrefHeight(commonbox.getHeight()- menu.getHeight());

        // SplitPane.setResizableWithParent(panel1,false);

        //splitBox.
        //primaryStage.getHeight();



        //panel3.setLayoutY();
        //panel1
        //panel2.setPrefHeight(primaryStage.getHeight());
        //panel3.setPrefHeight(primaryStage.getHeight());
        // HBox Box = HBox root.lookup("#");











        Button btn = new Button("df");
        //100/100
        btn.setLayoutX(panel1.getWidth() - 100);



        System.out.println(panel1.getPrefWidth());


        //ta.setPrefSize(ta.getPrefWidth() + 600, ta.getPrefHeight() + 500);
        //ta.setPrefWidth(ta.getPrefWidth() + 100);
        panel1.getChildren().add(btn);



    }



    public static void main(String[] args) {
        launch(args);
    }
}
