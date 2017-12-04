package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Panel2 extends Controller{
    //labels
    private boolean lightsWasChecked = false;
    private ArrayList<Label> labels = new ArrayList<>();
    private ArrayList<Circle> greenLights = new ArrayList<>();
    private Circle redLight1;
    private ArrayList<ToggleButton> tumblers = new ArrayList<>();
    private ArrayList<Button> tumblerButtons = new ArrayList<>();

    public ArrayList<Label> getLabels(){return labels;}
    public ArrayList<Circle> getGreenLights(){return greenLights;}
    public Circle getRedLight() { return redLight1; }
    public ArrayList<ToggleButton> getTumblers() { return tumblers; }
    public ArrayList<Button> getTumblerButtons() { return tumblerButtons; }
    private DoubleProperty fontSize = new SimpleDoubleProperty(11);

    Panel2(){
        init();
        setPosition();
    }

    private void init(){
        fontSize.bind(panel2.heightProperty().divide(88));
        for (int i=1; i<=25; i++)
            labels.add( (Label) root.lookup("#panel2Label" + i));

        for (int i=1; i<4;i++){
            greenLights.add((Circle) root.lookup("#panel2greenLight" + i));
        }
        redLight1 = (Circle) root.lookup("#panel2redLight1");

        for (int i = 1; i <= 8; i++)
            tumblers.add( (ToggleButton) root.lookup("#panel2tumbler" + i) );
        for (int i = 1; i <= 2; i++)
            tumblerButtons.add( (Button) root.lookup("#panel2tumblerButton" + i));
    }

    private void setPosition(){
        setLabel(labels.get(0), 0.32, 0.012, panel2.heightProperty().divide(50));
        setLabel(labels.get(1), 0.68, 0.055, panel2.heightProperty().divide(88));
        setLabel(labels.get(2), 0.65, 0.066, panel2.heightProperty().divide(92));
        setLabel(labels.get(3), 0.83, 0.066, panel2.heightProperty().divide(92));
        setLabel(labels.get(4), 0.608, 0.093, panel2.heightProperty().divide(92));
        setLabel(labels.get(5), 0.9, 0.097, panel2.heightProperty().divide(92));
        setLabel(labels.get(6), 0.5, 0.18, panel2.heightProperty().divide(90));
        setLabel(labels.get(7), 0.09, 0.288, panel2.heightProperty().divide(110));
        setLabel(labels.get(8), 0.38, 0.283, panel2.heightProperty().divide(100));
        setLabel(labels.get(9), 0.56, 0.283, panel2.heightProperty().divide(100));
        setLabel(labels.get(10), 0.745, 0.283, panel2.heightProperty().divide(100));
        setLabel(labels.get(11),0.19, 0.362,  panel2.heightProperty().divide(88));
        setLabel(labels.get(12),0.365, 0.362,  panel2.heightProperty().divide(88));
        setLabel(labels.get(13),0.55, 0.362,  panel2.heightProperty().divide(88));
        setLabel(labels.get(14),0.735, 0.362,  panel2.heightProperty().divide(88));
        setLabel(labels.get(15),0.15, 0.39,  panel2.heightProperty().divide(88));
        setLabel(labels.get(16),0.17, 0.40,  panel2.heightProperty().divide(88));
        setLabel(labels.get(17),0.36, 0.39,  panel2.heightProperty().divide(88));
        setLabel(labels.get(18),0.65, 0.39,  panel2.heightProperty().divide(88));
        setLabel(labels.get(19),0.19, 0.47,  panel2.heightProperty().divide(88));
        setLabel(labels.get(20),0.37, 0.47,  panel2.heightProperty().divide(88));
        setLabel(labels.get(21),0.55, 0.47,  panel2.heightProperty().divide(88));
        setLabel(labels.get(22),0.77, 0.486,  panel2.heightProperty().divide(88));
        setLabel(labels.get(23),0.86, 0.495,  panel2.heightProperty().divide(88));
        setLabel(labels.get(24),0.68, 0.555,  panel2.heightProperty().divide(88));
        setLight(greenLights.get(0), 0.41, 0.26);
        setLight(greenLights.get(1), 0.72, 0.26);
        setLight(greenLights.get(2), 0.84, 0.26);
        setLight(redLight1, 0.59, 0.26);
        setTumbler(tumblers.get(0), 0.17, 0.3);
        setTumbler(tumblers.get(1), 0.35, 0.3);
        setTumbler(tumblers.get(2), 0.535, 0.3);
        setTumbler(tumblers.get(3), 0.717, 0.3);
        setTumbler(tumblers.get(4), 0.17, 0.405);
        setTumbler(tumblers.get(5), 0.35, 0.405);
        setTumbler(tumblers.get(6), 0.535, 0.405);
        setTumbler(tumblers.get(7), 0.717, 0.405);

        setTumbler1(tumblerButtons.get(0), 0.745,0.085);
        setTumbler1(tumblerButtons.get(1), 0.745,0.5);
        tumblerButtons.get(0).setOnMouseClicked(ev ->{
            switch ((int) tumblerButtons.get(0).getRotate()){
                case 325:
                    tumblerButtons.get(0).setRotate(0);
                    break;
                case 0:
                    tumblerButtons.get(0).setRotate(52);
                    break;
                case 52:
                    tumblerButtons.get(0).setRotate(90);
                    break;
                case 90:
                    tumblerButtons.get(0).setRotate(130);
                    break;
                case 130:
                    tumblerButtons.get(0).setRotate(325);
                    break;
            }
        });

        tumblerButtons.get(1).setOnMouseClicked(ev ->{
            switch ((int) tumblerButtons.get(1).getRotate()){
                case 52:
                    tumblerButtons.get(1).setRotate(100);
                    lightsWasChecked = true;
                    lightsCheck();
                    break;
                case 100:
                    tumblerButtons.get(1).setRotate(52);
                    lightsUnchek();
                    break;
            }
        });

        tumblers.get(4).setOnAction(et -> {
            Main.activatePanel = true;
            Main.hint.getHint(tumblers.get(4));
            if (!lightsWasChecked){
                Main.decreaseMark();
            }
        });

    }

    private void lightsCheck(){
        redLight1.setFill(Color.rgb(255, 0,0 ));
        greenLights.forEach(l -> l.setFill((Color.rgb(50,255,50 ))));
        redLight1.setEffect(new Bloom());
        greenLights.forEach(l -> l.setEffect(new Bloom()));
    }

    private void lightsUnchek(){
        redLight1.getStyleClass().add("redLight");
        redLight1.setEffect(new Lighting());
        greenLights.forEach(l -> l.setEffect(new Lighting()));
        greenLights.forEach(l -> l.getStyleClass().clear());
        greenLights.forEach(l -> l.getStyleClass().add("greenLight"));
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
