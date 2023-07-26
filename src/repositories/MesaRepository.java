package repositories;

import builders.Builder;
import models.Funcionario;
import models.Mesa;

import java.util.ArrayList;
import java.util.List;

public class MesaRepository {

    private List<Mesa> mesas;

    public MesaRepository() {

        mesas = new ArrayList<Mesa>();

    }

    public void salvar(Mesa entidade) {
        Mesa mesa = (entidade != null) ? buscarPorId(entidade.getId()) : null;

        if(mesa == null) {
            mesas.add(entidade);
        } else {
            // caso tenha uma mesa com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em mesa para atualizar a referência
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
            if (mesa.getId() == id) {
                mesaBuscada = mesa;
                if (mesaBuscada.getFuncionario() == null){
                    mesaBuscada.setFuncionario(new Funcionario());
                }
            }

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
