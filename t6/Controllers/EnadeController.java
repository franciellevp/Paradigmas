package Controllers;

import Models.EnadeModel;
import Views.EnadeView;
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

    public void ShowSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Operação realizada com sucesso.", ButtonType.OK);
        alert.show();
    }
}
