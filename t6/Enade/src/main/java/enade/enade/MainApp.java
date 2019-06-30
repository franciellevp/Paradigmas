package enade.enade;

import Controllers.EnadeController;
import Models.EnadeModel;
import Views.EnadeView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EnadeView view = new EnadeView(stage);
        view.DrawView();
        EnadeModel model = new EnadeModel();
        EnadeController controller = new EnadeController(model, view);
        controller.CloseApp();
        controller.OpenAboutWindow();
        controller.OpenEnadeModal();
        controller.LoadTableView();
        controller.ReloadTableData();
        controller.ChangeDefaultURL();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
