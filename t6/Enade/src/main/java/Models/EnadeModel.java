package Models;

import Utils.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EnadeModel {

    public EnadeModel(String urlCC) {
        this.urlCC = urlCC;
    }

    public EnadeModel() {
        this.urlCC = Constants.DEFAULT_URL_CC;
    }

    private String urlCC;

    public String getUrlCC() {
        return urlCC;
    }

    public void setUrlCC(String urlCC) {
        this.urlCC = urlCC;
    }

    public boolean CheckFileExist(File file) {
        return file.exists() && !file.isDirectory();
    }

    public void GetFileCSV() {
        try {
            ReadableByteChannel readChannel = Channels.newChannel(new URL(urlCC).openStream());
            String path = Constants.FILEPATH;
            FileOutputStream fileOS = new FileOutputStream(path);
            FileChannel writeChannel = fileOS.getChannel();
            writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
        } catch (IOException ex) {
            System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao realizar download do arquivo CSV. ", ButtonType.CLOSE);
            alert.show();
        }
    }

    public void ReadCSVFile() {
        System.out.println("------------- LENDO CSV -----------");
    }
}
