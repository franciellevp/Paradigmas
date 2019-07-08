package git.analisador;

import Controllers.AnalyserController;
import Models.*;
import Views.AnalyserView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnalyserModel model = new AnalyserModel();
        RepoCommitModel repo = new RepoCommitModel();
        AnalyserView view = new AnalyserView(stage, model, repo);
        view.DrawView();
        AnalyserController controller = new AnalyserController(model, view, repo);
        controller.CloseApp();
        controller.OpenAboutWindow();
        controller.OpenFileChooserWindow();
        controller.AnalyzeCommit();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
