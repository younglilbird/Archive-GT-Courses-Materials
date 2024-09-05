//I worked on the exam alone, using only course materials.
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;

public class Exam4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("1331 Exam 5 - Yulong Liang");
        VBox vbox = new VBox(30);
        Text t = new Text("Exam4");
        vbox.setPadding(new Insets(15,15,15,15));
        vbox.getChildren().add(t);
        Button btn = new Button("Color Me");
        Rectangle rec = new Rectangle(30, 30);
        rec.setFill(Color.BLACK);
        btn.setOnAction(new EventHandler <ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	        	if (rec.getFill() == Color.BLACK) {
	        		rec.setFill(Color.BLUE);
	        	} else {
	        		rec.setFill(Color.BLACK);
	        	}
	        }
        });
        StackPane sp = new StackPane();
        sp.getChildren().add(rec);
        ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Left");
        RadioButton rb2 = new RadioButton("Center");
        RadioButton rb3 = new RadioButton("Right");
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        VBox vb2 = new VBox(10);
        vb2.getChildren().addAll(rb1, rb2, rb3);
        vb2.setAlignment(Pos.CENTER);
        vb2.setOnMouseClicked(e -> {
        	if (rb1.isSelected()) {
        		sp.setAlignment(Pos.CENTER_LEFT);
        	} else if (rb2.isSelected()) {
        		sp.setAlignment(Pos.CENTER);
        	} else if (rb3.isSelected()) {
        		sp.setAlignment(Pos.CENTER_RIGHT);
        	}
        });

        Spinner spi = new Spinner(0.1, 2.0, 1.0, 0.1);
        spi.setOnMouseClicked(e -> {
        	double x = Double.valueOf(spi.getValue().toString());
        	double y = Double.valueOf(spi.getValue().toString());
        	rec.setScaleX(x);
        	rec.setScaleY(y);
        });

        vbox.getChildren().add(btn);
        vbox.getChildren().add(sp);
        vbox.getChildren().add(vb2);
        vbox.getChildren().add(spi);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}