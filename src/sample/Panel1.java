package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Bloom;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Panel1 extends Controller{
    private ArrayList<Circle> redLights = new ArrayList<>();
    private Circle yellowLight1;  //yellowLight
    private ArrayList<Circle> greenLights = new ArrayList<>();     //greenLights
    private ArrayList<Circle> blackLights = new ArrayList<>();    //blackLight
    private ArrayList<Circle> allLights = new ArrayList<>();     //All lights
    private ArrayList<Label> labels = new ArrayList<>();                //strings
    private ArrayList<Button> grayButtons = new ArrayList<>();   //gray buttons
    private ArrayList<Button> redButtons = new ArrayList<>();   //red buttons
    private ArrayList<ToggleButton> tumblers = new ArrayList<>();    //lights check 1(2) element
    private ArrayList<Button> tumblerButtons = new ArrayList<>();
    //private Button buttonHP;


    private DoubleProperty fontSize = new SimpleDoubleProperty(11);
    private ArrayList<Circle> active = new ArrayList<>();
    private Set<Button> activeButtons = new HashSet<>();


    public  void addActive(Circle c){
        active.add(c);
    }
    public void removeActive(Circle c){ active.remove(c);}

    public ArrayList<Circle> getActive() {
        return active;
    }
    public ArrayList<Circle> getRedLights(){return redLights;}
    public ArrayList<Circle> getGreenLights(){return greenLights;}
    public ArrayList<Circle> getBlackLights(){return blackLights;}
    public ArrayList<Circle> getAllLights(){return allLights;}
    public Circle getYellowLight(){return yellowLight1;}
    public ArrayList<Label> getLabels(){return labels;}
    public ArrayList<Button> getGrayButtons(){return grayButtons;}
    public ArrayList<Button> getRedButtons() {return redButtons;}
    public ArrayList<ToggleButton> getTumblers() {return tumblers;}
    public ArrayList<Button> getTumblerButtons() {return tumblerButtons;}

    public Set<Button> getActiveButtons() { return activeButtons; }
    private Line line1;
    private Line line2;
    private Line line3;

    private Rotate line1Rotation;
    private Rotate line2Rotation;
    private Rotate line3Rotation;

    public Rotate getLine1Rotation() { return line1Rotation; }
    public Rotate getLine2Rotation() { return line2Rotation; }
    public Rotate getLine3Rotation() { return line3Rotation; }
    public Line getLine2(){return line2;}

    Panel1(){
        init();
        setPosition();
    }

    private void init(){
        //labels
        for (int i= 1; i<=49; i++)
            labels.add((Label) root.lookup("#panel1Label" + i));
        //lights
        //red
        for (int i=1; i<=5;i++)
            redLights.add((Circle) root.lookup("#redLight" + i));
        //green
        for (int i=1; i<=10;i++)
            greenLights.add((Circle) root.lookup("#greenLight" + i));
        //others
        for (int i=1; i<=2;i++)
            blackLights.add((Circle) root.lookup("#blackLight" + i));
        //yellow
        yellowLight1 = (Circle) root.lookup("#yellowLight1");
            //buttons
        //gray
        for (int i=1; i <= 7; i++)
            grayButtons.add((Button) root.lookup("#grayButton" + i));

        //buttonHP = (Button) root.lookup("#grayButtonBT");

        for (int i =1; i<=2; i++){
            tumblers.add((ToggleButton) root.lookup("#panel1tumbler" + i));
            tumblerButtons.add( (Button) root.lookup( "#panel1tumblerButton" + i));
            redButtons.add((Button) root.lookup("#redButton" + i));
        }

        line1 = (Line) root.lookup("#line1");
        line2 = (Line) root.lookup("#line2");
        line3 = (Line) root.lookup("#line3");

        line1Rotation = new Rotate();
        line2Rotation = new Rotate();
        line3Rotation = new Rotate();


        allLights.addAll(greenLights);
        allLights.addAll(redLights);
        allLights.addAll(blackLights);
        allLights.add(yellowLight1);


    }

    private void setPosition() {
        fontSize.bind(panel1.heightProperty().divide(57.363636));
        //labels
        setLabel(labels.get(0), 0.15, 0.017);
        setLabel(labels.get(1), 0.65, 0.017);
        setLabel(labels.get(2), 0.1, 0.035);
        setLabel(labels.get(3), 0.3, 0.035);
        setLabel(labels.get(4), 0.48, 0.035);
        setLabel(labels.get(5), 0.64, 0.035);
        setLabel(labels.get(6), 0.8, 0.035);
        setLabel(labels.get(7), 0.425, 0.108);
        setLabel(labels.get(8), 0.425, 0.19);
        setLabel(labels.get(9), 0.06, 0.2675);
        setLabel(labels.get(10), 0.2675, 0.2675);
        setLabel(labels.get(11), 0.43, 0.2675);
        setLabel(labels.get(12), 0.65, 0.2675);
        setLabel(labels.get(13), 0.76, 0.2675);
        setLabel(labels.get(14), 0.067, 0.339);
        setLabel(labels.get(15), 0.77, 0.339);
        setLabel(labels.get(16), 0.095, 0.42);
        setLabel(labels.get(17), 0.28, 0.42);
        setLabel(labels.get(18), 0.1, 0.445);
        setLabel(labels.get(19), 0.31, 0.445);
        setLabel(labels.get(20), 0.69, 0.425, panel1.heightProperty().divide(95));
        setLabel(labels.get(21), 0.76, 0.412, panel1.heightProperty().divide(95));
        setLabel(labels.get(22), 0.82, 0.425, panel1.heightProperty().divide(95));
        setLabel(labels.get(23), 0.1, 0.48);
        setLabel(labels.get(24), 0.35, 0.459, panel1.heightProperty().divide(70));
        setLabel(labels.get(25), 0.68, 0.47);
        setLabel(labels.get(26), 0.4, 0.471, panel1.heightProperty().divide(65));
        setLabel(labels.get(27), 0.55, 0.471, panel1.heightProperty().divide(65));
        setLabel(labels.get(28), 0.36, 0.519, panel1.heightProperty().divide(75));
        setLabel(labels.get(29), 0.2, 0.568, panel1.heightProperty().divide(67));
        setLabel(labels.get(30), 0.35, 0.568, panel1.heightProperty().divide(67));
        setLabel(labels.get(31), 0.47, 0.568, panel1.heightProperty().divide(67));
        setLabel(labels.get(32), 0.59, 0.568, panel1.heightProperty().divide(67));
        setLabel(labels.get(33), 0.67, 0.568, panel1.heightProperty().divide(67));
        setLabel(labels.get(34), 0.7, 0.58, panel1.heightProperty().divide(67));
        setLabel(labels.get(35), 0.23, 0.59, panel1.heightProperty().divide(70));
        setLabel(labels.get(36), 0.23, 0.645, panel1.heightProperty().divide(70));
        setLabel(labels.get(37), 0.23, 0.655);
        setLabel(labels.get(38), 0.26, 0.668);
        setLabel(labels.get(39), 0.379, 0.677, panel1.heightProperty().divide(90));
        setLabel(labels.get(40), 0.5, 0.667, panel1.heightProperty().divide(90));
        setLabel(labels.get(41), 0.5, 0.677, panel1.heightProperty().divide(90));
        setLabel(labels.get(42), 0.182, 0.705, panel1.heightProperty().divide(75));
        setLabel(labels.get(43), 0.188, 0.728, panel1.heightProperty().divide(90));
        setLabel(labels.get(44), 0.4311, 0.729, panel1.heightProperty().divide(70));
        setLabel(labels.get(45), 0.283, 0.79);
        setLabel(labels.get(46), 0.66, 0.79);

        setLabel(labels.get(47), 0.26, 0.355, panel1.heightProperty().divide(67) );
        setLabel(labels.get(48), 0.63, 0.355, panel1.heightProperty().divide(67));
        //lights
        //red
        setLight(redLights.get(0), 0.16, 0.078);
        setLight(redLights.get(1), 0.69, 0.078);
        setLight(redLights.get(2), 0.835, 0.078);
        setLight(redLights.get(3), 0.425, 0.71);
        setLight(redLights.get(4), 0.57, 0.71);
        //green
        setLight(greenLights.get(0), 0.33, 0.078);
        setLight(greenLights.get(1), 0.16, 0.315);
        setLight(greenLights.get(2), 0.84, 0.315);
        setLight(greenLights.get(3), 0.325, 0.4);
        setLight(greenLights.get(4), 0.67, 0.4);
        setLight(greenLights.get(5), 0.255, 0.552);
        setLight(greenLights.get(6), 0.378, 0.552);
        setLight(greenLights.get(7), 0.5, 0.552);
        setLight(greenLights.get(8), 0.62, 0.552);
        setLight(greenLights.get(9), 0.745, 0.552);

        setLight(yellowLight1, 0.5, 0.078);
        setLight(blackLights.get(0), 0.5, 0.148);
        setLight(blackLights.get(1), 0.5, 0.23);

        //buttons
        setButton(grayButtons.get(0), 0.282, 0.29);

        setButton(grayButtons.get(1), 0.621, 0.29);

        setButton(grayButtons.get(2), 0.107, 0.361);
        setButton(grayButtons.get(3), 0.79, 0.361);
        setButton(grayButtons.get(4), 0.325, 0.597);
        setButton(grayButtons.get(5), 0.445, 0.597);
        setButton(grayButtons.get(6), 0.57, 0.597);

        setButton(redButtons.get(0), 0.45, 0.29);
        setButton(redButtons.get(1), 0.449, 0.75);

        setTumbler(tumblers.get(0), 0.23, 0.605);
        setTumbler(tumblers.get(1), 0.27, 0.69);
        setTumbler1(tumblerButtons.get(0), 0.185, 0.435);
        setTumbler(tumblerButtons.get(1), 0.745, 0.435);

        line1.startXProperty().bind(splitBox.heightProperty().divide(2).multiply(0.74));
        line1.startYProperty().bind(splitBox.heightProperty().multiply(0.195));
        line1.endXProperty().bind(splitBox.heightProperty().divide(2).multiply(0.88));
        line1.endYProperty().bind(splitBox.heightProperty().multiply(0.195));

        line2.startXProperty().bind(splitBox.heightProperty().divide(2).multiply(0.255));
        line2.startYProperty().bind(splitBox.heightProperty().multiply(0.195));
        line2.endXProperty().bind(splitBox.heightProperty().divide(2).multiply(0.14));
        line2.endYProperty().bind(splitBox.heightProperty().multiply(0.23));

        line3.startXProperty().bind(splitBox.heightProperty().divide(2).multiply(0.5));
        line3.startYProperty().bind(splitBox.heightProperty().multiply(0.4));
        line3.endXProperty().bind(splitBox.heightProperty().divide(2).multiply(0.423));
        line3.endYProperty().bind(splitBox.heightProperty().multiply(0.425));


        //events
        tumblers.get(1).setOnMouseClicked(ev -> {
            if (tumblers.get(1).isSelected()) {
                lightsCheck();
            } else {
                lightsUncheck();
            }
        });

        //контр напр гап ивп гом
        tumblerButtons.get(0).setOnMouseClicked(event -> {
            switch ((int) tumblerButtons.get(0).getRotate()) {
                case 0:
                    tumblerButtons.get(0).setRotate(90);
                    break;
                case 90:
                    tumblerButtons.get(0).setRotate(140);
                    break;
                case 140:
                    tumblerButtons.get(0).setRotate(320);
                    break;
                case 320:
                    tumblerButtons.get(0).setRotate(0);
                    break;
            }
        });

        //контр напр А-В В-С С-А
        tumblerButtons.get(1).setOnMouseClicked((event1) -> {
            switch ((int) tumblerButtons.get(1).getRotate()) {
                case 0:
                    tumblerButtons.get(1).setRotate(30);
                    break;
                case 30:
                    tumblerButtons.get(1).setRotate(330);
                    break;
                case 330:
                    tumblerButtons.get(1).setRotate(0);
                    break;
            }
        });

        //холодная прокрутка хп
        grayButtons.get(1).setOnMousePressed(event -> {
            line1Rotation.pivotXProperty().bind(line1.startXProperty());
            line1Rotation.pivotYProperty().bind(line1.startYProperty());
            line1.getTransforms().add(line1Rotation);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(3900), new KeyValue(line1Rotation.angleProperty(), 60)),
                    new KeyFrame(Duration.millis(5300), new KeyValue(line1Rotation.angleProperty(), 60)),
                    new KeyFrame(Duration.millis(8700), new KeyValue(line1Rotation.angleProperty(), 0)));
            timeline.setAutoReverse(true);
            timeline.play();
            activeButtons.add(grayButtons.get(1));

        });

        //запуск гап
        grayButtons.get(0).setOnAction(event -> {

            line1Rotation.pivotXProperty().bind(line1.startXProperty());
            line1Rotation.pivotYProperty().bind(line1.startYProperty());
            line1.getTransforms().add(line1Rotation);
            line2Rotation.pivotXProperty().bind(line2.startXProperty());
            line2Rotation.pivotYProperty().bind(line2.startYProperty());
            line2.getTransforms().add(line2Rotation);
            line3Rotation.pivotXProperty().bind(line3.startXProperty());
            line3Rotation.pivotYProperty().bind(line3.startYProperty());
            line3.getTransforms().add(line3Rotation);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(8600), new KeyValue(line1Rotation.angleProperty(), 235)),
                    new KeyFrame(Duration.millis(8600), new KeyValue(line2Rotation.angleProperty(), 225)),
                    new KeyFrame(Duration.millis(8600), event1 -> {
                                activeButtons.add(grayButtons.get(0));
                                addActive(yellowLight1);
                                lightOn(yellowLight1);
                                addActive(greenLights.get(3));
                                lightOn(greenLights.get(3));
                            }),
                    new KeyFrame(Duration.millis(16000), new KeyValue(line3Rotation.angleProperty(), 185)),
                    new KeyFrame(Duration.millis(16000), new KeyValue(line1Rotation.angleProperty(), 257)),
                    new KeyFrame(Duration.millis(16000), new KeyValue(line2Rotation.angleProperty(), 145))
            );
            timeline.play();

            //removeRed Buton
            //activeButtons.remove( )
        });

        //питание управления
        tumblers.get(0).setOnMouseClicked(e -> {
            if (tumblers.get(0).isSelected()) {
                lightOn(greenLights.get(2));
                lightOn(greenLights.get(5));
                addActive(greenLights.get(5));
                addActive(greenLights.get(2));
            } else {
                removeActive(greenLights.get(5));
                removeActive(greenLights.get(2));
                if (!getActive().contains(greenLights.get(2)) || !getActive().contains(greenLights.get(5))) {
                    lightOff(greenLights.get(2));
                    lightOff(greenLights.get(5));
                }
            }
        });

        //open Luke
        grayButtons.get(2).setOnAction(e -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ev -> {
                lightOn(greenLights.get(1));
                addActive(greenLights.get(1));
            }));
            timeline.play();
            removeActive(greenLights.get(2));
            lightOff(greenLights.get(2));
        });

        //close luke
        grayButtons.get(3).setOnAction(e -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ev -> {
                lightOn(greenLights.get(2));
                addActive(greenLights.get(2));
            }));
            timeline.play();
            removeActive(greenLights.get(1));
            lightOff(greenLights.get(1));
        });



    }

    private void lightsCheck(){
        allLights.forEach(e -> {
            e.setEffect(new Bloom());
            active.add(e);
        });
        redLights.forEach(l -> l.setFill(Color.rgb(255, 0,0 )));
        greenLights.forEach(l -> l.setFill((Color.rgb(50,255,50 ))));
        blackLights.forEach(l -> l.setFill((Color.rgb(250,250,250 ))));
        yellowLight1.setFill(Color.rgb(233,255, 125));
    }

    private void lightsUncheck(){
        allLights.forEach(e -> {
            active.remove(e);
            if(!active.contains(e))
                e.setEffect(lighting);
        });
        redLights.forEach(l -> {
            if(!active.contains(l)){
                l.getStyleClass().clear();
                l.getStyleClass().add("redLight");
            }
        });
        greenLights.forEach(l -> {
            if(!active.contains(l)) {
                l.getStyleClass().clear();
                l.getStyleClass().add("greenLight");
            }
        });
        blackLights.forEach(l -> {
            if(!active.contains(l)){
                l.getStyleClass().clear();
                l.getStyleClass().add("blackLight");
            }
        });
        if(!active.contains(yellowLight1)){
            yellowLight1.getStyleClass().clear();
            yellowLight1.getStyleClass().add("#yellowLight1");
        }
    }

    private void setButton(ButtonBase tb, double x, double y){
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
        //circle.setEffect(new Lighting());
        circle.setEffect(lighting);
    }

    private void setTumbler(ButtonBase b, double x, double y){
        //buttonBase because using toggleButton and button at this method
        //0,6178010471204188481675392670157
        b.minHeightProperty().bind(splitBox.heightProperty().divide(20.387434554973821989528795811518));
        b.minWidthProperty().bind(splitBox.heightProperty().divide(33));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(20.387434554973821989528795811518));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(33));
        b.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        b.layoutYProperty().bind(splitBox.heightProperty().multiply(y));
    }

    private void setTumbler1(Button b, double x, double y){
        //buttonBase because using toggleButton and button at this method
        b.minHeightProperty().bind(splitBox.heightProperty().divide(20));
        b.minWidthProperty().bind(splitBox.heightProperty().divide(20));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(20));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(20));
        b.layoutXProperty().bind(splitBox.heightProperty().divide(2).multiply(x));
        b.layoutYProperty().bind(splitBox.heightProperty().multiply(y));
    }
}
