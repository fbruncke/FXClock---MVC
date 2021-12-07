import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class WatchSettings {

    public void showUI(WatchData wd)
    {
        Stage stage = new Stage();

        Pane pane = new Pane();
        Scene scene = new Scene(pane,500,500);

        Label lbName = new Label("Watch time");
        lbName.setLayoutX(10);
        lbName.setLayoutY(50);

        TextField tfName = new TextField();
        tfName.setLayoutX(100);
        tfName.setLayoutY(50);
        tfName.setText(Double.toString(wd.getMin()));

        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(tfName.textProperty(), wd.minProperty(), converter);


        pane.getChildren().addAll(lbName,tfName);

        stage.setTitle("Show watch min");
        stage.setScene(scene);
        stage.show();
    }
}
