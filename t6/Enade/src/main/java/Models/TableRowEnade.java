package Models;

public class TableRowEnade {

    private String Id;
    private String IdQuestao;
    private String Ano;
    private String Tipo;
    private String Objeto;
    private String Prova;
    private String AcertoCurso;
    private String AcertoRegiao;
    private String AcertoBr;
    private String Diferenca;

    public TableRowEnade(String Id, String IdQuestao, String Ano, String Tipo, String Objeto, String Prova, String AcertoCurso, String AcertoRegiao, String AcertoBr, String Diferenca) {
        this.Id = Id;
        this.IdQuestao = IdQuestao;
        this.Ano = Ano;
        this.Tipo = Tipo;
        this.Objeto = Objeto;
        this.Prova = Prova;
        this.AcertoCurso = AcertoCurso;
        this.AcertoRegiao = AcertoRegiao;
        this.AcertoBr = AcertoBr;
        this.Diferenca = Diferenca;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIdQuestao() {
        return IdQuestao;
    }

    public void setIdQuestao(String IdQuestao) {
        this.IdQuestao = IdQuestao;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getAcertoCurso() {
        return AcertoCurso;
    }

    public void setAcertoCurso(String AcertoCurso) {
        this.AcertoCurso = AcertoCurso;
    }

    public String getAcertoRegiao() {
        return AcertoRegiao;
    }

    public void setAcertoRegiao(String AcertoRegiao) {
        this.AcertoRegiao = AcertoRegiao;
    }

    public String getAcertoBr() {
        return AcertoBr;
    }

    public void setAcertoBr(String AcertoBr) {
        this.AcertoBr = AcertoBr;
    }

    public String getDiferenca() {
        return Diferenca;
    }

    public void setDiferenca(String Diferenca) {
        this.Diferenca = Diferenca;
    }

    public String getProva() {
        return Prova;
    }

    public void setProva(String Prova) {
        this.Prova = Prova;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getObjeto() {
        return Objeto;
    }

}
