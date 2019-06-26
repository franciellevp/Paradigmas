package Views;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EnadeTableView {
    
    public TableView table = new TableView();

    public TableView getTable() {
        return table;
    }
    
    public void DrawTableView() {
        TableColumn ano = new TableColumn("Ano");
        TableColumn prova = new TableColumn("Prova");
        TableColumn tipo = new TableColumn("Tipo");
        TableColumn idQuestao = new TableColumn("Id Questão");
        TableColumn questao = new TableColumn("Questão");
        TableColumn objeto = new TableColumn("Objeto");
        TableColumn acertoCurso = new TableColumn("Acertos Curso");
        TableColumn acertoRegiao = new TableColumn("Acertos Região");
        TableColumn acertoBr = new TableColumn("Acertos Brasil");
        TableColumn dif = new TableColumn("Dif. (Curso-Brasil)");

        table.getColumns().addAll(ano, prova, tipo, idQuestao, questao, objeto, acertoCurso, acertoRegiao, acertoBr, dif);
    }
    
}