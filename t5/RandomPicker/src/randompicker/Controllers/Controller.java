package randompicker.Controllers;

import randompicker.Models.Model;
import randompicker.Views.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private final Model model;
    private final RandomPickerView view;
    private ActionListener actionListener;

    public Controller(Model model, RandomPickerView view) {
        this.model = model;
        this.view = view;
    }

    public void AppCmd() {
        model.ReadFileContent(model.getFileName());
        model.ShowFileContent();
        model.ShuffleOff();
        model.ShowFileContent();        
        try {
            String element = "";
            while (element != null) {
                int key = System.in.read();
                if (key == 10) {
                    element = model.GetNextElement();
                    if(element != null)
                        System.out.print(element);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public void CloseApp() {
        view.getSubMenuExit().setOnAction((WindowEvent) -> {
            System.exit(0);
        });
    }
    
    public void OpenFileChooserWindow() {
        view.getSubMenuOpen().setOnAction((javafx.event.ActionEvent ActionEvent) -> {
            //File file = model.openFileChooser(stage, fileChooser);
            //elements = model.readFileContent(file.getName(), textArea);
        });
    }
    
    public void OpenAboutWindow() {
        view.getSubMenuAbout().setOnAction((ActionEvent) -> {
            AboutView model = new AboutView();
            model.ShowAboutScreen(view.getAboutText());
        });
    }*/
}
