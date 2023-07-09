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
        // Iniciar janela de gerenciamento do restaurante
        menuPrincipalRavin(funcionarioController,clienteController, produtoController, cardapioController, mesaController, pedidoController, comandaController, idCounter);

    }
}