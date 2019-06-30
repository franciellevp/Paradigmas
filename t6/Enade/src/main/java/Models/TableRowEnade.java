package Models;

public class TableRowEnade {
    private int Id;
    private int IdQuestao;
    private int Ano;
    private String Tipo;
    private String Questao;
    private String Objeto;
    private String Prova;
    private double AcertoCurso;
    private double AcertoRegiao;
    private double AcertoBr;
    private double Diferenca;

    public TableRowEnade(int Id, int IdQuestao, int Ano, String Tipo, String Questao, String Objeto, String Prova, double AcertoCurso, double AcertoRegiao, double AcertoBr, double Diferenca) {
        this.Id = Id;
        this.IdQuestao = IdQuestao;
        this.Ano = Ano;
        this.Tipo = Tipo;
        this.Questao = Questao;
        this.Objeto = Objeto;
        this.Prova = Prova;
        this.AcertoCurso = AcertoCurso;
        this.AcertoRegiao = AcertoRegiao;
        this.AcertoBr = AcertoBr;
        this.Diferenca = Diferenca;
    }

    public String getProva() {
        return Prova;
    }

    public void setProva(String Prova) {
        this.Prova = Prova;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdQuestao() {
        return IdQuestao;
    }

    public void setIdQuestao(int IdQuestao) {
        this.IdQuestao = IdQuestao;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getQuestao() {
        return Questao;
    }

    public void setQuestao(String Questao) {
        this.Questao = Questao;
    }

    public String getObjeto() {
        return Objeto;
    }

    public void setObjeto(String Objeto) {
        this.Objeto = Objeto;
    }

    public double getAcertoCurso() {
        return AcertoCurso;
    }

    public void setAcertoCurso(double AcertoCurso) {
        this.AcertoCurso = AcertoCurso;
    }

    public double getAcertoRegiao() {
        return AcertoRegiao;
    }

    public void setAcertoRegiao(double AcertoRegiao) {
        this.AcertoRegiao = AcertoRegiao;
    }

    public double getAcertoBr() {
        return AcertoBr;
    }

    public void setAcertoBr(double AcertoBr) {
        this.AcertoBr = AcertoBr;
    }

    public double getDiferenca() {
        return Diferenca;
    }

    public void setDiferenca(double Diferenca) {
        this.Diferenca = Diferenca;
    }
}
