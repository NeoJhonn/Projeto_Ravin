package controllers;

import enums.StatusComanda;
import models.Cliente;
import models.Comanda;
import models.Mesa;
import models.Pedido;
import repositories.ComandaRepository;

import java.util.ArrayList;
import java.util.List;

public class ComandaController {

    private ComandaRepository repository;

    public ComandaController() {

        repository = new ComandaRepository();
    }

    public void cadastrar(Comanda entidade) {
        if (!entidade.equals(null)) {
            repository.salvar(entidade);
        }
    }

    public void alterar(Comanda entidade) {
        // REGRAS DE NEGÓCIO
        repository.salvar(entidade);
    }

    public void excluir(int id) {
        Comanda comandaBuscada = repository.buscarPorId(id);

        if (comandaBuscada != null) {
            repository.excluir(comandaBuscada);
        }
    }

    public Comanda consultar(int id) {

        return repository.buscarPorId(id);
    }

    public List<Comanda> listarTodos() {

        return repository.listarTodos();
    }

    public List<Comanda> listarComandasPorEstatus(StatusComanda status) {
        List<Comanda> comandasPorStatus = repository.listarTodos().stream()
                .filter(c -> c.getStatusComanda() == status).toList();

        return comandasPorStatus;
    }

    public String fecharComanda(Cliente cliente, PedidoController pedidoController, MesaController mesaController) {
        Comanda comanda = listarTodos().stream().filter(c -> c.getClienteId() == cliente.getId()).findFirst().orElse(null);
        Mesa mesa = mesaController.consultar(comanda.getMesaId());

        int quantidade = 1;

        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Ravin Restaurante LTDA ==================== "+"\n");
        builder.append("  "+"\n");
        builder.append("Cliente: "+cliente.getNome()+" - Mesa: "+ mesa.getNome() + " - Comanda: " + comanda.getCodigo() +"\n");
        builder.append(" ======================= Items Consumidos ======================="+"\n");



            for (Pedido pedido: pedidoController.listarTodos()) {
                if (builder.toString().contains(pedido.getProduto().getNome())) {
                    quantidade++;
                }
                if (comanda.getClienteId() == pedido.getClienteId()) {
                    builder.append("QTD: "+ pedido.getQuantidade()+ " - Item: " + pedido.getProduto().getNome() +" --->  Valor Unitário: R$ " + pedido.getProduto().getPrecoVenda() +"\n");
                }


            }

        builder.append(" ================================================================" + "\n");
        builder.append("Total(R$): " + pedidoController.somarPedidosCliente(cliente) + "0");


        return builder.toString();
    }

    public String pagarComanda() {


        return "";
    }



}
