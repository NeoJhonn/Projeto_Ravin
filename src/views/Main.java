package views;

import controllers.*;
import models.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    // Controllers
    private static FuncionarioController funcionarioController = new FuncionarioController();
    private static ClienteController clienteController = new ClienteController();
    private static ProdutoController produtoController = new ProdutoController();
    private static CardapioController cardapioController = new CardapioController();
    private static MesaController mesaController = new MesaController();
    private static PedidoController pedidoController = new PedidoController();
    private static ComandaController comandaController = new ComandaController();
    private static AtomicInteger idCounter = new AtomicInteger();

    public static void main(String[] args) {
        //Menu
        boolean executando = true;
        int opcaoSelecionado = 0;

        while (executando) {
            opcaoSelecionado = Integer.parseInt(JOptionPane.showInputDialog(MenuView.montarMenuPrincipal()));
            switch (opcaoSelecionado) {
                case 1:
                    // Chamar menu funcionario
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, FuncionarioView.montarMenuFuncionarios()));
                    FuncionarioView.operacaoFuncionario(opcao, funcionarioController, idCounter);
                    break;
                case 2:
                    // Chamar menu cliente
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, ClienteView.montarMenuClientes()));
                    ClienteView.operacaoCliente(opcao, clienteController, idCounter);
                    break;
                case 3:
                    // Chamar menu produto
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, ProdutoView.montarMenuProdutos()));
                    ProdutoView.operacaoProduto(opcao, produtoController, idCounter);
                    break;
                case 4:
                    // Chamar menu cardapio
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, CardapioView.montarMenuCardapios()));
                    CardapioView.operacaoCardapio(opcao, cardapioController, produtoController, idCounter);
                    break;
                case 5:
                    // Chamar menu mesa
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, MesaView.montarMenuMesas()));
                    MesaView.operacaoMesa(opcao, mesaController, funcionarioController, idCounter);
                    break;
                case 6:
                    // Chamar menu pedido
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, ComandaView.montarMenuPedidos()));
                    ComandaView.operacaoPedido(opcao, pedidoController, idCounter);
                    break;
                case 7:
                    executando = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
                    break;
            }
        }
    }
}