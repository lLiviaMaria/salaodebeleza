package models;

public class Funcionario extends Pessoa {
    private float salario;

    public Funcionario() {
    }

    public Funcionario( int id, String nome, String telefone, String email, String rg, String cpf, float salario) {
        super(id, nome, email,telefone, rg, cpf);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
}
