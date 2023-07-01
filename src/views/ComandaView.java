package views;

import controllers.PedidoController;
import enums.StatusComanda;
import enums.StatusPreparoPedido;
import models.Comanda;
import models.Pedido;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

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

    public static Pedido adicionarPedido() {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Create labels and components for each input field
        JLabel label1 = new JLabel("ID:");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Produto:");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Opção 1");
        comboBox1.addItem("Opção 2");

        JLabel label3 = new JLabel("Data e Hora de Solicitação:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Data e Hora de Início de Preparo:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Tempo de Preparo Restante:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Status de Preparo:");
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.addItem("Opção 1");
        comboBox2.addItem("Opção 2");

        JLabel label7 = new JLabel("Observação:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Quantidade:");
        JTextField textField8 = new JTextField(10);

        // Add labels and components to the panel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(comboBox1);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(comboBox2);
        panel.add(label7);
        panel.add(textField7);
        panel.add(label8);
        panel.add(textField8);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Criar Pedido", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        //
        Pedido pedido = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            int id = Integer.parseInt(textField1.getText());
            Object produto = comboBox1.getSelectedItem();
            Timestamp dataHoraSolicitacao = Timestamp.valueOf(textField3.getText());
            Timestamp dataHoraInicioPreparo = Timestamp.valueOf(textField4.getText());
            Timestamp tempoPreparoRestante = Timestamp.valueOf(textField5.getText());
            Enum statusPreparo = (Enum) comboBox2.getSelectedItem();
            String observacao = textField7.getText();
            int quantidade = Integer.parseInt(textField8.getText());

            //Criar objeto Pedido
            pedido = new Pedido(
                    id,
                    null,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    StatusPreparoPedido.SOLICITADO,
                    observacao,
                    quantidade,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }

        return pedido;
    }

    public static void operacaoPedido(int opcao, PedidoController pedidoController) {
        switch (opcao) {
            case 1:
                // Adicionar Pedido
                adicionarPedido();
                break;
            case 2:
                // Alterar Pedido
                break;
            case 3:
                // Excluir Pedido
                break;
            case 4:
                // Consultar Pedido
                break;
            case 5:
                // Listar Pedidos
                break;
            case 6:
                // Realizar pedido
                break;
            case 7:
                // Consultar Status do pedido
                break;
            case 8:
                // Listar Mesas Por Status
                break;
            case 9:
                // Fechar Comanda
                break;
            case 10:
                // Cancelar Pedido
                break;
            default:
                break;
        }
    }

    public static String montarMenuPedidos() {
        String subMenuGeral= Main.montarSubMenuGeral("Pedidos");

        StringBuilder builder = new StringBuilder();
        builder.append(subMenuGeral);
        builder.append("6 - Realizar pedido \n");
        builder.append("7 - Consultar Status do pedido \n");
        builder.append("8 - Listar Comandas Por Status \n");
        builder.append("9 - Fechar Comanda \n");
        builder.append("10 - Cancelar Pedido \n");
        builder.append("11 - Voltar ");

        return builder.toString();
    }
}
