package Repository;

import Model.Cliente;

import java.util.ArrayList;

public class ClienteRepositorio {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void criarUsuario(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
    }
}
