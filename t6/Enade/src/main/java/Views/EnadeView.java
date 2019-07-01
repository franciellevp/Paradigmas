package Views;

import Utils.Constants;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EnadeView {

    private Stage stage = new Stage();
    private final MenuView menu = new MenuView();
    private final EnadeTableView table;

    public EnadeView(Stage stage, EnadeTableView table) {
        this.stage = stage;
        this.table = table;
    }

    public Stage getStage() {
        return stage;
    }

    public MenuView getMenu() {
        return menu;
    }
    
    public void DrawView() throws IOException {
        menu.DrawMenu();
        table.DrawTableView();
        BorderPane.setAlignment(menu.getMenu(), Pos.TOP_CENTER);
        BorderPane.setAlignment(table.getTable(), Pos.CENTER);
        
        
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        BorderPane root = new BorderPane();
        root.setTop(menu.getMenu());
        root.setCenter(table.getTable());
        root.setPrefSize(Constants.WIDTH, Constants.HEIGHT);
        root.setStyle("-fx-padding: 6; -fx-background-color: snow;"); // Set the Style-properties of the BorderPane

        Scene scene = new Scene(root);                      // Create the Scene
        scene.getStylesheets().add("/styles/Styles.css");   // Add all the Styles 
        stage.setScene(scene);                              // Add the scene to the Stage
        stage.setTitle("ENADE UFSM Explorer");              // Set the title of the Stage
        stage.show();                                       // Display the Stage
    } 
}
