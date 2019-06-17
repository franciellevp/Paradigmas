package random;

import Views.RandomPickerView;
import Controllers.RandomPickerController;
import Models.RandomPickerModel;

import javafx.application.Application;
import javafx.stage.Stage;

public class RandomPickerGUI extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        RandomPickerView view = new RandomPickerView(stage);
        view.DrawView();
        RandomPickerModel model = new RandomPickerModel();
        RandomPickerController controller = new RandomPickerController(model, view);
        controller.CloseApp();
        controller.OpenAboutWindow();
        controller.OpenFileChooserWindow();
        controller.ShuffleList();
        controller.ShowListElementsLabel();
    }
}
