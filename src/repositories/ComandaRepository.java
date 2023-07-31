package repositories;

import interfaces.IRepositoryCRUD;
import models.Comanda;
import models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ComandaRepository implements IRepositoryCRUD {

    private List<Comanda> comandas;



    public ComandaRepository() {

        comandas = new ArrayList<Comanda>();
    }

    @Override
    public void salvar(Object entidade) {
        Comanda comanda = (entidade != null) ? buscarPorId(((Comanda) entidade).getId()) : null;

        if(comanda == null) {
            comandas.add((Comanda)entidade);
        } else {
            // caso tenha um comanda com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em comanda para atualizar a referência
            // com as atualizações
            comanda = (Comanda) entidade;
        }

    }

    @Override
    public List<Comanda> listarTodos() {
        return comandas;
    }


    @Override
    public void excluir(Object entidade) {
        comandas.remove(entidade);
    }

    @Override
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
