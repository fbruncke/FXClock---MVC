import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        Pane pane = new Pane();

        Scene scene = new Scene(pane, 500, 500);
        Circle ball = new Circle(200, Color.RED);
        ball.relocate(50,50 );
        pane.getChildren().add(ball);

        //Rectangle rectangle  = new Rectangle(100,   100, Color.GREEN);
        //rectangle.relocate(50,50);
        //pane.getChildren().add(rectangle);

        Line line = new Line(250,250,250,85);
        line.setStrokeWidth(8);
        line.setStroke(Color.BLUE);
        pane.getChildren().add(line);

        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(line.startXProperty());
        rotation.pivotYProperty().bind(line.startYProperty());
        //rotation.setPivotX(line.getStartX());
        //rotation.setPivotY(line.getStartY());
        line.getTransforms().add(rotation);

        Slider slAngle = new Slider(0,360,0);
        slAngle.setLayoutX(10);
        slAngle.setLayoutY(10);
        pane.getChildren().add(slAngle);
        rotation.angleProperty().bind(slAngle.valueProperty());

        Line lineMin = new Line(250,250,250,65);
        lineMin.setStrokeWidth(4);
        lineMin.setStroke(Color.LIGHTBLUE);
        pane.getChildren().add(lineMin);

        Rotate rotationMin = new Rotate();
        //rotation.pivotXProperty().bind(line.startXProperty());
        //rotation.pivotYProperty().bind(line.startYProperty());
        rotationMin.setPivotX(lineMin.getStartX());
        rotationMin.setPivotY(lineMin.getStartY());
        lineMin.getTransforms().add(rotationMin);

        //Slider slAngleMin = new Slider(0,360,0);
        //slAngleMin.setLayoutX(10);
        //slAngleMin.setLayoutY(30);
        //pane.getChildren().add(slAngleMin);
        //rotationMin.angleProperty().bind(slAngleMin.valueProperty());

        WatchData wd = new WatchData();

        rotationMin.angleProperty().bind( Bindings.multiply( wd.minProperty(), 6));

        wd.setMin(45);

        WatchSettings ws = new WatchSettings();
        ws.showUI(wd);

/*
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotationMin.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(rotationMin.angleProperty(), 360)));
        timeline.setAutoReverse(false);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
*/

        //Button btnRotate = new Button("Rotate Min.");
        //btnRotate.setOnAction(evt -> timeline.play());
        //btnRotate.disableProperty().bind(timeline.statusProperty().isEqualTo(Animation.Status.RUNNING));
        //btnRotate.setLayoutX(200);
        //btnRotate.setLayoutY(10);
        //pane.getChildren().add(btnRotate);

        primaryStage.setTitle("The clock");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
