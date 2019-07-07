package Controllers;

import Models.*;
import Views.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void AnalyzeCommit() {
        view.getMenu().getMenuTools().setOnAction((ActionEvent) -> {
            ApiGsonModel m = new ApiGsonModel();
            RepoCommitModel repo = new RepoCommitModel();
            try {
                for (String e : model.getElements()) {
                    m.GetCommitList(e, repo);
                }
                System.out.println("----COMMITs---");
                if (repo.getRepository() != null) {
                    for (HashMap.Entry<String, ArrayList<CommitModel>> entry : repo.getRepository().entrySet()) {
                        String key = entry.getKey();
                        ArrayList<CommitModel> value = entry.getValue();
                        for (CommitModel commit : value) {
                            System.out.println("DATA: " + commit.getData() + " | " + "MSG: " + commit.getMessage());
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(AnalyserController.class.getName()).log(Level.SEVERE, null, ex);
                ShowErrorMessage();
            }
        });
    }

    @FXML
    public void ShowSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Operação realizada com sucesso", ButtonType.OK);
        alert.show();
    }

    public void ShowErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao realizar operação", ButtonType.OK);
        alert.show();
    }
}
