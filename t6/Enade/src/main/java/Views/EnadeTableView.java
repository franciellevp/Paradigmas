package Views;

import Models.TableRowEnade;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class EnadeTableView {

    private ArrayList<TableRowEnade> tableView;
    private final TableView table = new TableView();

    public EnadeTableView() {
        this.tableView = new ArrayList<>();
    }

    public ArrayList<TableRowEnade> getTableView() {
        return tableView;
    }

    public void setTableView(ArrayList<TableRowEnade> tableView) {
        this.tableView = tableView;

    }

    public TableView getTable() {
        return table;
    }

    public void DrawTableView() {
        TableColumn<TableRowEnade, Boolean> selected = new TableColumn("Id");
        TableColumn<TableRowEnade, Integer> idQuestao = new TableColumn("Id Questão");
        TableColumn<TableRowEnade, String> prova = new TableColumn("Prova");
        TableColumn<TableRowEnade, String> tipo = new TableColumn("Tipo Questão");
        TableColumn<TableRowEnade, String> objeto = new TableColumn("Objeto");
        TableColumn<TableRowEnade, Integer> ano = new TableColumn("Ano");
        TableColumn<TableRowEnade, Double> acertoCurso = new TableColumn("Acertos Curso");
        TableColumn<TableRowEnade, Double> acertoRegiao = new TableColumn("Acertos Curso");
        TableColumn<TableRowEnade, Double> acertoBr = new TableColumn("Acertos Curso");
        TableColumn<TableRowEnade, Double> diferenca = new TableColumn("Acertos Curso");

        selected.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Boolean>("Id"));
        idQuestao.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Integer>("IdQuestao"));
        prova.setCellValueFactory(new PropertyValueFactory<TableRowEnade, String>("Prova"));
        tipo.setCellValueFactory(new PropertyValueFactory<TableRowEnade, String>("Tipo"));
        objeto.setCellValueFactory(new PropertyValueFactory<TableRowEnade, String>("Objeto"));
        ano.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Integer>("Ano"));
        acertoCurso.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Double>("AcertoCurso"));
        acertoRegiao.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Double>("AcertoRegiao"));
        acertoBr.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Double>("AcertoBr"));
        diferenca.setCellValueFactory(new PropertyValueFactory<TableRowEnade, Double>("Diferenca"));

        selected.setCellFactory(CheckBoxTableCell.forTableColumn(selected));

        LoadTableView();

        table.getColumns().addAll(selected, ano, prova, tipo, idQuestao, objeto, acertoCurso, acertoRegiao, acertoBr, diferenca);
    }

    private ObservableList<TableRowEnade> listaDeObjetos() {
        return FXCollections.observableArrayList(tableView);
    }

    public void LoadTableView() {
        table.setItems(listaDeObjetos());
    }

}
