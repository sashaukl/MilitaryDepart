package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    private SplitPane splitBox;
    private Pane panel1;
    private AnchorPane panel2;
    private AnchorPane panel3;
    private MenuBar menu;

    private Label string1Label1;
    private Label string1Label2;

    private Label string2Label1;
    private Label string2Label2;
    private Label string2Label3;
    private Label string2Label4;
    private Label string2Label5;

    private Circle redLight1;
    private Circle greenLight1;
    private Circle yellowLight;
    private Circle redLight2;
    private Circle redLight3;

    private Label string3Label1;

    private Circle redLight4;
    private Circle redLight5;
    private Circle redLight6;
    private Circle redLight7;

    private DoubleProperty fontSize = new SimpleDoubleProperty(11);
    private DoubleProperty fontSizeLow = new SimpleDoubleProperty(11);


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
        splitBox = (SplitPane) root.lookup("#splitBox");
        panel1 = (Pane) root.lookup("#gap");
        panel2 = (AnchorPane) root.lookup("#py");
        panel3 = (AnchorPane) root.lookup("#planeThird");
        menu = (MenuBar) root.lookup("#Menu");


        //Get Max Values of containers
        panel1.prefWidthProperty().bind(splitBox.heightProperty().divide(2) );
        panel2.prefWidthProperty().bind(splitBox.heightProperty().divide(2.5) );

        panel1.maxWidthProperty().bind(splitBox.heightProperty().divide(2) );
        panel2.maxWidthProperty().bind(splitBox.heightProperty().divide(2.5) );
        panel3.maxWidthProperty().bind(splitBox.heightProperty().divide(0.75) );

        //fill first container
        string1Label1 = (Label) root.lookup("#string1Label1");
        string1Label2 = (Label) root.lookup("#string1Label2");
        string2Label1 = (Label) root.lookup("#string2Label1");
        string2Label2 = (Label) root.lookup("#string2Label2");
        string2Label3 = (Label) root.lookup("#string2Label3");
        string2Label4 = (Label) root.lookup("#string2Label4");
        string2Label5 = (Label) root.lookup("#string2Label5");


        fontSize.bind(panel1.heightProperty().divide(57.363636));

        setLabel(string1Label1, 0.15, 0.017 );
        setLabel(string1Label2, 0.65, 0.017);

        setLabel(string2Label1, 0.1, 0.035);
        setLabel(string2Label2, 0.3, 0.035 );
        setLabel(string2Label3, 0.48, 0.035 );
        setLabel(string2Label4, 0.64, 0.035 );
        setLabel(string2Label5, 0.8, 0.035 );

        redLight1 = (Circle) root.lookup("#redLight1");
        greenLight1 = (Circle) root.lookup("#greenLight1");
        yellowLight = (Circle) root.lookup("#yellowLight");
        redLight2 = (Circle) root.lookup("#redLight2");
        redLight3 = (Circle) root.lookup("#redLight3");


        setLight(redLight1, 0.16, 0.078);
        setLight(greenLight1, 0.33, 0.078);
        setLight(yellowLight, 0.5, 0.078);
        setLight(redLight2, 0.69, 0.078);
        setLight(redLight3, 0.835, 0.078);

        string3Label1 = (Label) root.lookup("#string3Label1");
        setLabel(string3Label1, 0.425, 0.108 );
        





        System.out.println(panel1.heightProperty());
    }

    private void setLabel(Label label, double x, double y){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        label.layoutYProperty().bind(panel1.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
    }

    private void setLight(Circle circle, double x, double y){
        circle.layoutYProperty().bind(panel1.heightProperty().multiply(y));
        circle.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        circle.radiusProperty().bind(panel1.heightProperty().divide(52.58));
        circle.styleProperty().bind(Bindings.concat("-fx-stroke-width: ", circle.getRadius()/4 , ";"));
        circle.setEffect(new Lighting());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
