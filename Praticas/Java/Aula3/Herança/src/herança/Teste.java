package herança;

import Empresa.Funcionario;
import Empresa.Gerente;

public class Teste {
    public static void main(String[] args) {
        Estudante estudante1 = new Estudante(123, "Francielle", "123.123.123-34");
        estudante1.setMatricula(294382);
        System.out.println("Matricula: " + estudante1.getMatricula());
        
        Professor professor1 = new Professor(123, 2000.97f, "Laura", "123.123.123-12");
        //professor1.setNome("Professorzinho");
        System.out.println("Nome: " + professor1.getNome());
        
        System.out.println("------- EMPRESA ------");
        Funcionario funcionario = new Funcionario("Funcionario", "123.123.123-43", 78423.43f);
        Gerente gerente = new Gerente("Gerente", "999.999.999-99", 43243.534f);
        
        funcionario.ImprimeDados();
        gerente.ImprimeDados();
    }
}
