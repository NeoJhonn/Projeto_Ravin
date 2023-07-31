package repositories;

import interfaces.IRepositoryCRUD;
import models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository implements IRepositoryCRUD {

    private List<Pedido> pedidos;

    public PedidoRepository() {

        pedidos = new ArrayList<Pedido>();
    }

    @Override
    public void salvar(Object entidade) {
        Pedido pedido = (entidade != null) ? buscarPorId(((Pedido)entidade).getId()) : null;

        if(pedido == null) {
            pedidos.add((Pedido) entidade);
        } else {
            // caso tenha um Pedido com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em Pedido para atualizar a referência
            // com as atualizações
            pedido = (Pedido) entidade;
        }

    }

    @Override
    public List<Pedido> listarTodos() {
        return pedidos;
    }

    @Override
    public void excluir(Object entidade) {
        pedidos.remove(entidade);
    }

    @Override
    public Pedido buscarPorId(int id) {
        Pedido pedidoBuscado = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id)
                pedidoBuscado = pedido;
        }

        return pedidoBuscado;
    }

    public void deletarPeloId(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public int contar() {
        return pedidos.size();
    }
}
