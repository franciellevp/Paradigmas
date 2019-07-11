package Models;

import Utils.Operacao;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class EnadeTableModel {

    protected ArrayList<TableRowEnade> listTableView;
    protected final TableView<TableRowEnade> table;

    public EnadeTableModel() {
        this.listTableView = new ArrayList<>();
        this.table = new TableView<>();
    }

    public ArrayList<TableRowEnade> getTableView() {
        return listTableView;
    }

    public void setTableView(ArrayList<TableRowEnade> listTableView) {
        this.listTableView = listTableView;
    }

    public TableView<TableRowEnade> getTable() {
        return table;
    }

    protected ObservableList<TableRowEnade> listaDeObjetos() {
        return FXCollections.observableArrayList(listTableView);
    }

    public void LoadTableView() {
        table.setItems(listaDeObjetos());
    }

    public double[] GetSomaAcertos() {
        double somas[] = {0, 0, 0};
        for (TableRowEnade x : listTableView) {
            somas[0] += Operacao.StringToDouble(x.getAcertoCurso());
            somas[1] += Operacao.StringToDouble(x.getAcertoRegiao());
            somas[2] += Operacao.StringToDouble(x.getAcertoBr());
        }
        return somas;
    }
}
