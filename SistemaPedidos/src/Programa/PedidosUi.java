package Programa;

import Model.Cliente;
import Model.Pedido;
import Model.Produto;
import Repository.ClienteRepositorio;
import Repository.PedidoRepositorio;
import Repository.ProdutoRepositorio;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidosUi {
    private PedidoRepositorio pedidoRepositorio;
    private ClienteRepositorio clienteRepositorio;
    private ProdutoRepositorio produtoRepositorio;
    Scanner entradaTexto = new Scanner(System.in);
    Scanner entradaNumero = new Scanner(System.in);

    public PedidosUi(){
        this.pedidoRepositorio = new PedidoRepositorio();
        this.clienteRepositorio = new ClienteRepositorio();
        this.produtoRepositorio = new ProdutoRepositorio();
    }

    public void iniciar(){
        boolean rodando = true;

        while(rodando){
            menuPrincipal();
            int opcao = entradaNumero.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoCliente;
                    do {
                        menuClientes();
                        opcaoCliente = entradaNumero.nextInt();

                        switch (opcaoCliente) {
                            case 1:
                                cadastrarCliente();
                                break;

                            case 2:
                                listarClientes();
                                break;

                            case 3:
                                buscarCliente();
                                break;

                            case 0:
                                System.out.println("--Voltando...");
                                break;

                            default:
                                System.out.println("--Opção inválida.");
                        }
                    } while (opcaoCliente != 0);
                    break;

                case 2: {
                    int opcaoProduto;
                    do {
                        menuProdutos();
                        opcaoProduto = entradaNumero.nextInt();
                        switch (opcaoProduto){
                            case 1:
                                adicionarProduto();
                                break;

                            case 2:
                                listarProdutos();
                                break;

                            case 3:
                                buscarProdutos();
                                break;

                            case 0:
                                System.out.println("--Voltando...");
                                break;

                            default:
                                System.out.println("--Opção inválida.");
                        }
                    } while(opcaoProduto != 0);
                    break;
                }
                case 3: {
                    int opcaoPedido;
                    do{
                        menuPedidos();
                        opcaoPedido = entradaNumero.nextInt();
                        switch (opcaoPedido){
                            case 1:
                                criarPedido();
                                break;

                            case 2:
                                listarPedidos();
                                break;

                            case 3:
                                buscarPedido();
                                break;

                            case 4:
                                atualizarStatus();
                                break;

                            case 0:
                                System.out.println("--Voltando...");
                                break;

                            default:
                                System.out.println("--Opção inválida.");
                        }
                    } while (opcaoPedido != 0);
                    break;
                }
                case 0: {
                    System.out.println("--Encerrando.");
                    rodando = false;
                    break;
                }
                default:
                    System.out.println("--Opção inválida.");
            }
        }
    }

    private void menuPrincipal(){
        String menuPrincipal = """
                
                ==============Sistema de Pedidos==============
                [1] - Clientes
                [2] - Produtos
                [3] - Pedidos
                [0] - Encerrar sistema
                ==============================================
                
                Escolha uma opção:
                """;
        System.out.print(menuPrincipal);
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
        System.out.print(menuCliente);
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
        System.out.print(menuProdutos);
    }

    private void menuPedidos(){
        String menuPedidos = """
                ==============Pedidos==============
                [1] - Criar pedido
                [2] - Listar pedidos
                [3] - Buscar pedidos
                [4] - Atualizar Status
                [0] - Voltar
                ==============================================
                
                Escolha uma opção: 
                """;
        System.out.print(menuPedidos);
    }

    private void menuAtualizarStatus(){
        String meunuAtualizarStatus = """
               ==============Status==============
                [1] - Pagar
                [2] - Enviar
                [3] - Cancelar
                [0] - Voltar
                ==============================================
                
                Escolha uma opção:
               """;
        System.out.print(meunuAtualizarStatus);
    }

    //-----------Clientes-----------

    public void cadastrarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nome = entradaTexto.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = entradaTexto.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        clienteRepositorio.cadastrarCliente(novoCliente);

        System.out.println("--Cliente cadastrado com sucesso!");
    }

    public void listarClientes(){
        ArrayList<Cliente> clientes = clienteRepositorio.listarClientes();

        if(clientes.isEmpty()){
            System.out.println("--Nenhum cliente cadastrado.");
        } else {
            for(Cliente cliente : clientes){
                System.out.println(cliente);
            }
        }
    }

    public void buscarCliente(){
        System.out.print("Digite o CPF do cliente: ");
        String cpf = entradaTexto.nextLine();

        Cliente clienteEncontrado = clienteRepositorio.buscarCliente(cpf);

        if(clienteEncontrado != null){
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("--Cliente não encontrado ou registrado.");
        }
    }

    //-----------Produtos-----------

    public void adicionarProduto(){
        System.out.print("Nome do produto: ");
        String nome = entradaTexto.nextLine();

        System.out.print("Preço: ");
        float preco = entradaNumero.nextFloat();

        Produto novoProduto = new Produto(nome, preco);
        produtoRepositorio.criarProduto(novoProduto);
        System.out.println("--Produto cadastrado com sucesso!");
    }

    public void listarProdutos(){
        ArrayList<Produto> estoque = produtoRepositorio.listarProdutos();

        if (estoque.isEmpty()) {
            System.out.println("--Nenhum produto no estoque.");
        } else {
            for (Produto produto : estoque) {
                System.out.println(produto);
            }
        }
    }

    public void buscarProdutos(){
        System.out.print("Digite o ID do produto: ");
        int id = entradaNumero.nextInt();

        Produto produtoEncontrado = produtoRepositorio.buscarProduto(id);

        if(produtoEncontrado != null){
            System.out.println(produtoEncontrado);
        } else {
            System.out.println("--Produto não encontrado ou registrado");
        }
    }

    //-----------Pedidos-----------

    public void criarPedido(){
        System.out.print("CPF do cliente: ");
        String cpf = entradaTexto.nextLine();
        Cliente clienteEncontrado = clienteRepositorio.buscarCliente(cpf);

        System.out.print("ID do produto: ");
        int id = entradaNumero.nextInt();
        Produto produtoEncontrado = produtoRepositorio.buscarProduto(id);

        if(clienteEncontrado == null || produtoEncontrado == null){
            System.out.println("--Não foi possivel criar o pedido. Por favor, verifique as informações inseridas");
        } else {
            pedidoRepositorio.criarPedido(clienteEncontrado, produtoEncontrado);
            System.out.println("--Pedido criado com sucesso!");
        }
    }

    public void listarPedidos(){
        ArrayList<Pedido> pedidos = pedidoRepositorio.listarPedidos();

        if(pedidos.isEmpty()){
            System.out.println("--Nenhum pedido registrado.");
        } else {
            for(Pedido pedido : pedidos){
                System.out.println(pedido);
            }
        }
    }

    public void buscarPedido(){
        System.out.print("ID do pedido: ");
        int id = entradaNumero.nextInt();
        Pedido pedidoEncontrado = pedidoRepositorio.buscarPedido(id);

        if(pedidoEncontrado == null){
            System.out.println("--Pedido não encontrado ou registrado");
        } else {
            System.out.println(pedidoEncontrado);
        }
    }

    public void atualizarStatus(){
        System.out.print("ID do pedido: ");
        int id = entradaNumero.nextInt();
        Pedido pedidoEncontrado = pedidoRepositorio.buscarPedido(id);

       if(pedidoEncontrado != null) {
           int opcaoStatus;
           do {
               menuAtualizarStatus();
               opcaoStatus = entradaNumero.nextInt();
               switch (opcaoStatus) {
                   case 1:
                       boolean sucessoPagar = pedidoEncontrado.pagar();

                       if(sucessoPagar){
                           System.out.println("--Pedido pago com sucesso!");
                       } else {
                           System.out.println("--Não foi possível pagar o pedido.");
                       }
                       break;

                   case 2:
                       boolean sucessoEnviar = pedidoEncontrado.enviar();

                       if(sucessoEnviar){
                           System.out.println("--Pedido enviado com sucesso!");
                       } else {
                           System.out.println("--Não foi possível enviar o pedido.");
                       }
                       break;

                   case 3:
                       boolean sucessoCancelar = pedidoEncontrado.cancelar();

                       if(sucessoCancelar){
                           System.out.println("--Pedido cancelado com sucesso!");
                       } else {
                           System.out.println("--Não foi possível cancelar o pedido.");
                       }
                       break;

                   case 0:
                       System.out.println("--Voltando...");
                       break;
               }
           } while (opcaoStatus != 0) ;
       } else {
           System.out.println("--Pedido não encontrado ou registrado");
       }
    }
}