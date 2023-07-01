package views;

import controllers.ClienteController;
import models.Cliente;
import util.HandleDates;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;

import static views.FuncionarioView.adicionarFuncionario;

public class ClienteView {

    public ClienteView() {

    }

    public static void operacaoCliente(int opcao, ClienteController controller) {
        Cliente cliente = null;
        List<Cliente> clientes = null;
        int id = 0;

        switch (opcao) {
            case 1:
                // Adicionar Cliente
                cliente = adicionarCliente();

                try {
                    controller.cadastrar(cliente);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
            case 2:
                // Alterar Cliente
                break;
            case 3:
                // Excluir Cliente
                break;
            case 4:
                // Consultar Cliente
                break;
            case 5:
                // Listar todos
                break;
            default:
                break;
        }
    }

    public static Cliente adicionarCliente() {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(9, 2));

        // Create labels and text fields for each input field
        JLabel label1 = new JLabel("ID:");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Nome:");
        JTextField textField2 = new JTextField(10);

        JLabel label3 = new JLabel("Telefone:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Endereço:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("CPF:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Data de Nascimento (dd/mm/aaaa):");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Ativo:");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Sim");
        comboBox1.addItem("Não");

        JLabel label8 = new JLabel("Observações:");
        JTextField textField8 = new JTextField(10);

        JLabel label9 = new JLabel("VIP:");
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.addItem("Sim");
        comboBox2.addItem("Não");

        // Add labels and text fields to the panel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(comboBox1);
        panel.add(label8);
        panel.add(textField8);
        panel.add(label9);
        panel.add(comboBox2);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Cliente", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Inicializar objeto Cliente
        Cliente cliente = null;
        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            int id = Integer.parseInt(textField1.getText());
            String nome = textField2.getText();
            String telefone = textField3.getText();
            String endereco = textField4.getText();
            String cpf = textField5.getText();
            String dataNascimento = textField6.getText();
            boolean ativo = comboBox1.getSelectedItem().equals("Sim");
            String observacoes = textField8.getText();
            boolean vip = comboBox2.getSelectedItem().equals("Sim");

            cliente = new Cliente(
                    id,
                    nome,
                    telefone,
                    endereco,
                    cpf,
                    HandleDates.criarDataAniverssario(dataNascimento),
                    ativo,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin",
                    observacoes,
                    vip
            );
        }

        return cliente;
    }
}
