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
                                cadastarCliente();
                                System.out.println("--Cliente cadastrado com sucesso!");
                                break;

                            case 2:
                                listarClientes();
                                break;

                            case 3:
                                buscarCliente();
                                break;

                            case 0:
                                System.out.println("Voltando...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opcaoCliente != 0);

                case 2: {
                    menuProdutos();
                    break;
                }
                case 3: {
                    menuPedidos();
                    break;
                }
                case 0: {
                    rodando = false;
                }
                default:
                    System.out.println("Opção inválida.");
            }
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

    //-----------Clientes-----------

    public void cadastarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nome = entradaTexto.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = entradaTexto.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        clienteRepositorio.cadastrarCliente(novoCliente);
    }

    public void listarClientes(){
        System.out.println("Lista de clientes:");
        clienteRepositorio.listarClientes();
    }

    public void buscarCliente(){
        System.out.print("Digite o CPF do cliente: ");
        String cpf = entradaTexto.nextLine();

        Cliente clienteEncontrado = clienteRepositorio.buscarCliente(cpf);

        if(clienteEncontrado == null){
            System.out.println("--Cliente não encontrado ou registrado.");
        } else {
            System.out.println(clienteEncontrado);
        }
    }

    //-----------Produtos-----------

    public void adicionarProduto(){
        System.out.print("Nome do produto: ");
        String nome = entradaTexto.nextLine();

        System.out.print("Preço: ");
        float preco = entradaNumero.nextFloat();

        produtoRepositorio.criarProduto(nome, preco);
    }

    public void listarProdutos(){
        System.out.println("Lista de clientes:");
        produtoRepositorio.listarProdutos();
    }

    public void buscarProdutos(){
        System.out.print("Digite o ID do produto: ");
        int id = entradaNumero.nextInt();

        produtoRepositorio.buscarProduto(id);
    }

    //-----------Pedidos-----------

    public void criarPedido(){
        System.out.print("CPF do cliente: ");
        String cpf = entradaTexto.nextLine();
        Cliente cliente = clienteRepositorio.buscarCliente(cpf);

        System.out.print("ID do produto: ");
        int id = entradaNumero.nextInt();
        Produto produto = produtoRepositorio.buscarProduto(id);

        pedidoRepositorio.criarPedido(cliente, produto);
    }

    public void listarPedidos(){
        System.out.println("Lista de pedidos: ");
        pedidoRepositorio.listarPedidos();
    }

    public void buscarPedido(){
        System.out.print("ID do pedido: ");
        int id = entradaNumero.nextInt();
        pedidoRepositorio.buscarPedido(id);
    }

}
