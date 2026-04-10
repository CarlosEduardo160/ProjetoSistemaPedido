package Repository;

import Model.Cliente;

import java.util.ArrayList;

public class ClienteRepositorio {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente){
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

    public Cliente buscarCliente(String termo) {
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(termo));{
                return cliente;
            }
        }
        return null;
    }
}
