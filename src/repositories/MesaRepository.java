package repositories;

import models.Mesa;

import java.util.ArrayList;
import java.util.List;

public class MesaRepository {

    private List<Mesa> mesas;

    public MesaRepository() {

        mesas = new ArrayList<Mesa>();
    }

    public void salvar(Mesa entidade) {
        Mesa mesa = buscarPorId(entidade.getId());

        if(mesa == null) {
            mesas.add(entidade);
        } else {
            // caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em funcionário para atualizar a referência
            // com as atualizações
            mesa = entidade;
        }

    }

    public List<Mesa> listarTodos() {
        return mesas;
    }

    public void excluir(Mesa entidade) {
        mesas.remove(entidade);
    }

    public Mesa buscarPorId(int id) {
        Mesa mesaBuscada = null;
        for (Mesa mesa : mesas) {
            if (mesa.getId() == id)
                mesaBuscada = mesa;
        }

        return mesaBuscada;
    }

    public void deletarPeloId(Mesa mesa) {
        mesas.remove(mesa);
    }

    public int contar() {
        return mesas.size();
    }
}
