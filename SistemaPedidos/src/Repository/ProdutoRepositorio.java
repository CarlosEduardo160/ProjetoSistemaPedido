package Repository;

import Model.Produto;

import java.util.ArrayList;

public class ProdutoRepositorio {
    public String resultado;
    int contadorId = 1;
    private ArrayList<Produto> estoque = new ArrayList<>();

    public void criarProduto(int id, String nome, double preco){
        Produto novoProduto = new Produto(id, nome, preco);
        estoque.add(novoProduto);
        contadorId++;
    }

    public void listarProdutos(){
        if(estoque.isEmpty()){
            System.out.println("Nenhum produto no estoque.");
        } else {
            for(Produto produto : estoque){
                System.out.println(produto);
            }
        }
    }

    public void buscarProduto(String termo){
        for(Produto produto : estoque){
            if(produto.getNome().contains(termo)){
                resultado = produto;
            }
        }
    }
}
