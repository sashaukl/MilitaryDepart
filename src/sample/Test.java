package sample;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 140, 140));

        Rectangle rect = new Rectangle(1, 1, 40, 40);
        rect.setFill(Color.YELLOW);
        root.getChildren().add(rect);

        rect.setX(50);
        rect.setY(50);

        // comment movePivot to get the default rotation
        movePivot(rect, -20, -20);

        RotateTransition rt = new RotateTransition(Duration.seconds(4), rect);
        rt.setToAngle(360);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(true);
        rt.play();

        primaryStage.show();
    }

    // this is the function you want
    private void movePivot(Node node, double x, double y) {
        node.getTransforms().add(new Translate(-x, -y));
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}