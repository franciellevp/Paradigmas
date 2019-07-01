package Controllers;

import Utils.Constants;
import Models.EnadeModel;
import Views.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EnadeController extends EnadeModel {

    @FXML
    private final EnadeModel model;
    @FXML
    private final EnadeView view;
    private final EnadeTableView tableView;
    private final ChangeUrlView urlView = new ChangeUrlView();

    public EnadeController(EnadeModel model, EnadeView view, EnadeTableView tableView) {
        this.model = model;
        this.view = view;
        this.tableView = tableView;
    }

    @FXML
    public void CloseApp() {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        };
        view.getMenu().getSubMenuExit().setOnAction(event);
    }

    @FXML
    public void OpenAboutWindow() {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String msg = "ENADE UFSM Explorer\nFrancielle Vasconcellos Pereira\nCopyright 2019 - Todos os direitos reservados.";
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
                alert.show();
            }
        };
        view.getMenu().getSubMenuAbout().setOnAction(event);
    }

    @FXML
    public void OpenEnadeModal() {

    }

    @FXML
    public void ReloadTableData() {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                model.GetFileCSV();
                try {
                    tableView.setTableView(model.GetCSVFileContent());
                } catch (IOException ex) {
                    Logger.getLogger(EnadeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        view.getMenu().getSubMenuReload().setOnAction(event);
    }

    @FXML
    public void ChangeDefaultURL() {
        final EventHandler<ActionEvent> newUrlEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GetTextContent();
            }
        };

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                urlView.DrawURLView();
                urlView.getSendButton().setOnAction(newUrlEvent);
            }
        };
        view.getMenu().getSubMenuSource().setOnAction(event);
    }

    @FXML
    public void ShowSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Operação realizada com sucesso.", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void LoadTableView() throws IOException {
        File file = new File(Constants.FILEPATH);
        if (model.CheckFileExist(file)) {
            tableView.setTableView(model.GetCSVFileContent());
            tableView.LoadTableView();
        } else {
            model.GetFileCSV();
        }
    }

    public void GetTextContent() {
        String str = urlView.getNewURL().getText();
        if (str.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Por favor, insira uma URL", ButtonType.OK);
            alert.show();
        } else {
            model.setUrlCC(str);
            ShowSuccessMessage();
        }
    }
}
