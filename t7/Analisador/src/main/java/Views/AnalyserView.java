package Views;

import Models.AnalyserModel;
import Utils.Constants;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AnalyserView {

    private Stage stage;
    private final MenuView menu;
    private FileChooser fileChooser;
    private AnalyserModel model;
    
    public AnalyserView(Stage stage, AnalyserModel model) {
        this.stage = stage;
        this.menu = new MenuView();
        this.fileChooser = new FileChooser();
        this.model = model;
    }
    
    public Stage getStage() {
        return stage;
    }

    public MenuView getMenu() {
        return menu;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void DrawView() throws IOException {
        menu.DrawMenu();
        HBox pane = new HBox();
        ListView<String> listView = new ListView<>();
        pane.getChildren().add(listView);
        listView.setItems(model.getElements());
        
        BorderPane.setAlignment(menu.getMenu(), Pos.TOP_CENTER);
        BorderPane root = new BorderPane();
        BorderPane.setAlignment(menu.getMenu(), Pos.TOP_CENTER);
        BorderPane.setAlignment(pane, Pos.CENTER_LEFT);
        root.setTop(menu.getMenu());
        root.setLeft(listView);
        root.setPrefSize(Constants.WIDTH, Constants.HEIGHT);
        root.setStyle("-fx-padding: 6; -fx-background-color: snow;"); // Set the Style-properties of the BorderPane

        Scene scene = new Scene(root);                      // Create the Scene
        scene.getStylesheets().add("/styles/Styles.css");   // Add all the Styles 
        stage.setScene(scene);                              // Add the scene to the Stage
        stage.setTitle("Github Analyser");                  // Set the title of the Stage
        stage.show();                                       // Display the Stage
    }
}
