package Empresa;

public class Funcionario {
    private String Nome;
    private String Cpf;
    private float Salario;

    public Funcionario(String Nome, String Cpf, float Salario) {
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Salario = Salario;
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

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float Salario) {
        this.Salario = Salario;
    }
    
    public void ImprimeDados() {
        System.out.println("Nome: " + getNome()
            + "\nCPF: " + getCpf()
            + "\nSalario: " + getSalario());
    }
}
