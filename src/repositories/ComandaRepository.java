package repositories;

import models.Comanda;
import models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ComandaRepository {

    private List<Comanda> comandas;



    public ComandaRepository() {

        comandas = new ArrayList<Comanda>();
    }

    public void salvar(Comanda entidade) {
        Comanda comanda = (entidade != null) ? buscarPorId(entidade.getId()) : null;

        if(comanda == null) {
            comandas.add(entidade);
        } else {
            // caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em funcionário para atualizar a referência
            // com as atualizações
            comanda = entidade;
        }

    }

    public List<Comanda> listarTodos() {
        return comandas;
    }


    public void excluir(Comanda entidade) {
        comandas.remove(entidade);
    }

    public Comanda buscarPorId(int id) {
        Comanda comandaBuscada = null;
        for (Comanda comanda : comandas) {
            if (comanda.getId() == id)
                comandaBuscada = comanda;
        }

        return comandaBuscada;
    }

    public void deletarPeloId(Comanda comanda) {
        comandas.remove(comanda);
    }

    public int contar() {
        return comandas.size();
    }
}
