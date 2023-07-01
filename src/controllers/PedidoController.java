package controllers;

import models.Pedido;
import repositories.PedidoRepository;

import java.util.List;

public class PedidoController {

    private PedidoRepository repository;

    public PedidoController() {

        repository = new PedidoRepository();
    }

    public void cadastrar(Pedido entidade) {
        repository.salvar(entidade);
    }

    public void alterar(Pedido entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Pedido pedidoBuscado = repository.buscarPorId(id);

        if (pedidoBuscado != null) {
            repository.excluir(pedidoBuscado);
        }
    }

    public Pedido consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Pedido> listarTodos() {

        return repository.listarTodos();
    }
}
