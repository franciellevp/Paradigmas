package Views;

import Models.TableRowEnade;
import Utils.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class EnadeInfoModal {

    private Stage parentStage;
    private Stage stage;
    private TableRowEnade data;

    public EnadeInfoModal(Stage parentStage, TableRowEnade data) {
        this.parentStage = parentStage;
        this.data = data;
        this.stage = new Stage();
    }

    public void DrawModal() {
        try {
            HBox root = new HBox();
            VBox row = new VBox();
            HBox infoRow = new HBox();
            HBox grafRow = new HBox();
            String infos = "\nId: " + data.getIdQuestao()
                    + "\nProva: " + data.getProva()
                    + "\nTipo: " + data.getTipo()
                    + "\nObjeto: " + data.getObjeto()
                    + "\nAno: " + data.getAno()
                    + "\nAcertos por Curso: " + data.getAcertoCurso()
                    + "\nAcertos por Região: " + data.getAcertoRegiao()
                    + "\nAcertos Brasil: " + data.getAcertoBr()
                    + "\nDiferença: " + data.getDiferenca()
                    + "\nGabarito: " + data.getGabarito();
            Label infosQuestao = new Label(infos);
            infoRow.getChildren().add(infosQuestao);
            double acertoC = Double.parseDouble(data.getAcertoCurso().replace(",", "."));
            double acertoR = Double.parseDouble(data.getAcertoRegiao().replace(",", "."));
            double acertoB = Double.parseDouble(data.getAcertoBr().replace(",", "."));
            grafRow.getChildren().add(DrawBarGraph(acertoC, acertoR, acertoB));

            row.getChildren().addAll(infoRow, grafRow);

            HBox imgBox = new HBox();
            if (!data.getUrl().equals("")) {
                imgBox.getChildren().add(new ImageView(GetImageQuestion()));
            }

            root.getChildren().addAll(row, imgBox);
            Scene scene = new Scene(root);
            stage.setTitle("Dados da Questão");
            stage.setScene(scene);
            stage.setHeight(Constants.HEIGHT_MODAL);
            stage.setWidth(Constants.WIDTH_MODAL);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(parentStage);
            stage.showAndWait();
        } catch (NumberFormatException ex) {
            String msg = "Erro ao abrir modal. ";
            System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.ERROR, msg, ButtonType.CLOSE);
            alert.show();
        }
    }

    private Image GetImageQuestion() {
        File file = new File(Constants.IMAGEPATH + data.getIdQuestao() + data.getAno() + ".jpg");

        if (!file.exists()) {
            InputStream in = null;
            try {
                in = new URL(data.getUrl()).openStream();
                Files.copy(in, Paths.get(file.getPath()), StandardCopyOption.REPLACE_EXISTING);
            } catch (MalformedURLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao realizar operação", ButtonType.CLOSE);
                alert.show();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao realizar operação", ButtonType.CLOSE);
                alert.show();
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao realizar operação", ButtonType.CLOSE);
                    alert.show();
                }
            }
        }
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR, "Erro ao carregar imagem").show();
        }
        return image;
    }
    
    private BarChart<String,Number> DrawBarGraph(Double acertoCurso, Double acertoRegiao, Double acertoBr) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
        bc.setTitle("Número de acertos");
        xAxis.setLabel("Acertos");       
        yAxis.setLabel("Quantidade de acertos"); 
        
        XYChart.Series series = new XYChart.Series();
        //series1.setName("2003");
        series.getData().add(new XYChart.Data("Acerto por Curso", 25601.34));
        series.getData().add(new XYChart.Data("Acerto por Região", 20148.82));
        series.getData().add(new XYChart.Data("Acerto Brasil", 10000));
        bc.getData().add(series);
        return bc;
    }
}
