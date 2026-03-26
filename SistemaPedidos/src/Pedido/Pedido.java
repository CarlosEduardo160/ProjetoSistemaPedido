package Pedido;

import Cliente.Cliente;
import Produto.Produto;

public class Pedido {
    Cliente cliente;
    Produto produto;
    private StatusPedido status = StatusPedido.PENDENTE;

    public Pedido(Cliente cliente, Produto produto){
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
