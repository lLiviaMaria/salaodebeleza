package models;

/* 
    public (publica) -> visivel a qualquer classe 
            (pode ser acessada por qualquer classe do projeto)
    private (privado)-> só esta visivel a própria classe 
            (não pode ser acessada por outras classes)
    protected(protegida)-> visivel a sua própria classe
              e aos seus filhos(herança).
*/
abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String email;
    protected String telefone;
    protected String rg;
    protected String cpf;
    
    //criar construtores e getters and setters

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String email, String telefone, String rg, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
