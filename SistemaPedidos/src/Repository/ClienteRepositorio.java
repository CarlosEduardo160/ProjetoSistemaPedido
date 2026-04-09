package Repository;

import Model.Cliente;

import java.util.ArrayList;

public class ClienteRepositorio {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for(Cliente cliente : clientes){
                System.out.println("Nome: " + cliente.getNome() + "| Cpf: " + cliente.getCpf() );
            }
        }
    }

    public void buscarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Digite o CPF do cliente: ");
            for(Cliente cliente : clientes){
                System.out.println("Nome: " + cliente.getNome() + "| Cpf: " + cliente.getCpf() );
            }
        }
    }
}
