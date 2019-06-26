package Views;

import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EnadeInfoModal {
    private Stage stage = new Stage();
    
    public EnadeInfoModal(Stage stage) {
        this.stage = stage;
    }
    public void DrawModal() {
        final SwingNode swingNode = new SwingNode();

        createSwingContent(swingNode);

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Swing in JavaFX");
        stage.setScene(new Scene(pane, 250, 150));
        stage.show();
    }
    
    private void createSwingContent(final SwingNode swingNode) {
    }
}
