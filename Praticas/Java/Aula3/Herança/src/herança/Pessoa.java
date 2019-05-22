package herança;

public class Pessoa {
    private String Nome;
    private String Cpf;

    public Pessoa(String Nome, String cpf) {
        this.Nome = Nome;
        this.Cpf = cpf;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }
}
