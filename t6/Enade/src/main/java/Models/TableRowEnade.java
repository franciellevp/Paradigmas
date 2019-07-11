package Models;

public class TableRowEnade {

    private String Selected;
    private String IdQuestao;
    private String Ano;
    private String Tipo;
    private String Objeto;
    private String Prova;
    private String AcertoCurso;
    private String AcertoRegiao;
    private String AcertoBr;
    private String Diferenca;
    private String Gabarito;
    private String Imagem;
    private String Url;

    public TableRowEnade(String Selected, String IdQuestao, String Ano, String Tipo, String Objeto,
            String Prova, String AcertoCurso, String AcertoRegiao, String AcertoBr, String Diferenca,
            String Gabarito, String Imagem, String Url) {
        this.Selected = Selected;
        this.IdQuestao = IdQuestao;
        this.Ano = Ano;
        this.Tipo = Tipo;
        this.Objeto = Objeto;
        this.Prova = Prova;
        this.AcertoCurso = AcertoCurso;
        this.AcertoRegiao = AcertoRegiao;
        this.AcertoBr = AcertoBr;
        this.Diferenca = Diferenca;
        this.Gabarito = Gabarito;
        this.Imagem = Imagem;
        this.Url = Url;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String Imagem) {
        this.Imagem = Imagem;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getGabarito() {
        return Gabarito;
    }

    public void setGabarito(String Gabarito) {
        this.Gabarito = Gabarito;
    }

    public String getSelected() {
        return Selected;
    }

    public void setSelected(String Selected) {
        this.Selected = Selected;
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

    public String getTipo() {
        return Tipo;
    }

    public void setObjeto(String Objeto) {
        this.Objeto = Objeto;
    } 
}
