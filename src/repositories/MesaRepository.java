package repositories;

import builders.Builder;
import interfaces.IRepositoryCRUD;
import models.Funcionario;
import models.Mesa;

import java.util.ArrayList;
import java.util.List;

public class MesaRepository implements IRepositoryCRUD {

    private List<Mesa> mesas;

    public MesaRepository() {

        mesas = new ArrayList<Mesa>();

    }

    @Override
    public void salvar(Object entidade) {
        Mesa mesa = (entidade != null) ? buscarPorId(((Mesa)entidade).getId()) : null;

        if(mesa == null) {
            mesas.add((Mesa) entidade);
        } else {
            // caso tenha uma mesa com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em mesa para atualizar a referência
            // com as atualizações
            mesa = (Mesa) entidade;
        }

    }

    @Override
    public List<Mesa> listarTodos() {
        return mesas;
    }

    @Override
    public void excluir(Object entidade) {
        mesas.remove(entidade);
    }

    @Override
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
