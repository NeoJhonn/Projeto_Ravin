package controllers;

import models.Cliente;
import models.Funcionario;
import repositories.ClienteRepository;
import util.UtilitarioData;

import java.util.List;

public class ClienteController {

    private ClienteRepository repository;

    public ClienteController() {

        repository = new ClienteRepository();
    }

    public void cadastrar(Cliente entidade) throws Exception {
        if (UtilitarioData.getIdade(entidade.getDataNascimento()) < 18) {
            throw new Exception("Não pode salvar o cliente, pois ele é menor de idade");
        }
        repository.salvar(entidade);
    }

    public void alterar(Cliente entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Cliente clienteBuscado = repository.buscarPorId(id);

        if (clienteBuscado != null) {
            repository.excluir(clienteBuscado);
        }
    }

    public Cliente consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {

        return repository.listarTodos();
    }
}
