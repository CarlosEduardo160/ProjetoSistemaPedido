package Repository;

import Model.Produto;

import java.util.ArrayList;

public class ProdutoRepositorio {
    int contadorId = 1;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void criarProduto(int id, String nome, double preco){
        Produto novoProduto = new Produto(id, nome, preco);
        produtos.add(novoProduto);
        contadorId++;
    }
}
