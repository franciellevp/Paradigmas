package Views;

import Models.EnadeTableModel;
import Models.TableRowEnade;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class EnadeTableView extends EnadeTableModel {
    
    public void DrawTableView() {
        TableColumn<TableRowEnade, Boolean> selected = new TableColumn("Id");
        TableColumn<TableRowEnade, Integer> idQuestao = new TableColumn("Id Questão");
        TableColumn<TableRowEnade, String> prova = new TableColumn("Prova");
        TableColumn<TableRowEnade, String> tipo = new TableColumn("Tipo Questão");
        TableColumn<TableRowEnade, String> objeto = new TableColumn("Objeto");
        TableColumn<TableRowEnade, Integer> ano = new TableColumn("Ano");
        TableColumn<TableRowEnade, Double> acertoCurso = new TableColumn("Acertos Curso");
        TableColumn<TableRowEnade, Double> acertoRegiao = new TableColumn("Acertos Região");
        TableColumn<TableRowEnade, Double> acertoBr = new TableColumn("Acertos Brasil");
        TableColumn<TableRowEnade, Double> diferenca = new TableColumn("Diferença");

        selected.setCellValueFactory(new PropertyValueFactory<>("Id"));
        idQuestao.setCellValueFactory(new PropertyValueFactory<>("IdQuestao"));
        prova.setCellValueFactory(new PropertyValueFactory<>("Prova"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        objeto.setCellValueFactory(new PropertyValueFactory<>("Objeto"));
        ano.setCellValueFactory(new PropertyValueFactory<>("Ano"));
        acertoCurso.setCellValueFactory(new PropertyValueFactory<>("AcertoCurso"));
        acertoRegiao.setCellValueFactory(new PropertyValueFactory<>("AcertoRegiao"));
        acertoBr.setCellValueFactory(new PropertyValueFactory<>("AcertoBr"));
        diferenca.setCellValueFactory(new PropertyValueFactory<>("Diferenca"));

        final Callback<TableColumn<TableRowEnade, Boolean>, TableCell<TableRowEnade, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(selected);

        selected.setCellFactory(cellFactory);
        selected.setEditable(true);
        table.setEditable(true);
        
        LoadTableView();

        table.getColumns().addAll(selected, ano, prova, tipo, idQuestao, objeto, acertoCurso, acertoRegiao, acertoBr, diferenca);
    }
}
