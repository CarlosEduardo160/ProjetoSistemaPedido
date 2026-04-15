package Repository;

import Model.Cliente;
import Model.Pedido;
import Model.Produto;

import java.util.ArrayList;

public class PedidoRepositorio {
    private int contadorId = 1;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(Cliente cliente, Produto produto){
        Pedido novoPedido = new Pedido(contadorId, cliente, produto);
        pedidos.add(novoPedido);
        contadorId++;
    }

    public ArrayList<Pedido> listarPedidos(){
        return pedidos;
    }

    public Pedido buscarPedido(int id){
        for(Pedido pedido : pedidos){
            if(pedido.getIdPedido() == id){
                return pedido;
            }
        }
        return null;
    }
}