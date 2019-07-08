package Controllers;

import Models.*;
import Views.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
    @FXML
    private final RepoCommitModel repo;

    public AnalyserController(AnalyserModel model, AnalyserView view, RepoCommitModel repo) {
        this.model = model;
        this.view = view;
        this.repo = repo;
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
            try {
                for (String e : model.getUrls()) {
                    m.setUrlRepo(e);
                    m.setModel(repo);
                    m.GetCommitList();
                }
                ShowCommitsMessagesCount();
            } catch (IOException ex) {
                ShowErrorMessage();
            }
        });
    }

    private String ShowListCommits(String key) {
        String label = "";
        for (CommitModel x : repo.getListCommitsModel(key)) {
            label += "        Data: " + x.getData() + " | " + "Mensagem: " + x.getMessage() + "\n";
        }
        return label;
    }

    public void ShowCommitsMessagesCount() {
        String label = "";
        for (HashMap.Entry<String, ObservableList<CommitModel>> entry : repo.getRepository().entrySet()) {
            String key = entry.getKey();
            label += "Repositório: " + key + "\n";
            label += "   Número de commits: " + repo.GetNumberCommits(key) + "\n";
            label += "   Tamanho médio commits: " + repo.GetCommitMessageSize(key) + "\n";
            label += ShowListCommits(key);
        }
        view.getCommitsLabel().setText(label);
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
