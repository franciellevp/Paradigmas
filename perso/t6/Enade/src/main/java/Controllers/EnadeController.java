package Controllers;

import Utils.Constants;
import Models.EnadeModel;
import Models.TableRowEnade;
import Views.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

public class EnadeController extends EnadeModel {

    private final EnadeModel model;
    private final EnadeView view;
    private final EnadeTableView tableView;
    private final ChangeUrlView urlView;

    public EnadeController(EnadeModel model, EnadeView view, EnadeTableView tableView) {
        this.model = model;
        this.view = view;
        this.tableView = tableView;
        this.urlView = new ChangeUrlView();
    }

    public void CloseApp() {
        view.getMenu().getSubMenuExit().setOnAction((ActionEvent event1) -> {
            Platform.exit();
        });
    }

    public void OpenAboutWindow() {
        view.getMenu().getSubMenuAbout().setOnAction((ActionEvent e) -> {
            String msg = "ENADE UFSM Explorer\nFrancielle Vasconcellos Pereira\nCopyright 2019 - Todos os direitos reservados.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
            alert.show();
        });
    }

    @FXML
    public void ReloadTableData() {
        view.getMenu().getSubMenuReload().setOnAction((ActionEvent e) -> {
            model.GetFileCSV();
            try {
                tableView.setTableView(model.GetCSVFileContent());
            } catch (IOException ex) {
                Logger.getLogger(EnadeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    public void ChangeDefaultURL() {
        view.getMenu().getSubMenuSource().setOnAction((ActionEvent e) -> {
            urlView.DrawURLView();
            urlView.getSendButton().setOnAction((ActionEvent) -> {
                GetTextContent();
            });
        });
    }

    @FXML
    public void GetSelectedRow() {
        tableView.getTable().setOnMousePressed((MouseEvent e) -> {
            TableRowEnade rowData = tableView.getTable().getSelectionModel().getSelectedItem();
            EnadeInfoModal modalView = new EnadeInfoModal(view.getStage(), rowData, tableView);
            modalView.DrawModal();
        });
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
