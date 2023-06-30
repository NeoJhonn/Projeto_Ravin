package views;

import enums.StatusMesa;
import models.Mesa;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MesaView {

    public MesaView() {

    }

    public static Mesa adicionarMesa() {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Create labels and components for each input field
        JLabel label1 = new JLabel("ID:");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Funcionário:");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Opção 1");
        comboBox1.addItem("Opção 2");

        JLabel label3 = new JLabel("Comandas:");
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.addItem("Opção 1");
        comboBox2.addItem("Opção 2");

        JLabel label4 = new JLabel("Nome:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Código:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Número:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Quantidade Máxima de Pessoas:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Status da Mesa:");
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.addItem("Opção 1");
        comboBox3.addItem("Opção 2");

        // Add labels and components to the panel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(comboBox1);
        panel.add(label3);
        panel.add(comboBox2);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(label8);
        panel.add(comboBox3);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Mesa", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Inicializar objeto Mesa
        Mesa mesa = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            int id = Integer.parseInt(textField1.getText());
            String funcionario = (String) comboBox1.getSelectedItem();
            List<String> comandas = new ArrayList<>();
            comandas.add((String) comboBox2.getSelectedItem());
            String nome = textField4.getText();
            String codigo = textField5.getText();
            int numero = Integer.parseInt(textField6.getText());
            int quantidadeMaximaPessoas = Integer.parseInt(textField7.getText());
            String statusMesa = (String) comboBox3.getSelectedItem();

            // Criar Mesa
            mesa = new Mesa(
                    id,
                    null,
                    null,
                    nome,
                    codigo,
                    numero,
                    quantidadeMaximaPessoas,
                    StatusMesa.Livre,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }


        return mesa;
    }

    public static void operacaoMesa(int opcao) {

        switch (opcao) {
            case 1:
                // Adicionar Mesa
                MesaView.adicionarMesa();
                break;
            case 2:
                // Alterar Mesa
                break;
            case 3:
                // Excluir Mesa
                break;
            case 4:
                // Consultar Mesa
                break;
            case 5:
                // Listar Mesas
                break;
            case 6:
                // Consultar Mesas Disponíveis
                break;
            case 7:
                // Reservar Mesa
                break;
            case 8:
                // Listar Mesas Por Status
                break;
            default:
                break;
        }
    }

    public static String montarMenuMesas() {
        String subMenuGeral= Main.montarSubMenuGeral("Mesas");

        StringBuilder builder = new StringBuilder();
        builder.append(subMenuGeral);
        builder.append("6 - Consultar Mesas Disponíveis \n");
        builder.append("7 - Reservar Mesa \n");
        builder.append("8 - Listar Mesas Por Status \n");
        builder.append("9 - Voltar \n");

        return builder.toString();
    }
}
