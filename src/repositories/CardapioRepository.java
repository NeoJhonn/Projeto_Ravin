package repositories;

import interfaces.IRepositoryCRUD;
import models.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class CardapioRepository implements IRepositoryCRUD {
    private List<Cardapio> cardapios;


    public CardapioRepository() {

        cardapios = new ArrayList<Cardapio>();
    }

    @Override
    public void salvar(Object entidade) {
        Cardapio cardapio = ((Cardapio) entidade != null) ? buscarPorId(((Cardapio)entidade).getId()) : null;

        if(cardapio == null) {
            cardapios.add((Cardapio) entidade);
        } else {
            // caso tenha um cardapio com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em cardapio para atualizar a referência
            // com as atualizações
            cardapio = (Cardapio) entidade;
        }

    }

    @Override
    public List<Cardapio> listarTodos() {
        return cardapios;
    }

    @Override
    public void excluir(Object entidade) {
        cardapios.remove(entidade);
    }

    @Override
    public Cardapio buscarPorId(int id) {
        Cardapio cardapioBuscado = null;
        for (Cardapio cardapio : cardapios) {
            if (cardapio.getId() == id)
                cardapioBuscado = cardapio;
        }

        return cardapioBuscado;
    }

    public void deletarPeloId(Cardapio cardapio) {
        cardapios.remove(cardapio);
    }

    public int contar() {
        return cardapios.size();
    }

    public Cardapio buscarPorNome(String nome) {
        return null;
    }
}
