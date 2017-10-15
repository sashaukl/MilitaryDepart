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
import javafx.scene.shape.SVGPath;

public class Panel2 extends Controller{
    //labels
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private Label label19;
    private Label label20;
    private Label label21;
    private Label label22;
    private Label label23;
    private Label label24;
    private Label label25;


    private Circle greenLight1;
    private Circle greenLight2;
    private Circle greenLight3;

    private  Circle redLight1;

    private ToggleButton tumbler1;
    private ToggleButton tumbler2;
    private ToggleButton tumbler3;
    private ToggleButton tumbler4;
    private ToggleButton tumbler5;
    private ToggleButton tumbler6;
    private ToggleButton tumbler7;
    private ToggleButton tumbler8;

    private Button tumblerButton1;
    private Button tumblerButton2;


    private DoubleProperty fontSize = new SimpleDoubleProperty(11);

    Panel2(){
        init();
        setPosition();
    }

    private void init(){
        fontSize.bind(panel2.heightProperty().divide(88));
        label1 = (Label) root.lookup("#panel2Label1");
        label2 = (Label) root.lookup("#panel2Label2");
        label3 = (Label) root.lookup("#panel2Label3");
        label4 = (Label) root.lookup("#panel2Label4");
        label5 = (Label) root.lookup("#panel2Label5");
        label6 = (Label) root.lookup("#panel2Label6");
        label7 = (Label) root.lookup("#panel2Label7");
        label8 = (Label) root.lookup("#panel2Label8");
        label9 = (Label) root.lookup("#panel2Label9");
        label10 = (Label) root.lookup("#panel2Label10");
        label11 = (Label) root.lookup("#panel2Label11");
        label12 = (Label) root.lookup("#panel2Label12");
        label13 = (Label) root.lookup("#panel2Label13");
        label14 = (Label) root.lookup("#panel2Label14");
        label15 = (Label) root.lookup("#panel2Label15");
        label16 = (Label) root.lookup("#panel2Label16");
        label17 = (Label) root.lookup("#panel2Label17");
        label18 = (Label) root.lookup("#panel2Label18");
        label19 = (Label) root.lookup("#panel2Label19");
        label20 = (Label) root.lookup("#panel2Label20");
        label21 = (Label) root.lookup("#panel2Label21");
        label22 = (Label) root.lookup("#panel2Label22");
        label23 = (Label) root.lookup("#panel2Label23");
        label24 = (Label) root.lookup("#panel2Label24");
        label25 = (Label) root.lookup("#panel2Label25");
        greenLight1 = (Circle) root.lookup("#panel2greenLight1");
        greenLight2 = (Circle) root.lookup("#panel2greenLight2");
        greenLight3 = (Circle) root.lookup("#panel2greenLight3");
        redLight1 = (Circle) root.lookup ("#panel2redLight1");
        tumbler1 = (ToggleButton) root.lookup("#panel2tumbler1");
        tumbler2 = (ToggleButton) root.lookup("#panel2tumbler2");
        tumbler3 = (ToggleButton) root.lookup("#panel2tumbler3");
        tumbler4 = (ToggleButton) root.lookup("#panel2tumbler4");
        tumbler5 = (ToggleButton) root.lookup("#panel2tumbler5");
        tumbler6 = (ToggleButton) root.lookup("#panel2tumbler6");
        tumbler7 = (ToggleButton) root.lookup("#panel2tumbler7");
        tumbler8 = (ToggleButton) root.lookup("#panel2tumbler8");

        tumblerButton1 = (Button) root.lookup("#panel2tumblerButton1");
        tumblerButton2 = (Button) root.lookup("#panel2tumblerButton2");



    }
    private void setPosition(){
        setLabel(label1, 0.32, 0.012, panel2.heightProperty().divide(50));
        setLabel(label2, 0.68, 0.055, panel2.heightProperty().divide(88));
        setLabel(label3, 0.65, 0.066, panel2.heightProperty().divide(92));
        setLabel(label4, 0.83, 0.066, panel2.heightProperty().divide(92));
        setLabel(label5, 0.608, 0.093, panel2.heightProperty().divide(92));
        setLabel(label6, 0.9, 0.097, panel2.heightProperty().divide(92));
        setLabel(label7, 0.5, 0.18, panel2.heightProperty().divide(90));
        setLabel(label8, 0.09, 0.288, panel2.heightProperty().divide(110));
        setLabel(label9, 0.38, 0.283, panel2.heightProperty().divide(100));
        setLabel(label10, 0.56, 0.283, panel2.heightProperty().divide(100));
        setLabel(label11, 0.745, 0.283, panel2.heightProperty().divide(100));
        setLabel(label12,0.19, 0.362,  panel2.heightProperty().divide(88));
        setLabel(label13,0.365, 0.362,  panel2.heightProperty().divide(88));
        setLabel(label14,0.55, 0.362,  panel2.heightProperty().divide(88));
        setLabel(label15,0.735, 0.362,  panel2.heightProperty().divide(88));
        setLabel(label16,0.15, 0.38,  panel2.heightProperty().divide(88));
        setLabel(label17,0.17, 0.39,  panel2.heightProperty().divide(88));
        setLabel(label18,0.36, 0.38,  panel2.heightProperty().divide(88));
        setLabel(label19,0.65, 0.38,  panel2.heightProperty().divide(88));
        setLabel(label20,0.19, 0.47,  panel2.heightProperty().divide(88));
        setLabel(label21,0.37, 0.47,  panel2.heightProperty().divide(88));
        setLabel(label22,0.55, 0.47,  panel2.heightProperty().divide(88));
        setLabel(label23,0.77, 0.486,  panel2.heightProperty().divide(88));
        setLabel(label24,0.86, 0.495,  panel2.heightProperty().divide(88));
        setLabel(label25,0.68, 0.555,  panel2.heightProperty().divide(88));
        setLight(greenLight1, 0.41, 0.26);
        setLight(greenLight2, 0.72, 0.26);
        setLight(greenLight3, 0.84, 0.26);
        setLight(redLight1, 0.59, 0.26);


        setTumbler(tumbler1, 0.17, 0.3);
        setTumbler(tumbler2, 0.35, 0.3);
        setTumbler(tumbler3, 0.535, 0.3);
        setTumbler(tumbler4, 0.717, 0.3);
        setTumbler(tumbler5, 0.17, 0.405);
        setTumbler(tumbler6, 0.35, 0.405);
        setTumbler(tumbler7, 0.535, 0.405);
        setTumbler(tumbler8, 0.717, 0.405);

        setTumbler1(tumblerButton1, 0.745,0.085);
        setTumbler1(tumblerButton2, 0.745,0.5);
        //tumblerButton1.setRotate(325);
        tumblerButton1.setOnMouseClicked(ev ->{
            switch ((int) tumblerButton1.getRotate()){
                case 325:
                    tumblerButton1.setRotate(0);
                    break;
                case 0:
                    tumblerButton1.setRotate(90);
                    break;
                case 90:
                    tumblerButton1.setRotate(130);
                    break;
                case 130:
                    tumblerButton1.setRotate(325);
                    break;
            }
        });

        tumblerButton2.setOnMouseClicked(ev ->{
            switch ((int) tumblerButton2.getRotate()){
                case 52:
                    tumblerButton2.setRotate(100);
                    break;
                case 100:
                    tumblerButton2.setRotate(232);
                    break;
                case 232:
                    tumblerButton2.setRotate(52);
                    break;
            }
        });
    }

    private void setLight(Circle circle, double x, double y){
        circle.layoutYProperty().bind(panel2.heightProperty().multiply(y));
        circle.layoutXProperty().bind(splitBox.heightProperty().divide(2.5).multiply(x));
        circle.radiusProperty().bind(panel2.heightProperty().divide(55));
        circle.styleProperty().bind(Bindings.concat("-fx-stroke-width: ", circle.getRadius()/4 , ";"));
        circle.setEffect(new Lighting());
    }

    private void setLabel(Label label, double x, double y){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(2.5).multiply(x));
        label.layoutYProperty().bind(panel2.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
    }

    private void setLabel(Label label, double x, double y, DoubleBinding fontSize){
        label.layoutXProperty().bind(splitBox.heightProperty().divide(2.5).multiply(x));
        label.layoutYProperty().bind(panel2.heightProperty().multiply(y));
        label.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize, ";"));
    }


    private void setTumbler(ToggleButton tb, double x, double y){
        System.out.println(splitBox.heightProperty());
        tb.minHeightProperty().bind(splitBox.heightProperty().divide(12.356020942408376963350785340314));
        tb.minWidthProperty().bind(splitBox.heightProperty().divide(20));
        tb.maxHeightProperty().bind(splitBox.heightProperty().divide(12.356020942408376963350785340314));
        tb.maxHeightProperty().bind(splitBox.heightProperty().divide(20));
        tb.layoutXProperty().bind(splitBox.heightProperty().divide(2.5).multiply(x));
        tb.layoutYProperty().bind(splitBox.heightProperty().multiply(y));
    }

    private void setTumbler1(Button b, double x, double y){
        //buttonBase because using toggleButton and button at this method
        //0,6178010471204188481675392670157
        b.minHeightProperty().bind(splitBox.heightProperty().divide(20));
        b.minWidthProperty().bind(splitBox.heightProperty().divide(20));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(20));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(20));
        b.layoutXProperty().bind(splitBox.heightProperty().divide(2.5).multiply(x));
        b.layoutYProperty().bind(splitBox.heightProperty().multiply(y));
    }
}
