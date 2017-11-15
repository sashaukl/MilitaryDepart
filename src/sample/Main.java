package sample;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.effect.Bloom;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    //private Circle redLight4;
    public static Stage primaryStage;
    public static Parent root;
    public static Scene scene;
    public static boolean activatePanel = false;
    private Lighting lighting = new Lighting();
    public static boolean learnMode = true;
    protected Panel1 panel1;
    protected Panel2 panel2;
    protected Panel3 panel3;

    private static int mark = 5;

    public static void decreaseMark(){
        mark--;
        System.out.println(mark);
    }

    public static HintMode hint;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        startPanel(true);
    }

    private void startPanel(boolean activationMode){
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        // Create lighting effect
        lighting.setLight(light);
        lighting.setSurfaceScale(4.0);

        //root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        try {
            primaryStage.setTitle("Тренажер системы автономного электроснабжения изделя МСНР-9С32");

            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(false);
            primaryStage.setMaximized(true);
            primaryStage.show();
            panel1 = new Panel1();
            panel2 = new Panel2();
            panel3 = new Panel3();

            hint = new HintMode(activationMode);
            hint.getHint(null);
            panel1.getGrayButtons().get(4).setOnAction(ev1 -> {
                if (!panel1.getActiveButtons().contains(panel1.getGrayButtons().get(4)) && activatePanel) {
                    panel1.lightOn(panel1.getGreenLights().get(6));
                    panel1.addActive(panel1.getGreenLights().get(6));
                    panel1.lightOn(panel1.getRedLights().get(4));
                    panel1.addActive(panel1.getRedLights().get(4));
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(4));
                    panel3.lightOn(panel3.getYellowLight());
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.millis(4000), new KeyValue(panel3.getLine3Rotation().angleProperty(), 80)),
                            new KeyFrame(Duration.millis(4000), new KeyValue(panel1.getLine2Rotation().angleProperty(), 178)),
                            new KeyFrame(Duration.millis(11000), event2 -> {
                                panel1.removeActive(panel1.getRedLights().get(4));
                                panel1.lightOff(panel1.getRedLights().get(4));
                                panel3.lightOff(panel3.getRedLights().get(0));
                            }));
                    timeline.play();
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(4));
                    hint.getHint(panel1.getGrayButtons().get(4));
                } else {
                    System.out.println("ГАП");
                }
            });

            //откл нагр
            panel1.getRedButtons().get(1).setOnAction(offPower -> {
                if (!panel1.getActive().contains(panel1.getRedLights().get(4)) && panel1.getActiveButtons().contains(panel1.getGrayButtons().get(4)) && activatePanel) {
                    panel1.getActiveButtons().remove(panel1.getGrayButtons().get(4));
                    panel1.removeActive(panel1.getGreenLights().get(6));
                    panel1.lightOff(panel1.getGreenLights().get(6));
                    panel1.getActiveButtons().add(panel1.getRedButtons().get(1) );
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.millis(4000), new KeyValue(panel3.getLine3Rotation().angleProperty(), 0)),
                            new KeyFrame(Duration.millis(4000), ev->hint.getHint(panel1.getRedButtons().get(1)))
                    );
                    timeline.play();

                    panel3.lightOff(panel3.yellowLight);
                } else {
                    decreaseMark();
                    System.out.println("отключить нагревание ошибка");
                }
            });

            //откл гап стоп гап
            panel1.getRedButtons().get(0).setOnAction(stopGap -> {
                if (panel1.getActiveButtons().contains(panel1.getRedButtons().get(1)) && activatePanel) {
                    panel1.getActiveButtons().remove(panel1.getRedButtons().get(1));
                    panel1.getActiveButtons().add(panel1.getRedButtons().get(0));
                    panel1.lightOff(panel1.getYellowLight());
                    panel1.lightOff(panel1.getGreenLights().get(3));
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.millis(6000), new KeyValue(panel1.getLine1Rotation().angleProperty(), 0)),
                            new KeyFrame(Duration.millis(6000), new KeyValue(panel1.getLine2Rotation().angleProperty(), 0)),
                            new KeyFrame(Duration.millis(6000), new KeyValue(panel1.getLine3Rotation().angleProperty(), 0)),
                            new KeyFrame(Duration.millis(6000), e->{ hint.getHint(panel1.getRedButtons().get(0) ); } ));
                    timeline.play();
                } else {
                    decreaseMark();
                    System.out.println("Stop gap mistake");
                }
            });
        }
        catch (Exception e){}
    }



    public void TurnOnPower(){
        startPanel(true);
    }

    public void TurnOffPower(){
        startPanel(false);

        panel1.getLine1Rotation().pivotXProperty().bind(panel1.getLine1().startXProperty());
        panel1.getLine1Rotation().pivotYProperty().bind(panel1.getLine1().startYProperty());
        panel1.getLine1().getTransforms().add(panel1.getLine1Rotation());
        panel1.getLine2Rotation().pivotXProperty().bind(panel1.getLine2().startXProperty());
        panel1.getLine2Rotation().pivotYProperty().bind(panel1.getLine2().startYProperty());
        panel1.getLine2().getTransforms().add(panel1.getLine2Rotation());
        panel1.getLine3Rotation().pivotXProperty().bind(panel1.getLine3().startXProperty());
        panel1.getLine3Rotation().pivotYProperty().bind(panel1.getLine3().startYProperty());
        panel1.getLine3().getTransforms().add(panel1.getLine3Rotation());
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1), ev ->{
                    panel1.lightOn(panel1.getYellowLight());
                    panel1.lightOn(panel1.getGreenLights().get(1));
                    panel1.lightOn(panel1.getGreenLights().get(3));
                    panel1.lightOn(panel1.getGreenLights().get(5));
                    panel1.lightOn(panel1.getGreenLights().get(6));
                    panel3.lightOn(panel3.yellowLight);
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(0));
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(1));
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(2));
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(4));
                    panel1.getTumblerButtons().get(0).setRotate(320);
                    panel1.getTumblers().get(0).setSelected(true);
                    panel2.getTumblers().get(4).setSelected(true);
                    panel1.getActiveButtons().add( panel1.getGrayButtons().get(4) );
                    activatePanel = true;
                }),
                new KeyFrame(Duration.millis(1), new KeyValue(panel1.getLine2Rotation().angleProperty(), 145)),
                new KeyFrame(Duration.millis(1), new KeyValue(panel1.getLine1Rotation().angleProperty(), 257)),
                new KeyFrame(Duration.millis(1), new KeyValue(panel1.getLine3Rotation().angleProperty(), 185)),
                new KeyFrame(Duration.millis(1), new KeyValue(panel3.getLine3Rotation().angleProperty(), 80))
        );
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}