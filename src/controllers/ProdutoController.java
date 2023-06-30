package controllers;

import models.Produto;
import repositories.ProdutoRepository;

import java.util.List;

public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController() {

        repository = new ProdutoRepository();
    }

    public void cadastrar(Produto entidade) {
        repository.salvar(entidade);
    }

    public void alterar(Produto entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Produto produtoBuscado = repository.buscarPorId(id);

        if (produtoBuscado != null) {
            repository.excluir(produtoBuscado);
        }
    }

    public Produto consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Produto> listarTodos() {

        return repository.listarTodos();
    }
}
