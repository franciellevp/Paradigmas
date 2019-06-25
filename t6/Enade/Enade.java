package random;

import Views.EnadeView;
import Controllers.EnadeController;
import Models.EnadeModel;

import javafx.application.Application;
import javafx.stage.Stage;

public class EnadeGUI extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        EnadeView view = new EnadeView(stage);
        view.DrawView();
        EnadeModel model = new EnadeModel();
        EnadeController controller = new EnadeController(model, view);
        controller.CloseApp();
        controller.OpenAboutWindow();
        controller.ShuffleList();
    }
}
