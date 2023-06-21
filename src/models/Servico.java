package models;

public class Servico {    
    //atributos
    private int id;
    private String descricao;
    private float valor;
    
    //métodos construtores e getters and setters
    //ctrl + espaço ==> cria dos construtores
    public Servico() {
    }

    public Servico(int id, String descricao, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    //alt + insert ==> getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
}
