package Models;

import Utils.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AnalyserModel {
    private String fileName;
    private ObservableList<String> elements;
    private int index;

    public AnalyserModel(String fileName, ObservableList<String> elements, int index) {
        this.fileName = fileName;
        this.elements = elements;
        this.index = index;
    }

    public AnalyserModel() {
        this.index = 0;
        this.elements = FXCollections.observableArrayList();
        this.fileName = "";
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ObservableList<String> getElements() {
        return elements;
    }

    public void setElements(ObservableList<String> elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void ReadFileContent(String fileName) {
        try {
            String path = Constants.FILEPATH + Constants.FILENAME;
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                elements.add(line);
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo " + fileName);
        }
    }
    
    public File OpenFileChooser(Stage stage, FileChooser fileChooser) {
        try {
            fileChooser.setTitle("Abrir Arquivo");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter); // permite abrir apenas arquivos txt
            File file = fileChooser.showOpenDialog(stage);
            return file;
        } catch (Exception ex) {
            System.out.println("Erro ao abrir o arquivo");
            return null;
        }
    }
}
