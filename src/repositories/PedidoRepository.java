package repositories;

import models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    private List<Pedido> pedidos;

    public PedidoRepository() {

        pedidos = new ArrayList<Pedido>();
    }

    public void salvar(Pedido entidade) {
        Pedido pedido = (entidade != null) ? buscarPorId(entidade.getId()) : null;

        if(pedido == null) {
            pedidos.add(entidade);
        } else {
            // caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em funcionário para atualizar a referência
            // com as atualizações
            pedido = entidade;
        }

    }

    public List<Pedido> listarTodos() {
        return pedidos;
    }

    public void excluir(Pedido entidade) {
        pedidos.remove(entidade);
    }

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
