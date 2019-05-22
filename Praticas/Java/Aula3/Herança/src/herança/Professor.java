package herança;

public class Professor extends Pessoa {
    private int Siape;
    private float Salario;

    public Professor(int Siape, float Salario, String Nome, String cpf) {
        super(Nome, cpf);
        this.Siape = Siape;
        this.Salario = Salario;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float Salario) {
        this.Salario = Salario;
    }   
}
