package Controllers;

import Models.EnadeModel;
import Views.EnadeView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EnadeController extends RandomPickerModel{

    private final EnadeModel model;
    private final EnadeView view;

    public EnadeController(RandomPickerModel model, RandomPickerView view) {
        this.model = model;
        this.view = view;
    }

    public void CloseApp() {
        view.getSubMenuExit().setOnAction((WindowEvent) -> { // abre janela para escolha de arquivo
            System.exit(0);
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
}
