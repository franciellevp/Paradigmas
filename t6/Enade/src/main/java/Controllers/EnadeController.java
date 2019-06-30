package Controllers;

import Utils.Constants;
import Models.EnadeModel;
import Views.EnadeTableView;
import Views.EnadeView;
import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class EnadeController extends EnadeModel {

    @FXML
    private final EnadeModel model;
    @FXML
    private final EnadeView view;

    public EnadeController(EnadeModel model, EnadeView view) {
        this.model = model;
        this.view = view;
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
                EnadeModel modal = new EnadeModel();
                modal.ReadCSVFile();
            }
        };
        view.getMenu().getSubMenuReload().setOnAction(event);
    }

    @FXML
    public void ChangeDefaultURL() {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("muda url");
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
    public void LoadTableView() {
        File file = new File(Constants.FILEPATH);
        if (model.CheckFileExist(file)) {
            EnadeTableView tableView = new EnadeTableView();
            model.ReadCSVFile();
            tableView.LoadTableView();
        } else {
            System.out.println("Abaixa aqui");
            model.GetFileCSV();
        }
    }
}
