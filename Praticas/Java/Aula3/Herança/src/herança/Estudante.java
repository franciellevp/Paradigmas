package herança;

public class Estudante extends Pessoa {
    private int Matricula;

    public Estudante(int Matricula, String Nome, String Cpf) {
        super(Nome, Cpf);
        this.Matricula = Matricula;
    }
    
    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }
}
