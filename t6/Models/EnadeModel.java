package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class EnadeModel {
    
    private String fileName;
    private ArrayList<String> elements;
    
    public void ReadFileContent(String fileName) throws FileNotFoundException, IOException {
        String path = (new File(fileName)).getAbsolutePath().replace(fileName, "");
        path += "src/Enade/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            elements.add(line);
        }
        br.close();
    }
}
