package Empresa;

public class TesteEmpresa {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Funcionario", "123.123.123-43", 78423.43f);
        Gerente gerente = new Gerente("Gerente", "999.999.999-99", 43243.534f);
        
        funcionario.ImprimeDados();
        gerente.ImprimeDados();
    }
}
