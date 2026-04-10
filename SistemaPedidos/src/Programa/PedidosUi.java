package Programa;

import Model.Cliente;
import Model.Produto;
import Repository.ClienteRepositorio;
import Repository.PedidoRepositorio;
import Repository.ProdutoRepositorio;

import java.util.Scanner;

public class PedidosUi {
    private PedidoRepositorio pedidoRepositorio;
    private ClienteRepositorio clienteRepositorio;
    private ProdutoRepositorio produtoRepositorio;
    Scanner entrada = new Scanner(System.in);
    Scanner entradaTexto = new Scanner(System.in);
    Scanner entradaNumero = new Scanner(System.in);

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

    public void cadastarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nome = entradaTexto.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = entrada.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        clienteRepositorio.cadastrarCliente(novoCliente);
    }
}
