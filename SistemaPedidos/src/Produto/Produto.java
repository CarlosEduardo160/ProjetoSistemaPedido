package Produto;

public class Produto {
    private String nome;
    private double preco;
    private int id;

    public Produto(int id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }
}
