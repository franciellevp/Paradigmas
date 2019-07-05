package Controllers;

import Models.AnalyserModel;
import Views.*;
import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AnalyserController extends AnalyserModel {

    @FXML
    private final AnalyserModel model;
    @FXML
    private final AnalyserView view;
    
    public AnalyserController(AnalyserModel model, AnalyserView view) {
        this.model = model;
        this.view = view;
    }

    @FXML
    public void CloseApp() {
        EventHandler<ActionEvent> event = (ActionEvent event1) -> {
            Platform.exit();
        };
        view.getMenu().getSubMenuExit().setOnAction(event);
    }

    @FXML
    public void OpenAboutWindow() {
        EventHandler<ActionEvent> event = (ActionEvent e) -> {
            String msg = "GitHub Analyser\nFrancielle Vasconcellos Pereira\nCopyright 2019 - Todos os direitos reservados.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
            alert.show();
        };
        view.getMenu().getSubMenuAbout().setOnAction(event);
    }
    
    public void OpenFileChooserWindow() {
        view.getMenu().getsubMenuOpen().setOnAction((ActionEvent) -> {
            File file = model.OpenFileChooser(view.getStage(), view.getFileChooser());
            model.ReadFileContent(file.getName());
        });
    }

    @FXML
    public void ShowSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Operação realizada com sucesso.", ButtonType.OK);
        alert.show();
    }
}
