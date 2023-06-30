package controllers;

import models.Cardapio;
import models.Cliente;
import repositories.CardapioRepository;
import util.UtilitarioData;

import java.util.List;

public class CardapioController {

    private CardapioRepository repository;

    public CardapioController() {

        repository = new CardapioRepository();
    }

    public void cadastrar(Cardapio entidade) {
        repository.salvar(entidade);
    }

    public void alterar(Cardapio entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Cardapio cardapioBuscado = repository.buscarPorId(id);

        if (cardapioBuscado != null) {
            repository.excluir(cardapioBuscado);
        }
    }

    public Cardapio consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Cardapio> listarTodos() {

        return repository.listarTodos();
    }
}
