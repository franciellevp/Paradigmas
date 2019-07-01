package Models;

import Utils.Constants;
import Views.EnadeTableView;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EnadeModel {

    private String urlCC;
    private EnadeTableView tableView;

    public EnadeModel(String urlCC, EnadeTableView tableView) {
        this.urlCC = urlCC;
        this.tableView = tableView;
    }

    public EnadeModel() {
        this.urlCC = Constants.DEFAULT_URL_CC;
    }

    public String getUrlCC() {
        return urlCC;
    }

    public void setUrlCC(String urlCC) {
        this.urlCC = urlCC;
    }

    public EnadeTableView getTableView() {
        return tableView;
    }

    public void setTableView(EnadeTableView tableView) {
        this.tableView = tableView;
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

    public ArrayList<TableRowEnade> GetCSVFileContent() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(Constants.FILEPATH));
                CSVReader csvReader = new CSVReader(reader);) {
            // Reading Records One by One in a String array
            ArrayList<TableRowEnade> list = new ArrayList<>();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                TableRowEnade row = new TableRowEnade(
                        nextRecord[4],
                        nextRecord[4],
                        nextRecord[1],
                        nextRecord[3],
                        nextRecord[5],
                        nextRecord[2],
                        nextRecord[8],
                        nextRecord[9],
                        nextRecord[10],
                        nextRecord[11]
                );
                list.add(row);
            }
            return list;
        }
    }
}
