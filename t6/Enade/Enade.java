package Enade;

import Views.EnadeView;
import Controllers.EnadeController;
import Models.EnadeModel;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Enade extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        EnadeView view = new EnadeView(stage);
        view.DrawView();
        EnadeModel model = new EnadeModel();
        EnadeController controller = new EnadeController(model, view);
        controller.CloseApp();
        controller.OpenAboutWindow();
        controller.OpenEnadeModal();
    }
}
