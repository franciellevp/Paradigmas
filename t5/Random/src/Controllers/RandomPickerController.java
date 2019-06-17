package Controllers;

import Models.RandomPickerModel;
import Views.RandomPickerView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
                ArrayList<String> list = model.ShuffleRandom();
                System.out.println("Elementos Embaralhados no random.org");
                PrintListContent(list);
                
                model.ShuffleOff();
                System.out.println("\nElementos Embaralhados Offline");
                PrintListContent(model.getElements());
            }
        } catch (IOException ex) {
            Logger.getLogger(RandomPickerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void PrintListContent(ArrayList<String> list) throws IOException {
        model.setIndex(0);
        String element = "";
        while (element != null) {
            int key = System.in.read();
            if (key == 10) {
                element = model.GetNextElement(list);
                if (element != null) {
                    System.out.print(element);
                }
            }
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
            element = model.GetNextElement(model.getElements());
            if (element != null) {
                text = text.concat(element + "\n");
                view.setLabel(text);
            }
        });
    }
}
