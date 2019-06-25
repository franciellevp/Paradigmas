package Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EnadeView {

    TextArea textArea = new TextArea();
    final Menu menuFile = new Menu("File");
    final Menu menuHelp = new Menu("Help");
    final MenuBar menuBar = new MenuBar();
    final MenuItem subMenuReload = new MenuItem("Reload");
    final MenuItem subMenuSource = new MenuItem("Source");
    final MenuItem subMenuExit = new MenuItem("Exit");
    final MenuItem subMenuAbout = new MenuItem("About");
    private Stage stage = new Stage();

    public EnadeView(Stage stage) {
        this.stage = stage;
    }

    public MenuItem getSubMenuExit() {
        return subMenuExit;
    }
	
    public MenuItem getSubMenuAbout() {
        return subMenuAbout;
    }
    
    public void DrawView() {
        menuBar.getMenus().addAll(menuFile, menuHelp); // desenha a barra de menu
        menuFile.getItems().addAll(subMenuReload, subMenuSource, subMenuExit); // add subMenu no menu File
        menuHelp.getItems().add(subMenuAbout);

        textArea.setPrefWidth((double) 400); // set TextArea Height
        menuBar.setStyle("-fx-background-color: #4682B4; -fx-color: red;");
        HBox pane = new HBox();
        pane.getChildren().add(btnShuffle);
        pane.getChildren().add(btnRandom);
    
        BorderPane.setAlignment(menuBar, Pos.TOP_CENTER);
        BorderPane.setAlignment(textArea, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(pane, Pos.CENTER_LEFT);
        BorderPane.setAlignment(btnNext, Pos.CENTER_RIGHT);
        
        BorderPane root = new BorderPane(label, menuBar, btnNext, textArea, pane);
        root.setPrefSize(800, 600);        // width e height da VBox
        root.setStyle("-fx-padding: 6; -fx-background-color: snow;"); // Set the Style-properties of the BorderPane

        Scene scene = new Scene(root);   // Create the Scene        
        stage.setScene(scene);           // Add the scene to the Stage        
        stage.setTitle("Random Picker"); // Set the title of the Stage
        stage.show();                    // Display the Stage

    } 
}
