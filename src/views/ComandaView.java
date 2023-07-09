package views;

import controllers.FuncionarioController;
import controllers.PedidoController;
import controllers.ProdutoController;
import enums.StatusComanda;
import enums.StatusPreparo;
import enums.StatusPreparo;
import models.Comanda;
import models.Pedido;
import models.Produto;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComandaView {

    public ComandaView() {

    }

    public static Comanda adicionarComanda() {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(7, 2));

        // Create labels and components for each input field
        JLabel label1 = new JLabel("ID:");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Mesa:");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Opção 1");
        comboBox1.addItem("Opção 2");

        JLabel label3 = new JLabel("Cliente:");
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.addItem("Opção 1");
        comboBox2.addItem("Opção 2");

        JLabel label4 = new JLabel("Pedidos:");
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.addItem("Opção 1");
        comboBox3.addItem("Opção 2");

        JLabel label5 = new JLabel("Código:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Observações:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Status da Comanda:");
        JComboBox<String> comboBox4 = new JComboBox<>();
        comboBox4.addItem("Opção 1");
        comboBox4.addItem("Opção 2");

        // Add labels and components to the panel
        panel.add(label1);
        panel.add(textField1);
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
        int option = JOptionPane.showOptionDialog(null, panel, "Criar Comanda", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Inicializar objeto Comanda
        Comanda comanda = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            int id = Integer.parseInt(textField1.getText());
            Object mesa = comboBox1.getSelectedItem();
            Object cliente = comboBox2.getSelectedItem();
            List<Pedido> pedidos = Arrays.asList((Pedido) comboBox3.getSelectedItem());
            String codigo = textField5.getText();
            String observacoes = textField6.getText();
            Enum statusComanda = (Enum) comboBox4.getSelectedItem();

            // Criar objeto Comanda
            comanda = new Comanda(
                    id,
                    null,
                    null,
                    null,
                    codigo,
                    observacoes,
                    StatusComanda.Em_Aberto,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }



        return comanda;
    }

}
