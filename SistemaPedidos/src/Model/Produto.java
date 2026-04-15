package Model;

public class Produto {
    private String nome;
    private float preco;
    private int id;

    public Produto(String nome, float preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | R$:%.2f ", id, nome, preco);
    }
}
