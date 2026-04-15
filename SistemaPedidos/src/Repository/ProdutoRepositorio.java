package Repository;

import Model.Produto;

import java.util.ArrayList;

public class ProdutoRepositorio {
    private int contadorId = 1;
    private ArrayList<Produto> estoque = new ArrayList<>();

    public void criarProduto(Produto produto) {
        produto.setId(contadorId);
        estoque.add(produto);
        contadorId++;
    }

    public ArrayList<Produto> listarProdutos() {
        return estoque;
    }

    public Produto buscarProduto(int id) {
        for (Produto produto : estoque) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}