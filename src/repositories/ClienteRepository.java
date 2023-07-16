package repositories;

import builders.Builder;
import models.Cliente;
import models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepository() {

        clientes = new ArrayList<Cliente>();
    }

    public void salvar(Cliente entidade) {
        Cliente cliente = (entidade != null) ? buscarPorId(entidade.getId()) : null;

        if(cliente == null) {
            clientes.add(entidade);
        } else {
            // caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em funcionário para atualizar a referência
            // com as atualizações
            cliente = entidade;
        }

    }

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public void excluir(Cliente entidade) {
        clientes.remove(entidade);
    }

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
