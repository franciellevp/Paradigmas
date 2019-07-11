package Views;

import Utils.Constants;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChangeUrlView {

    private final Button sendButton = new Button("Enviar");
    private final TextField newURL = new TextField();

    public Button getSendButton() {
        return sendButton;
    }

    public TextField getNewURL() {
        return newURL;
    }

    public void DrawURLView() {
        Stage stage = new Stage();

        newURL.setPrefColumnCount(20);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().add(new Label("Digite a nova URL: "));
        hBox.getChildren().add(newURL);
        hBox.getChildren().add(sendButton);

        StringProperty title = new SimpleStringProperty();
        Scene scene = new Scene(hBox, Constants.URL_VIEW_WIDTH, Constants.URL_VIEW_HEIGHT);
        title.bind(newURL.textProperty());

        stage.setScene(scene);
        stage.setTitle("Alterar URL ENADE");
        stage.show();
    }
}
