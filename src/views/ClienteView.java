package views;

import controllers.ClienteController;
import models.Cliente;
import models.Funcionario;
import util.HandleDates;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteView {

    public ClienteView() {

    }

    public static Cliente adicionarCliente(AtomicInteger idDinamico) {
        //adiciona um id dinâmico
        int id = idDinamico.incrementAndGet();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(9, 2));

        // Create labels and text fields for each input field
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

    public static int mostrarMenuIdAlterarCliente(List<Cliente> clientes) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Clientes ==================== ");
        builder.append("\n");

        for (Cliente cliente: clientes) {
            builder.append("Id="+cliente.getId());
            builder.append("- ");
            builder.append(cliente.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Cliente que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    public static Cliente mostrarMenuAlterarCliente(Cliente clienteALterar) {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(9, 2));

        // Create labels and text fields for each input field
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

        // Settando os dados do cliente nos campos
        textField2.setText(clienteALterar.getNome());
        textField3.setText(clienteALterar.getTelefone());
        textField4.setText(clienteALterar.getEndereco());
        textField5.setText(clienteALterar.getCpf());
        textField6.setText(HandleDates.formatarData(clienteALterar.getDataNascimento()));

        String status = "Sim";
        if (clienteALterar.isAtivo() == false)
            status = "Não";
        comboBox1.setSelectedItem(status);

        textField8.setText(clienteALterar.getObservacoes());

        status = "Sim";
        if (clienteALterar.isVip() == false)
            status = "Não";
        comboBox2.setSelectedItem(status);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Alterar Cliente", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            clienteALterar.setNome(textField2.getText());
            clienteALterar.setTelefone(textField3.getText());
            clienteALterar.setEndereco(textField4.getText());
            clienteALterar.setCpf(textField5.getText());
            clienteALterar.setDataNascimento(HandleDates.criarDataAniverssario(textField6.getText()));
            clienteALterar.setAtivo(comboBox1.getSelectedItem().equals("Sim"));
            clienteALterar.setObservacoes(textField8.getText());
            clienteALterar.setVip(comboBox2.getSelectedItem().equals("Sim"));
        }

        return clienteALterar;
    }

    public static int mostrarMenuExcluirCliente(List<Cliente> clientes) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Cliente ==================== ");
        builder.append("\n");

        for (Cliente cliente: clientes) {
            builder.append("Id="+cliente.getId());
            builder.append("- ");
            builder.append(cliente.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Cliente que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuConsultarCliente(List<Cliente> clientes) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Clientes ==================== ");
        builder.append("\n");

        for (Cliente cliente: clientes) {
            builder.append("Id="+cliente.getId());
            builder.append("- ");
            builder.append(cliente.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Cliente que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static void listarClientes(List<Cliente> clientes) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Clientes ==================== ");
        builder.append("\n");

        for (Cliente cliente : clientes) {
            builder.append(cliente);
            builder.append("\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Clientes Cadastrados:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de funcionário no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        int option = JOptionPane.showOptionDialog(null, panel, "Clientes Cadastrados:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }
}
