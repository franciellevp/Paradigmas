package Models;

import Enade.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EnadeModel {

    private String fileName;
    private ArrayList<String> elements;

    public boolean CheckFileExist(File file) {
        return file.exists() && !file.isDirectory();
    }

    public void GetFileCSV() {
        try {
            ReadableByteChannel readChannel = Channels.newChannel(new URL(Constants.URL_CC).openStream());
            String path = Constants.FILEPATH;
            FileOutputStream fileOS = new FileOutputStream(path);  
            FileChannel writeChannel = fileOS.getChannel();
            writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao realizar download do arquivo CSV. " + ex, ButtonType.OK);
            alert.show();
        }
    }

//    public static void readAllDataAtOnce(String file) { 
//        try { 
//            FileReader filereader = new FileReader(file); 
//  
//            TableRowEnade csvReader = new CSVReaderBuilder(filereader) 
//                                      .withSkipLines(1) 
//                                      .build(); 
//            ArrayList<String[]> allData = csvReader.readAll(); 
//  
//            // print Data
//            allData.stream().map((row) -> {
//                for (String cell : row) {
//                    System.out.print(cell + "\t");
//                }
//                return row;
//            }).forEachOrdered((_item) -> { 
//                System.out.println();
//            });
//        } 
//        catch (FileNotFoundException ex) {
//            System.out.println(ex);
//        } 
//    } 
}
