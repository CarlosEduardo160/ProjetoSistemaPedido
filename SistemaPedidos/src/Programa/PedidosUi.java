package Programa;

import Repository.PedidoRepositorio;

public class PedidosUi {
    private PedidoRepositorio pedidoRepositorio;

    private void iniciar(){
        boolean rodando = true;

        while(rodando){
            menuPrincipal();

        }
    }

    private void menuPrincipal(){
        String menuPrincipal = """
                ==============Sistema de Pedidos==============
                [1] - Clientes
                [2] - Produtos
                [3] - Pedidos       
                [0] - Sair
                ==============================================
                
                Escolha uma opção: 
                """;
        System.out.println(menuPrincipal);
    }

    private void menuClientes(){
        String menuCliente = """
                ==============Clientes==============
                [1] - Cadastrar cliente
                [2] - Listar clientes
                [3] - Buscar cliente  
                [0] - Voltar
                ==============================================
                
                Escolha uma opção: 
                """;
        System.out.println(menuCliente);
    }

    private void menuProdutos(){
        String menuProdutos = """
                ==============Produtos==============
                [1] - Adicionar produto
                [2] - Listar produtos
                [3] - Buscar produto
                [0] - Voltar
                ==============================================
                
                Escolha uma opção: 
                """;
        System.out.println(menuProdutos);
    }

    private void menuPedidos(){
        String menuPedidos = """
                ==============Pedidos==============
                [1] - Criar pedido
                [2] - Listar pedidos
                [3] - Buscar pedidos   
                [0] - Voltar
                ==============================================
                
                Escolha uma opção: 
                """;
        System.out.println(menuPedidos);
    }
}
