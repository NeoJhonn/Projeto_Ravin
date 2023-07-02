package repositories;

import interfaces.IRepositoryCRUD;
import models.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class CardapioRepository {
    private List<Cardapio> cardapios;

    public CardapioRepository() {

        cardapios = new ArrayList<Cardapio>();
    }


    public void salvar(Cardapio entidade) {
        Cardapio cardapio = buscarPorId(entidade.getId());

        if(cardapio == null) {
            cardapios.add(entidade);
        } else {
            // caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em funcionário para atualizar a referência
            // com as atualizações
            cardapio = entidade;
        }

    }

    public List<Cardapio> listarTodos() {
        return cardapios;
    }

    public void excluir(Cardapio entidade) {
        cardapios.remove(entidade);
    }

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
