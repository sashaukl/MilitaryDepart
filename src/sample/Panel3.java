package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Lighting;
import javafx.scene.shape.Circle;

public class Panel3 extends Controller{
    private DoubleProperty fontSize = new SimpleDoubleProperty(6.1);
    private Label panel3Label1;
    private Label panel3Label2;
    private Label panel3Label3;
    private Label panel3Label4;
    private Label panel3Label5;
    private Label panel3Label6;
    private Label panel3Label7;
    private Label panel3Label8;
    private Label panel3Label9;
    private Label panel3Label10;
    private Label panel3Label11;


    Panel3(){
        init();
        setPosition();
    }
    private void init(){
        fontSize.bind(panel2.heightProperty().divide(88));
        panel3Label1 = (Label) root.lookup("#panel3Label1");
        panel3Label2 = (Label) root.lookup("#panel3Label2");
        panel3Label3 = (Label) root.lookup("#panel3Label3");
        panel3Label4 = (Label) root.lookup("#panel3Label4");
        panel3Label5 = (Label) root.lookup("#panel3Label5");
        panel3Label6 = (Label) root.lookup("#panel3Label6");
        panel3Label7 = (Label) root.lookup("#panel3Label7");
        panel3Label8 = (Label) root.lookup("#panel3Label8");
        panel3Label9 = (Label) root.lookup("#panel3Label9");
        panel3Label10 = (Label) root.lookup("#panel3Label10");
        panel3Label11 = (Label) root.lookup("#panel3Label11");


    }
    private void setPosition(){
        setLabel(panel3Label1, 0.15, 0.03, fontSize.divide(0.66));
        setLabel(panel3Label2, 0.45, 0.02, fontSize.divide(0.83));
        setLabel(panel3Label3, 0.17, 0.05, fontSize.divide(0.66));
        setLabel(panel3Label4, 0.4, 0.045);
        setLabel(panel3Label5, 0.385, 0.056);
        setLabel(panel3Label6, 0.465, 0.045);
        setLabel(panel3Label7, 0.465, 0.056);
        setLabel(panel3Label8, 0.64, 0.065);
        setLabel(panel3Label9, 0.685, 0.055);
        setLabel(panel3Label10, 0.685, 0.065);

        setLabel(panel3Label11, 0.5, 0.077, fontSize.divide(0.7));





    }

    private void setLabel(Label label, double x, double y){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(x));
        label.layoutYProperty().bind(panel3.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
    }

    private void setLabel(Label label, double x, double y, DoubleBinding fontSize){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(x));
        label.layoutYProperty().bind(panel2.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize, ";"));
    }
}
