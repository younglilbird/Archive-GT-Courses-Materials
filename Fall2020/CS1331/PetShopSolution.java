import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;


public class PetShopSolution extends Application {

    public class SortHandler implements EventHandler<javafx.event.ActionEvent> {
        private ObservableList<String> invList;

        // Should also mentiont that it is possible to have these fields be global and will remove the need for a constructor
        public SortHandler(ObservableList<String> invList) {
            this.invList = invList;
        }

        public void handle(ActionEvent e) {
            // TODO: Sort the list and put it in the right order
            sort(invList);
        }
    }

    public void start(Stage primaryStage) {
        // Setting up the structure for the initial layout
        VBox infoBox = new VBox();
        HBox btBox = new HBox();
        HBox mainBox = new HBox();

        // ListView to store elements
        ObservableList<String> invList = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(invList);

        // Setting up different buttons
        Button addButton = new Button("ADD");
        Button removeButton = new Button("REMOVE");
        Button sortButton = new Button("SORT");

        // Setting up all the different text fields
        Text nameText = new Text("Name: ");
        Text ageText = new Text("Age: ");
        Text speciesText = new Text("Species: ");

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField speciesField = new TextField();


        // Setting up Event Handlers
        // TODO: Implement add functionality using anonymous inner class
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!isInt((ageField.getText())))
                    return;     // TODO: Not javafx but mention that lambdas are still functions, so they can still use return albeit a void return
                invList.add(String.format("Name: %s, Age: %s, Species: %s", nameField.getText(), ageField.getText(), speciesField.getText()));
            }
        });

        // TODO: Implement remove button using lambda
        removeButton.setOnAction((e -> {
            int selected;
            if ((selected = listView.getSelectionModel().getSelectedIndex()) < 0)   // thought this was a cool way to do things :)
                return;
            invList.remove(selected);
        }));

        // TODO: Implement remove with key using inner class
        sortButton.setOnAction(new SortHandler(invList));

        // Setup elements inside of mainBox
        // TODO: Arrange elements to be in the correct order
        // Feel free to show the students different ways to show the layout
        mainBox.getChildren().addAll(listView, infoBox);
        btBox.getChildren().addAll(addButton, removeButton, sortButton);
        infoBox.getChildren().addAll(nameText, nameField, ageText, ageField, speciesText, speciesField, btBox);

        listView.setMinWidth(500);
        infoBox.setMinWidth(200);
        mainBox.setMinWidth(700);

        // Setting up the scene to display
        Scene sc = new Scene(mainBox);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    private void sort(ObservableList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // Parses the stored Strings to get the Age field from list
                String[] text1 = list.get(j).split("Age: ")[1].split(",");
                String[] text2 = list.get(j + 1).split("Age: ")[1].split(",");

                // Ensures that age retrieved is valid, if not default to 0
                int age1 = isInt(text1[0]) ? Integer.parseInt(text1[0]) : 0;
                int age2 = isInt(text2[0]) ? Integer.parseInt(text2[0]) : 0;

                // Checks if swap is necessary
                if (age2 < age1) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    private boolean isInt(String input) {
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) < '0' || input.charAt(i) > '9')
                return false;
        return input.length() != 0;

        // TODO: I just think that regex is something cool to mention/show lol
//        return input.matches("[0-9]*");

        // TODO: If time/wanted maybe mention that it is not good to control program flow with try catch
//        try {
//            Integer.parseInt(input);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
    }

    public static void main(String[] args) {
        // TODO: Mention that the main method is unnecessary but may be needed if ran from console
        launch(args);
    }
}
