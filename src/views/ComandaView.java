package views;

import controllers.*;
import enums.StatusComanda;
import enums.StatusMesa;
import enums.StatusPreparo;
import enums.StatusPreparo;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComandaView {

    public ComandaView() {

    }

    public static Comanda adicionarComanda(AtomicInteger idDinamico, MesaController mesaController, Pedido pedidoRecebido, PedidoController pedidoController, ClienteController clienteController, ComandaController comandaController) {
        // Inicializar objeto Comanda
        Comanda comanda = null;

        //adiciona um id dinâmico
        int id = idDinamico.incrementAndGet();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(7, 2));

        // Create labels and components for each input field
        JLabel label2 = new JLabel("Selecione a Mesa:");
        JComboBox<String> comboBox1 = new JComboBox<>();

        // Verificar se o cliente já não esta numa mesa
        Mesa mesaCliente = null;
        for (Comanda com: comandaController.listarTodos()) {
            if (com.getClienteId() == pedidoRecebido.getClienteId()) {
                mesaCliente = mesaController.consultar(com.getMesaId());
                break;
            }
        }

        if (mesaCliente == null) {
            for (Mesa mesa : mesaController.listarTodos()) {
                comboBox1.addItem(mesa.getNome());
            }
        } else {
            comboBox1.addItem(mesaCliente.getNome());
        }

        JLabel label3 = new JLabel("Cliente:");
        JComboBox<String> comboBox2 = new JComboBox<>();
        Cliente cliente = clienteController.consultar(pedidoRecebido.getClienteId());
        comboBox2.addItem(cliente.getNome());

        JLabel label4 = new JLabel("Pedidos:");
        JComboBox<String> comboBox3 = new JComboBox<>();
        Pedido pedido =  pedidoController.listarTodos().stream().filter(p -> p.getProduto().getNome() == pedidoRecebido.getProduto().getNome()).findAny().orElse(null);
        comboBox3.addItem(pedido.getProduto().getNome());


        JLabel label6 = new JLabel("Observações:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Status da Comanda:");
        JComboBox<StatusComanda> comboBox4 = new JComboBox<>(StatusComanda.values());

        // Add labels and components to the panel
        panel.add(label2);
        panel.add(comboBox1);
        panel.add(label3);
        panel.add(comboBox2);
        panel.add(label4);
        panel.add(comboBox3);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(comboBox4);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Adcionar Pedido a uma Comanda", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);



        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            Mesa mesa = mesaController.listarTodos().stream().filter(m -> m.getNome() == comboBox1.getSelectedItem()).findFirst().orElse(null);
            mesa.setStatusMesa(StatusMesa.Ocupada);


            String observacoes = textField6.getText();
            StatusComanda statusComanda = (StatusComanda) comboBox4.getSelectedItem();

            // verificar se é o mesmo cliente já tem uma comanda
            Comanda comandaCliente = comandaController.listarTodos().stream().filter(c -> c.getClienteId() == pedidoRecebido.getClienteId()).findFirst().orElse(null);

            if (comandaCliente == null && mesa.getQuantidadeMaximaPessoas() >= 1) {
                // Verificar se há lugar disponível na mesa
                int qtdPesoas = mesa.getQuantidadeMaximaPessoas();
                qtdPesoas--;
                mesa.setQuantidadeMaximaPessoas(qtdPesoas);

                // Criar objeto Comanda
                comanda = new Comanda(
                        id,
                        mesa.getId(),
                        pedidoRecebido.getClienteId(),
                        "00"+id,
                        observacoes,
                        statusComanda,
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis()),
                        "admin",
                        "admin"
                );
            } else {
                comanda = comandaCliente;
            }
        }
        return comanda;
    }

    public static void listarComandasPorStatus(ComandaController comandaController) {
        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Criar um comboBox do status
        StatusComanda[] status = StatusComanda.values();
        JComboBox<StatusComanda> comboBox = new JComboBox<>(status);

        // Crie a área de texto
        JTextArea textArea = new JTextArea(10, 45);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione elementos ao painel
        panel.add(comboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        //Adicionar um evento de clique ao comboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegando o status do comboBox e listando as Comandas
                List<Comanda> comandas = comandaController.listarComandasPorEstatus((StatusComanda) comboBox.getSelectedItem());
                StringBuilder builder = new StringBuilder();

                builder.append(" ==================== Comandas Disponíveis por status ==================== ");
                builder.append("\n");

                for (Comanda comanda : comandas) {
                    builder.append(comanda + "\n");
                }

                // Setar lista de comandas no textArea
                textArea.setText(builder.toString());
            }
        });

        // Exiba o diálogo de entrada
        JOptionPane.showOptionDialog(null, panel, "Listar Comandas Por Status:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }

    public static void fecharComandaCliente(ComandaController comandaController, ClienteController clienteController, PedidoController pedidoController, MesaController mesaController) {

        JFrame frame = new JFrame("Exemplo de InputDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JDialog dialog = new JDialog(frame, "Comanda", true);
        dialog.setSize(500, 500); // Aumentei o tamanho da janela para acomodar o JTextArea maior
        dialog.setLocationRelativeTo(frame);


        JComboBox<String> clienteComboBox = new JComboBox<>();
        for (Comanda comanda: comandaController.listarTodos()) {
            clienteComboBox.addItem(String.valueOf(comanda.getClienteId()));
        }


        JLabel clienteLabel = new JLabel("Selecione o Cliente");

        JTextArea comandaTextArea = new JTextArea(18, 40);
        JScrollPane comandaScrollPane = new JScrollPane(comandaTextArea);
        JLabel comandaLabel = new JLabel("Resumo da Comanda");

        JButton fecharComandaButton = new JButton("Fechar Comanda");
        JButton pagarComandaButton = new JButton("Pagar Comanda");

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(clienteLabel, gbc);

        gbc.gridx = 1;
        panel.add(clienteComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(comandaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(comandaScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(fecharComandaButton, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(pagarComandaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 5, 5, 5);
        panel.add(okButton, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(cancelButton, gbc);

        // Adicionar evento de clique ao botão fechar comanda
        fecharComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar comanda
                try {
                    Cliente cliente = clienteController.consultar(Integer.parseInt((String) clienteComboBox.getSelectedItem()));
                    Comanda comanda = comandaController.listarTodos().stream().filter(c -> c.getClienteId() == cliente.getId()).findFirst().orElse(null);

                    if (comanda.getStatusComanda() == StatusComanda.Em_Aberto) {
                        comandaTextArea.setText(comandaController.fecharComanda(cliente, pedidoController, mesaController, comandaController));
                        // Settar que o cliente tem comanda fechada
                        cliente.setComandaFechada(true);
                        //clienteController.cadastrar(cliente);
                    } else {
                        JOptionPane.showMessageDialog(null, "A comanda para esse cliente já foi fechada ou paga!");

                    }

                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null, "Não há clientes com comanda a serem fechadas");
                }
            }
        });

        // Adicionar evento de clique ao botão pagar comanda
        pagarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pagar comanda

                try {

                    Cliente cliente = clienteController.consultar(Integer.parseInt((String) clienteComboBox.getSelectedItem()));
                    Comanda comanda = comandaController.listarTodos().stream().filter(c -> c.getClienteId() == cliente.getId()).findFirst().orElse(null);

                    if (comanda.getStatusComanda() == StatusComanda.Fechada ) {
                        pagamentoDialog(cliente.getId(), clienteController, pedidoController, comandaTextArea);
                        // Mudar o status da comanda para paga
                        comanda.setStatusComanda(StatusComanda.Paga);
                    } else {
                        if (comanda.getStatusComanda() == StatusComanda.Paga ) {
                            JOptionPane.showMessageDialog(null, "Essa comanda já foi paga!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Feche uma comanda antes de pagar!");
                        }
                    }


                } catch (Exception c){
                    JOptionPane.showMessageDialog(null, "Não há clientes com comanda a serem pagas!");
                }
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Fecha a janela de diálogo ao clicar em "Ok"
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Fecha a janela de diálogo ao clicar em "Cancel"
            }
        });

        dialog.add(panel);
        dialog.setVisible(true);
    }

    public static void pagamentoDialog(int clienteId, ClienteController clienteController, PedidoController pedidoController, JTextArea comandaTextArea) {
        // Somar todos os pedidos do CLiente
        double totalComanda = pedidoController.somarPedidosCliente(clienteController.consultar(clienteId));

        // Criação dos componentes
        JLabel label = new JLabel("Escolha a Opção de Pagamento:");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Dinheiro");
        comboBox.addItem("Cartão");
        JTextField valorField = new JTextField(2);
        JButton pagarComandaButton = new JButton("Pagar Comanda");


        // Espaço entre o JComboBox e o JTextField
        JPanel spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(2, 10));
        JPanel spacePanel2 = new JPanel();
        spacePanel2.setPreferredSize(new Dimension(2, 10));

        // Painel para agrupar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(comboBox);
        panel.add(spacePanel);
        valorField.setText(String.valueOf(totalComanda));
        panel.add(valorField);
        panel.add(spacePanel2);
        panel.add(pagarComandaButton);

        // Adicionar evento de clique ao combox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox.getSelectedItem() == "Cartão") {
                    valorField.setText(String.valueOf(totalComanda));
                    valorField.setEditable(false);

                } else {
                    valorField.setEditable(true);
                }

            }
        });

        // Adicionar evento de clique no botão pagarComanda
        pagarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double.parseDouble(valorField.getText());

                    if (Double.parseDouble(valorField.getText()) >= totalComanda) {
                        double troco = Double.parseDouble(valorField.getText()) - totalComanda;

                        StringBuilder builder = new StringBuilder();
                        builder.append(comandaTextArea.getText() + "\n" +
                            "Forma de Pagamento: " + comboBox.getSelectedItem() + "\n" +
                            "Troco (R$): " + troco + "\n" +
                            "Comanda Paga com sucesso!"
                        );

                        comandaTextArea.setText(builder.toString());

                        JOptionPane.showMessageDialog(null, "Comanda Paga com sucesso!");
                        // Fechar a dialog depois de pagar
                        JOptionPane.getRootFrame().dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Digite um valor maior ou igual ao total da Comanda!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Digite um valor válido(somente números)!");
                }
            }
        });



        // Exibir o JOptionPane
        JOptionPane.showOptionDialog(
                null,
                panel,
                "Opção de Pagamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{},
                null
        );
    }

}
