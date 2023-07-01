package controllers;

import models.Comanda;
import repositories.ComandaRepository;

import java.util.List;

public class ComandaController {

    private ComandaRepository repository;

    public ComandaController() {

        repository = new ComandaRepository();
    }

    public void cadastrar(Comanda entidade) {
        repository.salvar(entidade);
    }

    public void alterar(Comanda entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Comanda comandaBuscada = repository.buscarPorId(id);

        if (comandaBuscada != null) {
            repository.excluir(comandaBuscada);
        }
    }

    public Comanda consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Comanda> listarTodos() {

        return repository.listarTodos();
    }
}
