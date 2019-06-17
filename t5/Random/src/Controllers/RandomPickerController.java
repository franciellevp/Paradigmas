package Controllers;

import Models.RandomPickerModel;
import Views.RandomPickerView;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class RandomPickerController {

    private final RandomPickerModel model;
    private final RandomPickerView view;
    private String text;

    public RandomPickerController(RandomPickerModel model, RandomPickerView view) {
        this.model = model;
        this.view = view;
        this.text = "";
    }

    public void AppCmd() {
        try {
            model.ReadFileContent(model.getFileName());
            if (model.getElements().size() > 0) {
                model.ShowFileContent();
                model.ShuffleOff();
                model.ShowFileContent();

                String element = "";
                while (element != null) {
                    int key = System.in.read();
                    if (key == 10) {
                        element = model.GetNextElement();
                        if (element != null) {
                            System.out.print(element);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(RandomPickerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CloseApp() {
        view.getSubMenuExit().setOnAction((WindowEvent) -> { // abre janela para escolha de arquivo
            System.exit(0);
        });
    }

    public void OpenFileChooserWindow() {
        view.getSubMenuOpen().setOnAction((javafx.event.ActionEvent ActionEvent) -> {
            File file = model.OpenFileChooser(view.getStage(), view.getFileChooser());
            model.ReadFileContent(file.getName());
            model.FillTextArea(view.getTextArea());
        });
    }

    public void OpenAboutWindow() {
        view.getSubMenuAbout().setOnAction((ActionEvent) -> {
            String msg = "Random Picker\nFrancielle Vasconcellos Pereira\nCopyright 2019 - Todos os direitos reservados.";
            Alert a = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
            a.show();
        });
    }

    public void ShowSuccessMessage() {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Operação realizada com sucesso.", ButtonType.OK);
        a.show();
    }

    public void ShuffleList() {
        view.getBtnShuffle().setOnAction((ActionEvent) -> {
            model.ShuffleOff();
            this.ShowSuccessMessage();
        });
    }

    public void ShowListElementsLabel() {
        view.getBtnNext().setOnAction((ActionEvent) -> {
            String element = "";
            element = model.GetNextElement();
            if (element != null) {
                text = text.concat(element + "\n");
                view.setLabel(text);
            }
        });
    }
}
