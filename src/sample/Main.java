package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    private SplitPane splitBox;
    private Pane panel1;
    private AnchorPane panel2;
    private AnchorPane panel3;
    private MenuBar menu;


    private Circle redLight1;
    private Circle redLight2;
    private Circle redLight3;
    private Circle redLight4;
    private Circle redLight5;
    private Circle redLight6;
    private Circle redLight7;

    //yellowLight
    private Circle yellowLight1;
    //greenLights
    private Circle greenLight1;
    private Circle greenLight2;
    private Circle greenLight3;
    private Circle greenLight4;
    private Circle greenLight5;
    private Circle greenLight6;
    private Circle greenLight7;
    private Circle greenLight8;

    //blackLight
    private Circle blackLight1;
    private Circle blackLight2;
    //strings
    private Label string1Label1;
    private Label string1Label2;
    private Label string2Label1;
    private Label string2Label2;
    private Label string2Label3;
    private Label string2Label4;
    private Label string2Label5;
    private Label string3Label1;
    private Label string4Label1;
    private Label string5Label1;
    private Label string5Label2;
    private Label string5Label3;
    private Label string5Label4;
    private Label string5Label5;
    private Label string6Label1;
    private Label string6Label2;
    private Label string7Label1;
    private Label string7Label2;
    private Label string7Label3;
    private Label string7Label4;
    private Label string8Label1;
    private Label string8Label2;
    private Label string8Label3;
    private Label string9Label1;
    private Label string9Label2;
    private Label string9Label3;
    private Label string10Label1;
    private Label string10Label2;
    private Label string11Label1;
    private Label string12Label1;
    private Label string12Label2;
    private Label string12Label3;
    private Label string12Label4;
    private Label string12Label5;
    private Label string12Label6;
    private Label string13Label1;
    private Label string14Label1;
    private Label string15Label1;
    private Label string16Label1;
    private Label string17Label1;
    private Label string17Label2;
    private Label string17Label3;
    private Label string18Label1;
    private Label string18Label2;
    private Label string19Label1;
    private Label string20Label1;
    private Label string20Label2;

    //gray buttons
    private ToggleButton grayButton1;
    private ToggleButton grayButton2;
    private ToggleButton grayButton3;
    private ToggleButton grayButton4;
    private ToggleButton grayButton5;
    private ToggleButton grayButton6;
    private ToggleButton grayButton7;

    //red button
    private ToggleButton redButton1;


    //private Circle redLight4;

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
        yellowLight1 = (Circle) root.lookup("#yellowLight1");
        redLight2 = (Circle) root.lookup("#redLight2");
        redLight3 = (Circle) root.lookup("#redLight3");


        setLight(redLight1, 0.16, 0.078);
        setLight(greenLight1, 0.33, 0.078);
        setLight(yellowLight1, 0.5, 0.078);
        setLight(redLight2, 0.69, 0.078);
        setLight(redLight3, 0.835, 0.078);

        string3Label1 = (Label) root.lookup("#string3Label1");
        string4Label1 = (Label) root.lookup("#string4Label1");
        setLabel(string3Label1, 0.425, 0.108 );
        setLabel(string4Label1, 0.425, 0.19 );

        blackLight1 = (Circle) root.lookup("#blackLight1");
        blackLight2 = (Circle) root.lookup("#blackLight2");

        setLight(blackLight1, 0.5, 0.148);
        setLight(blackLight2, 0.5, 0.23);

        string5Label1 = (Label) root.lookup("#string5Label1");
        string5Label2 = (Label) root.lookup("#string5Label2");
        string5Label3 = (Label) root.lookup("#string5Label3");
        string5Label4 = (Label) root.lookup("#string5Label4");
        string5Label5 = (Label) root.lookup("#string5Label5");

        setLabel(string5Label1, 0.06, 0.2675 );
        setLabel(string5Label2, 0.2675, 0.2675 );
        setLabel(string5Label3, 0.43, 0.2675 );
        setLabel(string5Label4, 0.65, 0.2675 );
        setLabel(string5Label5, 0.76, 0.2675 );

        grayButton1 = (ToggleButton) root.lookup("#grayButton1");
        redButton1 = (ToggleButton) root.lookup("#redButton1");
        grayButton2 = (ToggleButton) root.lookup("#grayButton2");
        setButton(grayButton1, 0.282, 0.29 );
        setButton(redButton1, 0.45, 0.29 );
        setButton(grayButton2, 0.621, 0.29 );

        redLight4 = (Circle) root.lookup("#redLight4");
        redLight5 = (Circle) root.lookup("#redLight5");
        setLight(redLight4,0.16 ,0.315);
        setLight(redLight5,0.84 ,0.315);

        string6Label1 = (Label) root.lookup("#string6Label1");
        string6Label2 = (Label) root.lookup("#string6Label2");
        setLabel(string6Label1, 0.067, 0.339 );
        setLabel(string6Label2, 0.77, 0.339);

        string7Label1 = (Label) root.lookup("#string7Label1");
        string7Label2 = (Label) root.lookup("#string7Label2");
        string7Label3 = (Label) root.lookup("#string7Label3");
        string7Label4 = (Label) root.lookup("#string7Label4");
        setLabel(string7Label1, 0.095, 0.42);
        setLabel(string7Label2, 0.28, 0.42);
        setLabel(string7Label3, 0.1, 0.445);
        setLabel(string7Label4, 0.31, 0.445);

        string8Label1 = (Label) root.lookup("#string8Label1");
        string8Label2 = (Label) root.lookup("#string8Label2");
        string8Label3 = (Label) root.lookup("#string8Label3");
        setLabel(string8Label1, 0.69, 0.425, panel1.heightProperty().divide(95));
        setLabel(string8Label2, 0.76, 0.412, panel1.heightProperty().divide(95));
        setLabel(string8Label3, 0.82, 0.425, panel1.heightProperty().divide(95));

        string9Label1 = (Label) root.lookup("#string9Label1");
        string9Label2 = (Label) root.lookup("#string9Label2");
        string9Label3 = (Label) root.lookup("#string9Label3");
        setLabel(string9Label1, 0.1, 0.48);
        setLabel(string9Label2, 0.35, 0.459, panel1.heightProperty().divide(70) );
        setLabel(string9Label3, 0.68, 0.47);

        string10Label1 = (Label) root.lookup("#string10Label1");
        string10Label2 = (Label) root.lookup("#string10Label2");
        setLabel(string10Label1, 0.4, 0.471, panel1.heightProperty().divide(65));
        setLabel(string10Label2, 0.55, 0.471, panel1.heightProperty().divide(65));

        string11Label1 = (Label) root.lookup("#string11Label1");
        setLabel(string11Label1, 0.36, 0.519, panel1.heightProperty().divide(75));

        string12Label1 = (Label) root.lookup("#string12Label1");
        string12Label2 = (Label) root.lookup("#string12Label2");
        string12Label3 = (Label) root.lookup("#string12Label3");
        string12Label4 = (Label) root.lookup("#string12Label4");
        string12Label5 = (Label) root.lookup("#string12Label5");
        string12Label6 = (Label) root.lookup("#string12Label6");
        setLabel(string12Label1, 0.2, 0.568, panel1.heightProperty().divide(67));
        setLabel(string12Label2, 0.35, 0.568, panel1.heightProperty().divide(67));
        setLabel(string12Label3, 0.47, 0.568, panel1.heightProperty().divide(67));
        setLabel(string12Label4, 0.59, 0.568, panel1.heightProperty().divide(67));
        setLabel(string12Label5, 0.67, 0.568, panel1.heightProperty().divide(67));
        setLabel(string12Label6, 0.7, 0.58, panel1.heightProperty().divide(67));

        string13Label1 = (Label) root.lookup("#string13Label1");
        string14Label1 = (Label) root.lookup("#string14Label1");
        setLabel(string13Label1, 0.23, 0.59, panel1.heightProperty().divide(70));
        setLabel(string14Label1, 0.23, 0.645 , panel1.heightProperty().divide(70));

        string15Label1 = (Label) root.lookup("#string15Label1");
        string16Label1 = (Label) root.lookup("#string16Label1");
        setLabel(string15Label1, 0.23, 0.655);
        setLabel(string16Label1, 0.26, 0.668 );

        string17Label1 = (Label) root.lookup("#string17Label1");
        string17Label2 = (Label) root.lookup("#string17Label2");
        string17Label3 = (Label) root.lookup("#string17Label3");
        setLabel(string17Label1, 0.379, 0.677, panel1.heightProperty().divide(90) );
        setLabel(string17Label2, 0.5, 0.667, panel1.heightProperty().divide(90) );
        setLabel(string17Label3, 0.5, 0.677, panel1.heightProperty().divide(90) );

        string18Label1 = (Label) root.lookup("#string18Label1");
        string18Label2 = (Label) root.lookup("#string18Label2");
        setLabel(string18Label1, 0.182 ,0.705 , panel1.heightProperty().divide(75));
        setLabel(string18Label2, 0.188 ,0.728, panel1.heightProperty().divide(90));

        string19Label1 = (Label) root.lookup("#string19Label1");
        setLabel(string19Label1, 0.4311, 0.729,  panel1.heightProperty().divide(70));

        string20Label1 = (Label) root.lookup("#string20Label1");
        string20Label2 = (Label) root.lookup("#string20Label2");
        setLabel(string20Label1, 0.283, 0.79);
        setLabel(string20Label2, 0.66, 0.79);


        grayButton3 = (ToggleButton) root.lookup("#grayButton3");
        grayButton4 = (ToggleButton) root.lookup("#grayButton4");
        grayButton5 = (ToggleButton) root.lookup("#grayButton5");
        grayButton6 = (ToggleButton) root.lookup("#grayButton6");
        grayButton7 = (ToggleButton) root.lookup("#grayButton7");
        setButton(grayButton3, 0.107, 0.361);
        setButton(grayButton4, 0.79, 0.361);
        setButton(grayButton5, 0.325, 0.597);
        setButton(grayButton6, 0.445, 0.597);
        setButton(grayButton7, 0.57, 0.597);


        greenLight2 = (Circle) root.lookup("#greenLight2");
        greenLight3 = (Circle) root.lookup("#greenLight3");
        greenLight4 = (Circle) root.lookup("#greenLight4");
        greenLight5 = (Circle) root.lookup("#greenLight5");
        greenLight6 = (Circle) root.lookup("#greenLight6");
        greenLight7 = (Circle) root.lookup("#greenLight7");
        greenLight8 = (Circle) root.lookup("#greenLight8");
        setLight(greenLight2, 0.325, 0.4);
        setLight(greenLight3, 0.67, 0.4);

        setLight(greenLight4, 0.255, 0.552);
        setLight(greenLight5, 0.378, 0.552);
        setLight(greenLight6, 0.5, 0.552);
        setLight(greenLight7, 0.62, 0.552);
        setLight(greenLight8, 0.745, 0.552);

        redLight6 = (Circle) root.lookup("#redLight6");
        redLight7 = (Circle) root.lookup("#redLight7");
        setLight(redLight6, 0.425, 0.71);
        setLight(redLight7, 0.57, 0.71);


        System.out.println(  );
    }

    private void setButton(ToggleButton tb, double x, double y){
        Circle cir = new Circle(20);
        tb.setShape(cir);
        cir.radiusProperty().bind(splitBox.heightProperty().divide(39));
        tb.minHeightProperty().bind(cir.radiusProperty().multiply(2));
        tb.minWidthProperty().bind(cir.radiusProperty().multiply(2));
        tb.maxHeightProperty().bind(cir.radiusProperty().multiply(2));
        tb.maxHeightProperty().bind(cir.radiusProperty().multiply(2));
        tb.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        tb.layoutYProperty().bind(splitBox.heightProperty().multiply(y));
    }

    private void setLabel(Label label, double x, double y){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        label.layoutYProperty().bind(panel1.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
    }

    private void setLabel(Label label, double x, double y, DoubleBinding fontSize){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        label.layoutYProperty().bind(panel1.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize, ";"));
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
