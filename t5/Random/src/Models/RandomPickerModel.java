package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RandomPickerModel {
    private String fileName;
    private ArrayList<String> elements;

    public RandomPickerModel() {
        this.fileName = "";
        this.elements = new ArrayList<>();
    }

    public RandomPickerModel(String fileName) {
        this.fileName = fileName;
        this.elements = new ArrayList<>();
    }

    public RandomPickerModel(String fileName, ArrayList<String> elements) {
        this.fileName = fileName;
        this.elements = elements;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String file) {
        this.fileName = file;
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public void ReadFileContent(String fileName) {
        try {
            String path = (new File(fileName)).getAbsolutePath().replace(fileName, "");
            path += "src/random/" + fileName;

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                elements.add(line);
            }
            br.close();
        } catch (IOException ex) {
            //Logger.getLogger(fileName).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao abrir o arquivo " + fileName);
        }
    }

    public void ShowFileContent() {
        elements.forEach((element) -> {
            System.out.println(element);
        });
    }

    public void ShuffleOff() {
        Collections.shuffle(elements);
    }

    public String GetNextElement() {
        if (elements.isEmpty()) {
            return null;
        }
        String element = elements.remove(0);
        return element;
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
    
    public void FillTextArea(TextArea textArea) {
        elements.forEach((element) -> {
            textArea.appendText(element + "\n");
        });
    }
}
