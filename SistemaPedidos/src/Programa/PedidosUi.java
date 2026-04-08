package Programa;

import Repository.PedidoRepositorio;

public class PedidosUi {
    private PedidoRepositorio pedidoRepositorio;

    private void iniciar(){
        boolean rodando = true;

        while(rodando){
            menu();

        }
    }

    private void menu(){
        String menu = """
                ==============Sistema de Pedidos==============
                [1] - Cadastrar Cliente
                [2] - Cadastrar Produto
                [3] - Fazer pedido
                [4] - Exibir pedidos
                [5] - Encerrar programa
                ==============================================
                
                Escolha uma opção: 
                """;
        System.out.println(menu);
    }
}
