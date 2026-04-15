package Repository;

import Model.Cliente;

import java.util.ArrayList;

public class ClienteRepositorio {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarCliente(String cpf) {
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }
}