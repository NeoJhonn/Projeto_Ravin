package views;

import controllers.*;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

import static views.MenuView.menuPrincipalRavin;

public class Main extends JFrame {

    // Controllers
    private static FuncionarioController funcionarioController = new FuncionarioController();
    private static ClienteController clienteController = new ClienteController();
    private static ProdutoController produtoController = new ProdutoController();
    private static CardapioController cardapioController = new CardapioController();
    private static MesaController mesaController = new MesaController();
    private static PedidoController pedidoController = new PedidoController();
    private static ComandaController comandaController = new ComandaController();
    // Contador para os ID
    private static AtomicInteger idCounter = new AtomicInteger();

    public static void main(String[] args) {
        menuPrincipalRavin(funcionarioController,clienteController, produtoController, cardapioController, mesaController, pedidoController, comandaController, idCounter);



        //Menu
        boolean executando = true;
        int opcaoSelecionado = 0;

        while (executando) {
            opcaoSelecionado = Integer.parseInt(JOptionPane.showInputDialog(MenuView.montarMenuPrincipal()));

            switch (opcaoSelecionado) {
                case 1:

                    int opcao =0;
                    break;
                case 2:

                    break;
                case 3:
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