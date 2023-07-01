package controllers;

import models.Mesa;
import repositories.MesaRepository;

import java.util.List;

public class MesaController {

    private MesaRepository repository;

    public MesaController() {

        repository = new MesaRepository();
    }

    public void cadastrar(Mesa entidade) {
        repository.salvar(entidade);
    }

    public void alterar(Mesa entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Mesa mesaBuscada = repository.buscarPorId(id);

        if (mesaBuscada != null) {
            repository.excluir(mesaBuscada);
        }
    }

    public Mesa consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Mesa> listarTodos() {

        return repository.listarTodos();
    }
}
