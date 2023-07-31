package repositories;

import builders.Builder;
import interfaces.IRepositoryCRUD;
import models.Cliente;
import models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IRepositoryCRUD {

    private List<Cliente> clientes;

    public ClienteRepository() {

        clientes = new ArrayList<Cliente>();
    }

    @Override
    public void salvar(Object entidade) {
        Cliente cliente = (entidade != null) ? buscarPorId(((Cliente) entidade).getId()) : null;

        if(cliente == null) {
            clientes.add((Cliente) entidade);
        } else {
            // caso tenha um cliente com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em cliente para atualizar a referência
            // com as atualizações
            cliente = (Cliente) entidade;
        }

    }

    @Override
    public List<Cliente> listarTodos() {
        return clientes;
    }

    @Override
    public void excluir(Object entidade) {
        clientes.remove(entidade);
    }

    @Override
    public Cliente buscarPorId(int id) {
        Cliente clienteBuscado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id)
                clienteBuscado = cliente;
        }

        return clienteBuscado;
    }

    public void deletarPeloId(Cliente cliente) {
        clientes.remove(cliente);
    }

    public int contar() {
        return clientes.size();
    }

    public Cliente buscarPorNome(String nome) {
        return null;
    }
}
