package Views;

import Enade.Constants;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EnadeView {

    private Stage stage = new Stage();
    private final MenuView menu = new MenuView();

    public EnadeView(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public MenuView getMenu() {
        return menu;
    }
    
    public void DrawView() {
        menu.DrawMenu();
        BorderPane.setAlignment(menu.getMenu(), Pos.TOP_CENTER);
        
        BorderPane root = new BorderPane();
        root.setTop(menu.getMenu());
        root.setPrefSize(Constants.WIDTH, Constants.HEIGHT);
        root.setStyle("-fx-padding: 6; -fx-background-color: snow;"); // Set the Style-properties of the BorderPane

        Scene scene = new Scene(root);          // Create the Scene        
        stage.setScene(scene);                  // Add the scene to the Stage
        stage.setTitle("ENADE UFSM Explorer");  // Set the title of the Stage
        stage.show();                           // Display the Stage

    } 
}
