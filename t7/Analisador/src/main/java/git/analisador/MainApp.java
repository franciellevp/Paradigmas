package git.analisador;

import Controllers.AnalyserController;
import Models.AnalyserModel;
import Views.AnalyserView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnalyserModel model = new AnalyserModel();
        AnalyserView view = new AnalyserView(stage, model);
        view.DrawView();
        AnalyserController controller = new AnalyserController(model, view);
        controller.CloseApp();
        controller.OpenAboutWindow();
        controller.OpenFileChooserWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
