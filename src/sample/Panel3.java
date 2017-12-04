package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Panel3 extends Controller{
    private DoubleProperty fontSize = new SimpleDoubleProperty(6.1);
    private ArrayList<Label> labels = new ArrayList<>();

    private ArrayList<Circle> redLights =  new ArrayList<>();
    private ArrayList<Circle> blackLights =  new ArrayList<>();
    private ArrayList<Circle> greenLights = new ArrayList<>();
    private ArrayList<ToggleButton> blackButtons = new ArrayList<>();
    private ArrayList<Button> switchers = new ArrayList<>();
    private Line line1;
    private Rotate line1Rotation;

    public Rotate getLine3Rotation(){
        return line1Rotation;
    }

    public Line getLine1() {
        return line1;
    }

    public Circle yellowLight;
    public ArrayList<ToggleButton> getBlackButtons() {
        return blackButtons;
    }
    public ArrayList<Circle> getRedLights() {
        return redLights;
    }
    public Circle getYellowLight(){
        return yellowLight;
    }
    Panel3(){
        init();
        setPosition();
    }

    private void init(){
        fontSize.bind(panel2.heightProperty().divide(88));
        for (int i=1; i<=92;i++)
            labels.add ( (Label) root.lookup("#panel3Label" + i) );
        for (int i=1; i<=8;i++)
            redLights.add((Circle) root.lookup("#panel3redLight" + i));
        for (int i=1; i<=15; i++)
            blackLights.add((Circle) root.lookup("#panel3blackLight" + i));
        for (int i=1; i<=3; i++)
            greenLights.add((Circle) root.lookup("#panel3greenLight" + i));
        for (int i = 1; i<=12;i++)
            blackButtons.add((ToggleButton) root.lookup("#panel3BlackButton"+i));

        yellowLight = (Circle) root.lookup("#panel3yellowLight");
        for (int i=1; i<=3; i++)
            switchers.add( (Button) root.lookup("#panel3switch" + i)  );

        line1 = (Line) root.lookup("#panel3Line1");

        line1Rotation = new Rotate();
        line1Rotation.pivotXProperty().bind(line1.startXProperty());
        line1Rotation.pivotYProperty().bind(line1.startYProperty());
        line1.getTransforms().add(line1Rotation);


    }
    private void setPosition(){
        setLabel(labels.get(0), 0.15, 0.03, fontSize.divide(0.66));
        setLabel(labels.get(1), 0.45, 0.02, fontSize.divide(0.83));
        setLabel(labels.get(2), 0.17, 0.05, fontSize.divide(0.66));
        setLabel(labels.get(3), 0.4, 0.045);
        setLabel(labels.get(4), 0.385, 0.056);
        setLabel(labels.get(5), 0.465, 0.045);
        setLabel(labels.get(6), 0.465, 0.056);
        setLabel(labels.get(7), 0.64, 0.065);
        setLabel(labels.get(8), 0.685, 0.055);
        setLabel(labels.get(9), 0.685, 0.065);
        setLabel(labels.get(10), 0.5, 0.077, fontSize.divide(0.7));
        setLabel(labels.get(11), 0.35, 0.068);
        setLabel(labels.get(12), 0.35, 0.078);
        setLabel(labels.get(13), 0.34, 0.11);
        setLabel(labels.get(14), 0.315, 0.14);
        setLabel(labels.get(15), 0.34, 0.2);
        setLabel(labels.get(16), 0.68, 0.17, fontSize.divide(1.2));
        setLabel(labels.get(17), 0.825, 0.065, fontSize.divide(0.8));
        setLabel(labels.get(18), 0.815, 0.085, fontSize.divide(0.8));
        setLabel(labels.get(19), 0.315, 0.25);
        setLabel(labels.get(20), 0.32, 0.28);
        setLabel(labels.get(21), 0.38, 0.28);
        setLabel(labels.get(22), 0.475, 0.288);
        setLabel(labels.get(23), 0.56, 0.288);
        setLabel(labels.get(24), 0.64, 0.288);
        setLabel(labels.get(25), 0.68, 0.288, fontSize.divide(1.2));
        setLabel(labels.get(26), 0.5, 0.35);
        setLabel(labels.get(27), 0.1, 0.39);
        setLabel(labels.get(28), 0.143, 0.39,  fontSize.divide(1.2));
        setLabel(labels.get(29), 0.205, 0.39);
        setLabel(labels.get(30), 0.385, 0.39);
        setLabel(labels.get(31), 0.475, 0.39);
        setLabel(labels.get(32), 0.555, 0.39);
        setLabel(labels.get(33), 0.63, 0.39);
        setLabel(labels.get(34), 0.77, 0.4);
        setLabel(labels.get(35), 0.84, 0.4);
        setLabel(labels.get(36), 0.91, 0.4);
        setLabel(labels.get(37), 0.142, 0.44, fontSize.divide(1.2));
        setLabel(labels.get(38), 0.1445, 0.455);
        setLabel(labels.get(39), 0.23, 0.44);
        setLabel(labels.get(40), 0.245, 0.455);
        setLabel(labels.get(41), 0.25, 0.511);
        setLabel(labels.get(42), 0.415, 0.415);
        setLabel(labels.get(43), 0.425, 0.429);
        setLabel(labels.get(44), 0.425, 0.44);
        setLabel(labels.get(45), 0.15, 0.53);
        setLabel(labels.get(46), 0.325, 0.53);
        setLabel(labels.get(47), 0.11, 0.555);
        setLabel(labels.get(48), 0.19, 0.555);
        setLabel(labels.get(49), 0.27, 0.555);
        setLabel(labels.get(50), 0.33, 0.555);
        setLabel(labels.get(51), 0.38, 0.555);
        setLabel(labels.get(52), 0.5, 0.55);
        setLabel(labels.get(53), 0.63, 0.55);
        setLabel(labels.get(54), 0.69, 0.55);
        setLabel(labels.get(55), 0.815, 0.55);
        setLabel(labels.get(56), 0.85, 0.5);
        setLabel(labels.get(57), 0.87, 0.51);
        setLabel(labels.get(58), 0.11, 0.63);
        setLabel(labels.get(59), 0.33, 0.63);
        setLabel(labels.get(60), 0.08, 0.64);
        setLabel(labels.get(61), 0.14, 0.64);
        setLabel(labels.get(62), 0.3, 0.64);
        setLabel(labels.get(63), 0.36, 0.64);
        setLabel(labels.get(64), 0.6, 0.64);
        setLabel(labels.get(65), 0.678, 0.67);
        setLabel(labels.get(66), 0.71, 0.74);
        setLabel(labels.get(67), 0.86, 0.615);
        setLabel(labels.get(68), 0.11, 0.725);
        setLabel(labels.get(69), 0.09, 0.735);
        setLabel(labels.get(70), 0.16, 0.725);
        setLabel(labels.get(71), 0.225, 0.725);
        setLabel(labels.get(72), 0.315, 0.74);
        setLabel(labels.get(73), 0.38, 0.73);
        setLabel(labels.get(74), 0.37, 0.74);
        setLabel(labels.get(75), 0.105, 0.795);
        setLabel(labels.get(76), 0.07, 0.81);
        setLabel(labels.get(77), 0.13, 0.81);
        setLabel(labels.get(78), 0.3, 0.86, fontSize.divide(1.2) );
        setLabel(labels.get(79), 0.355, 0.86, fontSize.divide(1.2) );
        setLabel(labels.get(80), 0.36, 0.92, fontSize.divide(1.2) );
        setLabel(labels.get(81), 0.37, 0.83);
        setLabel(labels.get(82), 0.5, 0.79);
        setLabel(labels.get(83), 0.48, 0.81);
        setLabel(labels.get(84), 0.55, 0.81);
        setLabel(labels.get(85), 0.745, 0.8);
        setLabel(labels.get(86), 0.81, 0.79);
        setLabel(labels.get(87), 0.9, 0.785);
        setLabel(labels.get(88), 0.88, 0.8);
        setLabel(labels.get(89), 0.75, 0.88);
        setLabel(labels.get(90), 0.82, 0.88);
        setLabel(labels.get(91), 0.9, 0.88);

        setLight(redLights.get(0), 0.407, 0.11);
        setLight(redLights.get(1), 0.47, 0.11);
        setLight(redLights.get(2), 0.65, 0.11);
        setLight(redLights.get(3), 0.715, 0.205);
        setLight(redLights.get(4), 0.715, 0.325);
        setLight(redLights.get(5), 0.259, 0.49);
        setLight(redLights.get(6), 0.83, 0.59);
        setLight(redLights.get(7), 0.93, 0.59);
        setLight(blackLights.get(0), 0.393, 0.325);
        setLight(blackLights.get(1), 0.485, 0.325);
        setLight(blackLights.get(2), 0.575, 0.325);
        setLight(blackLights.get(3), 0.65, 0.325);
        setLight(blackLights.get(4), 0.393, 0.425);
        setLight(blackLights.get(5), 0.8, 0.435);
        setLight(blackLights.get(6), 0.1247, 0.59);
        setLight(blackLights.get(7), 0.21, 0.59);
        setLight(blackLights.get(8), 0.284, 0.59);
        setLight(blackLights.get(9), 0.347, 0.59);
        setLight(blackLights.get(10), 0.4, 0.59);
        setLight(blackLights.get(11), 0.715, 0.59);
        setLight(blackLights.get(12), 0.118, 0.78);
        setLight(blackLights.get(13), 0.396, 0.79);
        setLight(blackLights.get(14), 0.396, 0.87);
        setLight(greenLights.get(0), 0.645, 0.435);
        setLight(greenLights.get(1), 0.872, 0.435);
        setLight(greenLights.get(2), 0.94, 0.435);

        setButton(blackButtons.get(0), 0.32, 0.3);
        setButton(blackButtons.get(1), 0.11, 0.41);
        setButton(blackButtons.get(2), 0.19, 0.41);

        setButton(blackButtons.get(3), 0.42, 0.47);

        setButton(blackButtons.get(4), 0.075, 0.66);
        setButton(blackButtons.get(5), 0.14, 0.66);
        setButton(blackButtons.get(6), 0.3, 0.66);
        setButton(blackButtons.get(7), 0.365, 0.66);
        setButton(blackButtons.get(8), 0.18, 0.75);
        setButton(blackButtons.get(9), 0.25, 0.75);

        setButton(blackButtons.get(10), 0.065, 0.83);
        setButton(blackButtons.get(11), 0.125, 0.83);

        setBigLight(yellowLight, 0.65, 0.59);

        setTumbler(switchers.get(0), 0.81265, 0.645);
        setTumbler(switchers.get(1), 0.91405, 0.645);
        setTumbler(switchers.get(2), 0.64, 0.825);

        line1.startXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(0.845));
        line1.startYProperty().bind(splitBox.heightProperty().multiply(0.268));
        line1.endXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(0.78));
        line1.endYProperty().bind(splitBox.heightProperty().multiply(0.2));
        switchers.get(0).setOnAction(ev -> SwitchRotate(switchers.get(0)));
        switchers.get(1).setOnAction(ev -> SwitchRotate(switchers.get(1)));

        switchers.get(2).setOnAction(ev -> {
            switch ((int) switchers.get(2).getRotate()) {
                case 0:
                    switchers.get(2).setRotate(40);
                    break;
                case 40:
                    switchers.get(2).setRotate(-40);
                    break;
                case -40:
                    switchers.get(2).setRotate(0);
                    break;
            }
        });
        blackButtons.forEach(e -> e.setOnAction(event -> Main.decreaseMark()));


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

    private void setBigLight(Circle circle, double x, double y){
        circle.layoutYProperty().bind(panel3.heightProperty().multiply(y));
        circle.layoutXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(x));
        circle.radiusProperty().bind(panel3.heightProperty().divide(40));
        circle.styleProperty().bind(Bindings.concat("-fx-stroke-width: ", circle.getRadius()/4 , ";"));
        circle.setEffect(new Lighting());
    }

    private void setLight(Circle circle, double x, double y){
        circle.layoutYProperty().bind(panel3.heightProperty().multiply(y));
        circle.layoutXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(x));
        circle.radiusProperty().bind(panel3.heightProperty().divide(60));
        circle.styleProperty().bind(Bindings.concat("-fx-stroke-width: ", circle.getRadius()/4 , ";"));
        circle.setEffect(new Lighting());
    }

    private void setButton(ToggleButton tb, double x, double y) {
        Circle cir = new Circle(1);

        cir.radiusProperty().bind(panel3.heightProperty().divide(50));
        tb.setShape(cir);


        cir.styleProperty().bind(Bindings.concat("-fx-stroke-width: ", cir.getRadius() / 4, ";"));

        tb.minHeightProperty().bind(splitBox.heightProperty().divide(50).multiply(2));
        tb.minWidthProperty().bind(splitBox.heightProperty().divide(50).multiply(2));
        tb.maxHeightProperty().bind(splitBox.heightProperty().divide(50).multiply(2));
        tb.maxHeightProperty().bind(splitBox.heightProperty().divide(50).multiply(2));

        tb.layoutXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(x));
        tb.layoutYProperty().bind(splitBox.heightProperty().multiply(y));

        tb.setEffect(lighting);
        tb.setOnAction(e -> {
            if (tb.isSelected()) {
                tb.setEffect(new InnerShadow());
            } else {
                tb.setEffect(lighting);
            }
        });

    }

    private void setTumbler(ButtonBase b, double x, double y){
        //buttonBase because using toggleButton and button at this method
        //0,6178010471204188481675392670157
        b.minHeightProperty().bind(splitBox.heightProperty().divide(13));
        b.minWidthProperty().bind(splitBox.heightProperty().divide(25));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(13));
        b.maxHeightProperty().bind(splitBox.heightProperty().divide(25));
        b.layoutXProperty().bind(splitBox.heightProperty().divide(0.75).multiply(x));
        b.layoutYProperty().bind(splitBox.heightProperty().multiply(y));
    }

    private void SwitchRotate(Button b){
        switch ((int) b.getRotate()) {
            case 0:
                b.setRotate(36);
                break;
            case 36:
                b.setRotate(72);
                break;
            case 72:
                b.setRotate(108);
                break;
            case 108:
                b.setRotate(144);
                break;
            case 144:
                b.setRotate(180);
                break;
            case 180:
                b.setRotate(216);
                break;
            case 216:
                b.setRotate(252);
                break;
            case 252:
                b.setRotate(288);
                break;
            case 288:
                b.setRotate(324);
                break;
            case 324:
                b.setRotate(0);
                break;
        }
    }


}
