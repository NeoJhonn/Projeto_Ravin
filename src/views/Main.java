package views;

import enums.*;
import models.*;
import controllers.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static FuncionarioController funcionarioController = new FuncionarioController();
    private static AtomicInteger idCounter = new AtomicInteger();

    public static void main(String[] args) {
        //Produto pdt = cadastrarProduto();
        //Pedido pd = criarPedido();
        //Mesa ms = cadastrarMesa();
        //Comanda cm = adicionarComanda();
        //Cardapio cd = adicionarCardapio();
        //Funcionario f = adicionarFuncionario();
        //Cliente c = adicionarCliente();
        //System.out.println(f.getNome());
       // System.out.println(c.getObservacoes());


        //Menu
        boolean executando = true;
        int opcaoSelecionado = 0;

        while (executando) {
            opcaoSelecionado = Integer.parseInt(JOptionPane.showInputDialog(montarMenuPrincipal()));
            switch (opcaoSelecionado) {
                case 1:
                    // Chamar menu funcionario
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, FuncionarioView.montarMenuFuncionarios()));
                    FuncionarioView.operacaoFuncionario(opcao, funcionarioController);
                    break;
                case 2:
                    // Chamar menu cliente
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, montarSubMenuGeral("Clientes")));
                    ClienteView.operacaoCliente(opcao);
                    break;
                case 3:
                    // Chamar menu produto
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, montarSubMenuGeral("Produtos")));
                    ProdutoView.operacaoProduto(opcao);
                    break;
                case 4:
                    // Chamar menu cardapio
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, montarSubMenuGeral("Cardápio")));
                    CardapioView.operacaoCardapio(opcao);
                    break;
                case 5:
                    // Chamar menu mesa
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, MesaView.montarMenuMesas()));
                    MesaView.operacaoMesa(opcao);
                    break;
                case 6:
                    // Chamar menu pedido
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null, PedidoView.montarMenuPedidos()));
                    PedidoView.operacaoPedido(opcao);
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

    public static  String montarMenuPrincipal() {
        StringBuilder builder = new StringBuilder();
        builder.append("=========================RAVIN========================= \n");
        builder.append("1 - Funcionário \n");
        builder.append("2 - Cliente \n");
        builder.append("3 - Produto \n");
        builder.append("4 - Cardapio \n");
        builder.append("5 - Mesa \n");
        builder.append("6 - Pedido \n");
        builder.append("7 - Sair \n");

        return builder.toString();
    }

    public static String montarSubMenuGeral(String modulo) {
        StringBuilder builder = new StringBuilder();
        builder.append("========================Gestão de ");
        builder.append(modulo);
        builder.append("======================== \n");
        builder.append("1 - Cadastrar \n");
        builder.append("2 - Alterar \n");
        builder.append("3 - Excluir \n");
        builder.append("4 - Consultar \n");
        builder.append("5 - Listar todos \n");

        return builder.toString();
    }




}