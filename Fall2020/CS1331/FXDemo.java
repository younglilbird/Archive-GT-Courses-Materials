import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class FXDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Welcome to JavaFX");

        HBox hbox = new HBox();
        hbox.getChildren().add(label);
        hbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
