package models;

public class Cliente extends Pessoa {
    private String endereco;
    private String cep;

    public Cliente() {
    }

    public Cliente(String endereco, String cep, int id, String nome, String email,String telefone, String rg, String cpf) {
        super(id, nome, email, telefone, rg, cpf);
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
