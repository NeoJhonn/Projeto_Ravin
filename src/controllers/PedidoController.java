package controllers;

import enums.StatusPreparo;
import models.Cliente;
import models.Pedido;
import repositories.PedidoRepository;

import java.sql.Timestamp;
import java.util.List;

public class PedidoController {

    private PedidoRepository repository;

    public PedidoController() {

        repository = new PedidoRepository();
    }

    public void cadastrar(Pedido entidade) {
        if (!entidade.equals(null)) {
            repository.salvar(entidade);
        }
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

    public void alterarStatusPedido(Pedido pedido) {
        if (new Timestamp(System.currentTimeMillis()).getTime() > pedido.getTempoPreparoRestante().getTime()){
            pedido.setStatusPreparo(StatusPreparo.Pronto);
        }
    }

    public double somarPedidosCliente(Cliente cliente) {
        double total = 0;

        for (Pedido pedido: repository.listarTodos()) {
            if (pedido.getClienteId() == cliente.getId()) {
                total += (pedido.getProduto().getPrecoVenda() * pedido.getQuantidade());
            }
        }


        return total;
    }
}
