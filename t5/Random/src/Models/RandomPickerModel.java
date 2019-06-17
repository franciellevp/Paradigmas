package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RandomPickerModel {

    private String fileName;
    private ArrayList<String> elements;
    private int index;

    public RandomPickerModel() {
        this.fileName = "";
        this.elements = new ArrayList<>();
        this.index = 0;
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

    public void ShowListContent() {
        elements.forEach((element) -> {
            System.out.println(element);
        });
    }

    public void ShuffleOff() {
        Collections.shuffle(elements);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<String> ShuffleRandom() {
        try {
            String urlstr = "https://www.random.org/lists/?mode=advanced";
            URL url = new URL(urlstr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setDoOutput(true);

            String data = "list=";
            String element = "";
            while (element != null) {
                element = GetNextElement(elements);
                if (element != null) {
                    data = data.concat(element + "%0D%0A");
                }
            }
            data = data.concat("&format=plain&rnd=new");
            System.out.println(data);
            con.getOutputStream().write(data.getBytes("UTF-8")); // Envia dados pela conexão aberta

            // Cria objeto que fará leitura da resposta pela conexão aberta
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            // Lê resposta, linha por linha
            String responseLine;
            int i = 0;
            ArrayList<String> list = new ArrayList<>();
            while ((responseLine = in.readLine()) != null) {
                list.add(responseLine);
            }
            in.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar-se ao Random.org");
            return null;
        }
    }

    public String GetNextElement(ArrayList<String> list) {
        if (index == list.size()) {
            return null;
        }
        String element = list.get(index);
        index++;
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
