package sample;

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
    private Lighting lighting = new Lighting();

    protected Panel1 panel1;
    protected Panel2 panel2;
    protected Panel3 panel3;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        // Create lighting effect
        lighting.setLight(light);
        lighting.setSurfaceScale(4.0);

        this.primaryStage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));

        primaryStage.setTitle("САЭС");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();

        Button bt = (Button) root.lookup("#mode1");
        bt.setOnMouseClicked(e -> {
            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setMaximized(false);
                primaryStage.setMaximized(true);
                primaryStage.show();

                panel1 = new Panel1();
                panel2 = new Panel2();
                panel3 = new Panel3();

                panel1.getGrayButtons().get(4).setOnAction(ev1 ->{
                    if (!panel1.getActiveButtons().contains(panel1.getGrayButtons().get(4)))
                    {
                        panel1.lightOn(panel1.getGreenLights().get(6));
                        panel1.addActive(panel1.getGreenLights().get(6));
                        panel1.lightOn(panel1.getRedLights().get(4));
                        panel1.addActive(panel1.getRedLights().get(4));
                        panel1.getActiveButtons().add(panel1.getGrayButtons().get(4));
                        panel3.lightOn(panel3.getYellowLight());
                        //panel3.lightOn(panel3.getRedLights().get(0));
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
                    }
                });

                //откл нагр
                panel1.getRedButtons().get(1).setOnAction(offPower -> {
                    if (!panel1.getActive().contains(panel1.getRedLights().get(4)) && panel1.getActiveButtons().contains(panel1.getGrayButtons().get(4))){
                        panel1.getActiveButtons().remove(panel1.getGrayButtons().get(4));
                        panel1.removeActive(panel1.getGreenLights().get(6));
                        panel1.lightOff(panel1.getGreenLights().get(6));
                        panel1.getActiveButtons().add(panel1.getRedButtons().get(1));
                        Timeline timeline = new Timeline(
                                new KeyFrame(Duration.millis(4000), new KeyValue(panel3.getLine3Rotation().angleProperty(), 0)));
                        timeline.play();
                        panel3.lightOff(panel3.yellowLight);
                    }
                    else{
                        System.out.println("отключить нагревание ошибка");
                    }
                });

                //откл гап
                panel1.getRedButtons().get(0).setOnAction(stopGap -> {
                    if (panel1.getActiveButtons().contains(panel1.getRedButtons().get(1))){
                        panel1.getActiveButtons().remove(panel1.getRedButtons().get(1));
                        panel1.getActiveButtons().add(panel1.getRedButtons().get(0));
                        panel1.lightOff(panel1.getYellowLight());
                        panel1.lightOff(panel1.getGreenLights().get(3));
                        Timeline timeline = new Timeline(
                                new KeyFrame(Duration.millis(6000), new KeyValue(panel1.getLine1Rotation().angleProperty(), 0)),
                                new KeyFrame(Duration.millis(6000), new KeyValue(panel1.getLine2Rotation().angleProperty(), 0)),
                                new KeyFrame(Duration.millis(6000), new KeyValue(panel1.getLine3Rotation().angleProperty(), 0)));
                        timeline.play();
                    }
                    else {
                        System.out.println("Stop gap mistake");
                    }
                });

            }
            catch (Exception ee){}
        });
    }

         //откл нагр


    public static void main(String[] args) {
        launch(args);
    }
}