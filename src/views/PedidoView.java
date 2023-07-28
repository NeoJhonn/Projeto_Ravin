package views;

import controllers.*;
import enums.StatusMesa;
import enums.StatusPreparo;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoView {

    public static Pedido adicionarPedido(AtomicInteger idDinamico, FuncionarioController funcionarioController, ClienteController clienteController, ProdutoController produtoController, MesaController mesaController) {
        Pedido pedido = null;

        // Verificando se existe funcionários, clientes, produtos e mesas cadastradas
        if (!funcionarioController.listarTodos().isEmpty() && !clienteController.listarTodos().isEmpty() &&
                !produtoController.listarTodos().isEmpty() && !mesaController.listarMesasDisponiveis().isEmpty()) {

            //adiciona um id dinâmico
            int id = idDinamico.incrementAndGet();

            // Create a panel with GridLayout for the input fields
            JPanel panel = new JPanel(new GridLayout(8, 2));

            // Create labels and components for each input field
            JLabel label1 = new JLabel("Selecione o Cliente:");
            String[] clientes = new String[clienteController.listarTodos().size()];
            for (int i=0; i < clientes.length; i++) {
                clientes[i] = clienteController.listarTodos().get(i).getNome();
            }
            JComboBox<String> comboBox1 = new JComboBox<>(clientes);

            JLabel label2 = new JLabel("Produto:");
            JComboBox<String> comboBox2 = new JComboBox<>();
            JLabel label5 = new JLabel("Tempo de Preparo(em minutos):");
            JTextField tempoPreparoField = new JTextField(10);
            tempoPreparoField.setEditable(false);
            for (int i = 0; i < produtoController.listarTodos().size(); i++) {
                comboBox2.addItem(produtoController.listarTodos().get(i).getNome());
            }
            Produto produtoSelecionado = produtoController.listarTodos().stream().filter(p -> p.getNome() == comboBox2.getSelectedItem()).findFirst().orElse(null);
            tempoPreparoField.setText(produtoSelecionado.getTempoPreparo());
            comboBox2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Produto produtoSelecionado = produtoController.listarTodos().stream().filter(p -> p.getNome() == comboBox2.getSelectedItem()).findFirst().orElse(null);
                    tempoPreparoField.setText(produtoSelecionado.getTempoPreparo());
                }
            });



            JLabel label6 = new JLabel("Status de Preparo:");
            StatusPreparo[] status = StatusPreparo.values();
            JComboBox<StatusPreparo> comboBox3 = new JComboBox<>(status);


            JLabel label7 = new JLabel("Observação:");
            JTextField textField7 = new JTextField(10);

            JLabel label8 = new JLabel("Quantidade:");
            JTextField textField8 = new JTextField(10);

            // Add labels and components to the panel
            panel.add(label1);
            panel.add(comboBox1);
            panel.add(label2);
            panel.add(comboBox2);
            panel.add(label5);
            panel.add(tempoPreparoField);
            panel.add(label6);
            panel.add(comboBox3);
            panel.add(label7);
            panel.add(textField7);
            panel.add(label8);
            panel.add(textField8);

            // Display the input dialog
            int option = JOptionPane.showOptionDialog(null, panel, "Criar Pedido", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            //


            // Check if the user clicked "OK" (option == 0)
            if (option == JOptionPane.OK_OPTION) {
                // Retrieve the values entered in the text fields and combo boxes
                Produto produto = produtoController.listarTodos().stream().filter(p -> p.getNome() == comboBox2.getSelectedItem()).findFirst().orElse(null);
                int clienteId = clienteController.listarTodos().stream().filter((c -> c.getNome() == comboBox1.getSelectedItem())).findFirst().orElse(null).getId();

                //Timestamp dataHoraSolicitacao = Timestamp.valueOf(textField3.getText());
                //Timestamp dataHoraInicioPreparo = Timestamp.valueOf(textField4.getText());
                long tempoPreparo = Long.parseLong(tempoPreparoField.getText());
                StatusPreparo statusPreparo = (StatusPreparo) comboBox3.getSelectedItem();
                String observacao = textField7.getText();

                int quantidade = 0;
                try {
                    quantidade = Integer.parseInt(textField8.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Digite uma Quantidade válida", null, JOptionPane.ERROR_MESSAGE);
                    adicionarPedido(idDinamico, funcionarioController, clienteController, produtoController, mesaController);
                }


                //Criar objeto Pedido
                pedido = new Pedido(
                        id,
                        produto,
                        clienteId,
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis() + tempoPreparo * 60 * 1000),//adiciona o tempo de preparo
                        statusPreparo,
                        observacao,
                        quantidade,
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis()),
                        "admin",
                        "admin"
                );
            }
        } else {
            JOptionPane.showMessageDialog(null,"Você deve cadastrar funcionários, clientes, produtos" +
                    "e mesas antes de realizar um pedido");
        }

        return pedido;
    }

    public static Pedido mostrarMenuAlterarPedido(Pedido pedidoAlterar, ProdutoController produtoController, ClienteController clienteController) {
            // Create a panel with GridLayout for the input fields
            JPanel panel = new JPanel(new GridLayout(8, 2));

            // Create labels and components for each input field
            JLabel label1 = new JLabel("Cliente:");
            String[] clientes = new String[1];
            clientes[0] = clienteController.listarTodos().stream().filter(c -> c.getId() == pedidoAlterar.getClienteId()).findFirst().orElse(null).getNome();
            JComboBox<String> comboBox1 = new JComboBox<>(clientes);

            JLabel label2 = new JLabel("Produto:");
            String[] produtos = new String[produtoController.listarTodos().size()];
            for (int i = 0; i < produtos.length; i++) {
                produtos[i] = produtoController.listarTodos().get(i).getNome();
            }
            JComboBox<String> comboBox2 = new JComboBox<>(produtos);

            JLabel label5 = new JLabel("Tempo de Preparo Restante:");
            JTextField textField5 = new JTextField(10);

            JLabel label6 = new JLabel("Status de Preparo:");
            StatusPreparo[] status = StatusPreparo.values();
            JComboBox<StatusPreparo> comboBox3 = new JComboBox<>(status);


            JLabel label7 = new JLabel("Observação:");
            JTextField textField7 = new JTextField(10);

            JLabel label8 = new JLabel("Quantidade:");
            JTextField textField8 = new JTextField(10);

            // Add labels and components to the panel
            panel.add(label1);
            panel.add(comboBox1);
            panel.add(label2);
            panel.add(comboBox2);
            panel.add(label5);
            panel.add(textField5);
            panel.add(label6);
            panel.add(comboBox3);
            panel.add(label7);
            panel.add(textField7);
            panel.add(label8);
            panel.add(textField8);

            // Settar valores
            comboBox2.setSelectedItem(pedidoAlterar.getProduto().getNome());
            textField5.setText(String.valueOf(pedidoAlterar.getTempoPreparoRestante()));
            comboBox3.setSelectedItem(pedidoAlterar.getStatusPreparo());
            textField7.setText(pedidoAlterar.getObservacao());
            textField8.setText(String.valueOf(pedidoAlterar.getQuantidade()));

            // Display the input dialog
            int option = JOptionPane.showOptionDialog(null, panel, "Atualizar Pedido", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            //


            // Check if the user clicked "OK" (option == 0)
            if (option == JOptionPane.OK_OPTION) {
                // Retrieve the values entered in the text fields and combo boxes
                Produto produto = produtoController.listarTodos().stream().filter(p -> p.getNome() == comboBox2.getSelectedItem()).findFirst().orElse(null);
                pedidoAlterar.setProduto(produto);
                pedidoAlterar.setTempoPreparoRestante(Timestamp.valueOf(textField5.getText()));
                pedidoAlterar.setStatusPreparo((StatusPreparo) comboBox3.getSelectedItem());
                pedidoAlterar.setObservacao(textField7.getText());
                pedidoAlterar.setQuantidade(Integer.parseInt(textField8.getText()));
            }

        return  pedidoAlterar;
    }

    public static String mostrarMenuIdAlterarPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja alterar");

        return JOptionPane.showInputDialog(builder.toString());
    }

    public static int mostrarMenuExcluirPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuConsultarPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static void listarPedidos(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido : pedidos) {
            builder.append(pedido + "\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Pedidos Realizados:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de Pedidos no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo
        JOptionPane.showOptionDialog(null, panel, "Pedidos Realizados:", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

    public static String mostrarMenuIdConsultarStatusPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja consultar o Status:");

        return JOptionPane.showInputDialog(null, builder.toString());
    }

    public static void mostrarStatusPedido(Pedido pedido,PedidoController pedidoController, ClienteController clienteController, ComandaController comandaController, MesaController mesaController) {
        Cliente cliente = null;
        Comanda comanda = null;
        Mesa mesa = null;
        // Verificar se o pedido esta pronto
         pedidoController.alterarStatusPedido(pedido);

        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Status do Pedido ==================== ");
        builder.append("\n");
        builder.append("Id= " + pedido.getId());
        comanda = comandaController.listarTodos().stream().filter(c -> c.getClienteId() == pedido.getClienteId()).findFirst().orElse(null);
        mesa = mesaController.consultar(comanda.getMesaId());
        builder.append(", Mesa= " + mesa.getNome());
        cliente = clienteController.consultar(pedido.getClienteId());
        builder.append(", Cliente= " + cliente.getNome());
        builder.append(", Produto= " + pedido.getProduto().getNome());
        builder.append(", Status do Pedido= " + pedido.getStatusPreparo());
        builder.append("\n");



        JOptionPane.showMessageDialog(null, builder.toString());
    }
}
