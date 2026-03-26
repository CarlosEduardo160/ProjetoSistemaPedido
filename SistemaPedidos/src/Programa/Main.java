package Programa;

import Cliente.Cliente;
import Pedido.Pedido;
import Produto.Produto;

import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        criarPedido();
    }

    public static void criarPedido(){
        Cliente cliente01 = new Cliente("Carlos", "123");
        Produto produto01 = new Produto(1, "Samsung Galaxy", 3200);

        Pedido pedido01 = new Pedido(cliente01, produto01);
        pedido01.pagar();
        pedido01.imprimirResumo();
    }
}
