package Controllers;

import Enade.Constants;
import Models.EnadeModel;
import Views.EnadeInfoModal;
import Views.EnadeTableView;
import Views.EnadeView;
import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EnadeController extends EnadeModel{

    private final EnadeModel model;
    private final EnadeView view;

    public EnadeController(EnadeModel model, EnadeView view) {
        this.model = model;
        this.view = view;
    }

    public void CloseApp() {
        view.getMenu().getSubMenuExit().setOnAction((WindowEvent) -> { // abre janela para escolha de arquivo
            System.exit(0);
        });
    }

    public void OpenAboutWindow() {
        view.getMenu().getSubMenuAbout().setOnAction((ActionEvent) -> {
            String msg = "ENADE UFSM Explorer\nFrancielle Vasconcellos Pereira\nCopyright 2019 - Todos os direitos reservados.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
            alert.show();
        });
    }
    
    public void OpenEnadeModal() {
        view.getMenu().getSubMenuReload().setOnAction((ActionEvent) -> {
            EnadeInfoModal modal = new EnadeInfoModal(view.getStage());
            modal.DrawModal();
        });
    }

    public void ShowSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Operação realizada com sucesso.", ButtonType.OK);
        alert.show();
    }
    
    public void LoadTableView() {
        File file = new File(Constants.FILEPATH);
        if(model.CheckFileExist(file)) {
            EnadeTableView tableView = new EnadeTableView();
            tableView.LoadTableView();
        } else {
            System.out.println("Abaixa aqui");
            model.GetFileCSV();
        }
    }
}
