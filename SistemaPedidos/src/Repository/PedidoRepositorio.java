package Repository;

import Model.Cliente;
import Model.Pedido;
import Model.Produto;

import java.util.ArrayList;

public class PedidoRepositorio {
    Produto produto;
    Cliente cliente;
    private int contadorId = 1;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void cadastrarPedido(Cliente cliente, Produto produto){
        Pedido novoPedido = new Pedido(contadorId, cliente, produto);
        pedidos.add(novoPedido);
        contadorId++;
    }

    public void exibirPedidos(){
        if(pedidos.isEmpty()){
            System.out.println("Nenhum pedido registrado.");
        } else {
            for(Pedido pedido : pedidos){
                System.out.println("=============");
                System.out.println("Pedido:");
                System.out.println("Comprador: " + cliente.getNome() + " - " + cliente.getCpf());
                System.out.println("Id: " + produto.getId());
                System.out.println("Produto: " + produto.getNome());
                System.out.println("R$: " + produto.getPreco());
                System.out.println("=============");
            }
        }
    }


}
