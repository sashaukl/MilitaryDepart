package sample;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application  {
    //private Circle redLight4;
    @FXML
    VBox startBox;
    @FXML
    private Menu menu1;
    @FXML
    private Menu menu2;
    public static Main main;
    public static Stage primaryStage;
    public static Parent root;
    public static Scene scene = null;
    public static boolean activatePanel = false;
    private Lighting lighting = new Lighting();
    public static boolean learnMode = true;
    protected Panel1 panel1;
    protected Panel2 panel2;
    protected Panel3 panel3;
    public static boolean activationMode = true;

    private static int mark = 5;
    public static boolean fazeCheck = false;

    public static void ShowMark(){
        SplitPane splitbox = (SplitPane) root.lookup("#splitBox");
        AnchorPane commonBox = (AnchorPane) root.lookup("#commonBox");
        Text text = new Text();
        FlowPane fp = new FlowPane();
        fp.setAlignment(Pos.CENTER);
        text.setFont(Font.font(30));
        switch (mark){
            case 2:
                fp.setStyle("-fx-background-color: rgba(196,8,0,0.79)");
                break;
            case 4:
            case 5:
                fp.setStyle("-fx-background-color: GREEN");
                break;
            default:
                fp.setStyle("-fx-background-color: #ffb836");
                break;
        }
        fp.getChildren().add(text);
        commonBox.setTopAnchor(fp, 30.0);
        commonBox.setLeftAnchor(fp, 0.0);
        commonBox.setRightAnchor(fp, 0.0);
        commonBox.setBottomAnchor(fp, 0.0);
        if (!learnMode) {
            text.setText("Ваша оценка: " + mark);
        } else {
            text.setText("Упражнение успешно пройдено");
        }
        commonBox.getChildren().remove(splitbox);
        commonBox.getChildren().add(fp);
    }

    public static void decreaseMark(){
        if (!learnMode)
            mark--;
        if (mark <= 2) {
            ShowMark();
        }
        System.out.println(mark);
    }

    public static HintMode hint;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScene.fxml"));
            root = loader.load();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.setTitle("Тренажер системы автономного электроснабжения изделя МСНР-9С32");
            primaryStage.show();
            System.out.println();
            VBox startBox = (VBox)root.lookup("#startBox");
            startBox.prefHeightProperty().bind(scene.heightProperty().divide(5));
            startBox.prefWidthProperty().bind(scene.widthProperty().divide(3.5));
        }catch (Exception c){ System.out.println("exception"); }
    }

    private void startPanel(){
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        // Create lighting effect
        lighting.setLight(light);
        lighting.setSurfaceScale(4.0);

        //root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        try {
            primaryStage.setTitle("Тренажер системы автономного электроснабжения изделя МСНР-9С32");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            root = loader.load();
            main = loader.getController();
            //root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            if (scene!=null) {
                scene = new Scene(root, scene.getWidth(), scene.getHeight());
            }else{
                scene = new Scene(root);
            }
            primaryStage.setScene(scene);
            //primaryStage.setMaximized(false);
            primaryStage.setMaximized(true);
            primaryStage.show();
            panel1 = new Panel1();
            panel2 = new Panel2();
            panel3 = new Panel3();

            Panel1.hint.setVisible(learnMode);
            hint = new HintMode(activationMode);
            hint.getHint(null);

            panel1.getGrayButtons().get(4).setOnAction(ev1 -> {
                if (!panel1.getActiveButtons().contains(panel1.getGrayButtons().get(4)) && activatePanel) {
                    if (!fazeCheck)
                        decreaseMark();
                    panel1.lightOn(panel1.getGreenLights().get(6));
                    panel1.addActive(panel1.getGreenLights().get(6));
                    panel1.lightOn(panel1.getRedLights().get(4));
                    panel1.addActive(panel1.getRedLights().get(4));
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(4));
                    panel3.lightOn(panel3.getYellowLight());
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.millis(4000), new KeyValue(panel3.getLine3Rotation().angleProperty(), 80)),
                            new KeyFrame(Duration.millis(4000), new KeyValue(panel1.getLine2Rotation().angleProperty(), 178)),
                            new KeyFrame(Duration.millis(10000), event2 -> {
                                panel1.removeActive(panel1.getRedLights().get(4));
                                panel1.lightOff(panel1.getRedLights().get(4));
                                panel3.lightOff(panel3.getRedLights().get(0));
                            }),
                            new KeyFrame(Duration.millis(10100), event2 -> ShowMark()));
                    timeline.play();
                    panel1.getActiveButtons().add(panel1.getGrayButtons().get(4));
                    hint.getHint(panel1.getGrayButtons().get(4));
                } else {
                    decreaseMark();
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
                    System.out.println( panel1.getActiveButtons().contains(panel1.getRedButtons().get(1)) ? "true1":"false1");
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
        mark = 5;
        activationMode = true;
        startPanel();
        main.menu1.setText(menu1.getItems().get(0).getText());
        if (!learnMode){
            main.menu2.setText(menu2.getItems().get(1).getText());
            mark = 5;
        }
    }

    public void TurnOffPower(){
        activationMode = false;
        startPanel();
        main.menu1.setText(menu1.getItems().get(1).getText());
        if (!learnMode){
            main.menu2.setText(menu2.getItems().get(1).getText());
            mark = 5;
        }
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



    @FXML
    private void onEnterClicked(){
        activationMode = true;
        startPanel();
    }
    @FXML
    private void onExitClicked(){
        System.exit(0);
    }

    public void setLearnModeTrue(){
        learnMode = true;
        if (activationMode) {
            TurnOnPower();
        }
        else {
            TurnOffPower();
        }
        main.menu2.setText(menu2.getItems().get(0).getText());
    }

    public void setLearnModeFalse(){
        learnMode = false;
        if (activationMode) {
            TurnOnPower();
        }
        else {
            TurnOffPower();
        }
        main.menu2.setText(menu2.getItems().get(1).getText());
        //menu2.styleProperty().bind(Bindings.concat("-fx-font-size: ", 30, ";"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}