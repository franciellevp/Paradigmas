package enade.enade;

import Controllers.EnadeController;
import Models.EnadeModel;
import Views.EnadeTableView;
import Views.EnadeView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EnadeTableView table = new EnadeTableView();
        EnadeView view = new EnadeView(stage, table);
        view.DrawView();
        EnadeModel model = new EnadeModel();
        EnadeController controller = new EnadeController(model, view, table);
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
