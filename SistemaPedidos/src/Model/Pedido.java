package Model;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    Cliente cliente;
    Produto produto;
    private StatusPedido status = StatusPedido.PENDENTE;

    public Pedido(int idPedido, Cliente cliente, Produto produto){
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.produto = produto;
    }

    public void pagar(){
        if(status == StatusPedido.PENDENTE){
            status = StatusPedido.PAGO;
        }
    }

    public void imprimirResumo(){
        System.out.println("Pedido: " + produto.getNome());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Status: " + status);
    }
}
