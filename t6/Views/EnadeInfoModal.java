package Views;

import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EnadeInfoModal {

    private Stage stage = new Stage();

    public EnadeInfoModal(Stage stage) {
        this.stage = stage;
    }

    public void DrawModal() {
        try {
            final SwingNode swingNode = new SwingNode();

            StackPane pane = new StackPane();
            pane.getChildren().add(swingNode);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("ENADE");
            stage.setScene(new Scene(pane, 250, 150));
            stage.show();
        } catch (Exception ex) {
            //System.out.println(ex);
            String msg = "Erro ao abrir modal. " + ex;
            Alert alert = new Alert(Alert.AlertType.ERROR, msg, ButtonType.CLOSE);
            alert.show();
        }
    }
}
