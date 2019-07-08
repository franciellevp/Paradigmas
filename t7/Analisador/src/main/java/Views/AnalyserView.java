package Views;

import Models.*;
import Utils.Constants;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    private RepoCommitModel repoModel;
    private Label listCommits;
    private Label commitsLabel;

    public AnalyserView(Stage stage, AnalyserModel model, RepoCommitModel repoModel) {
        this.stage = stage;
        this.menu = new MenuView();
        this.fileChooser = new FileChooser();
        this.model = model;
        this.repoModel = repoModel;
        this.listCommits = new Label();
        this.commitsLabel = new Label();
    }

    public Label getCommitsLabel() {
        return commitsLabel;
    }

    public void setCommitsLabel(Label commitsLabel) {
        this.commitsLabel = commitsLabel;
    }

    public Stage getStage() {
        return stage;
    }

    public MenuView getMenu() {
        return menu;
    }

    public Label getListCommits() {
        return listCommits;
    }

    public void setListCommits(Label listCommits) {
        this.listCommits = listCommits;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void DrawView() throws IOException {
        menu.DrawMenu();

        HBox paneUrl = new HBox();
        ListView<String> listUrl = new ListView<>();
        paneUrl.getChildren().add(listUrl);
        listUrl.setItems(model.getUrls());

        HBox paneCommits = new HBox();
        paneUrl.getChildren().add(commitsLabel);

        HBox mainPane = new HBox();
        mainPane.getChildren().addAll(paneUrl, paneCommits);

        BorderPane.setAlignment(menu.getMenu(), Pos.TOP_CENTER);
        BorderPane root = new BorderPane();
        BorderPane.setAlignment(menu.getMenu(), Pos.TOP_CENTER);
        BorderPane.setAlignment(paneUrl, Pos.CENTER_LEFT);
        BorderPane.setAlignment(paneCommits, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(mainPane, Pos.CENTER);
        root.setTop(menu.getMenu());
        root.setLeft(paneUrl);
        root.setRight(paneCommits);
        root.setPrefSize(Constants.WIDTH, Constants.HEIGHT);
        root.setStyle("-fx-padding: 6; -fx-background-color: snow;"); // Set the Style-properties of the BorderPane

        Scene scene = new Scene(root);                      // Create the Scene
        scene.getStylesheets().add("/styles/Styles.css");   // Add all the Styles 
        stage.setScene(scene);                              // Add the scene to the Stage
        stage.setTitle("Github Analyser");                  // Set the title of the Stage
        stage.show();                                       // Display the Stage
    }
}
