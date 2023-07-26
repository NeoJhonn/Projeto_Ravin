package views;

import controllers.*;
import enums.StatusComanda;
import enums.StatusMesa;
import enums.StatusPreparo;
import enums.StatusPreparo;
import models.*;

import javax.swing.*;
import java.awt.*;
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



        JLabel label5 = new JLabel("Código:");
        JTextField textField5 = new JTextField(10);

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
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(comboBox4);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Criar Comanda do Cliente", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);



        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            Mesa mesa = mesaController.listarTodos().stream().filter(m -> m.getNome() == comboBox1.getSelectedItem()).findFirst().orElse(null);
            mesa.setStatusMesa(StatusMesa.Ocupada);


            String codigo = textField5.getText();
            String observacoes = textField6.getText();
            StatusComanda statusComanda = (StatusComanda) comboBox4.getSelectedItem();

            // verificar se é o mesmo cliente já tem uma comanda
            Comanda comandaCliente = comandaController.listarTodos().stream().filter(c -> c.getClienteId() == pedidoRecebido.getClienteId()).findFirst().orElse(null);

            if (comandaCliente == null) {
                // Criar objeto Comanda
                comanda = new Comanda(
                        id,
                        mesa.getId(),
                        pedidoRecebido.getClienteId(),
                        pedido.getId(),
                        codigo,
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

}
