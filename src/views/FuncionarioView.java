package views;

import controllers.FuncionarioController;
import enums.Cargo;
import enums.Disponibilidade;
import enums.Escolaridade;
import enums.EstadoCivil;
import models.Funcionario;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FuncionarioView {
    public FuncionarioView() {

    }

    public static Funcionario adicionarFuncionario(AtomicInteger idDinamico) {
        //adiciona um id dinâmico
        int id = idDinamico.incrementAndGet();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(15, 2));

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

        JLabel label8 = new JLabel("RG:");
        JTextField textField8 = new JTextField(10);

        JLabel label9 = new JLabel("Estado Civil:");
        EstadoCivil[] ec = EstadoCivil.values();
        JComboBox<EstadoCivil> comboBox2 = new JComboBox<>(ec);

        JLabel label10 = new JLabel("Escolaridade:");
        Escolaridade[] ecl = Escolaridade.values();
        JComboBox<Escolaridade> comboBox3 = new JComboBox<>(ecl);

        JLabel label11 = new JLabel("Cargo:");
        Cargo[] cg = Cargo.values();
        JComboBox<Cargo> comboBox4 = new JComboBox<>(cg);

        JLabel label12 = new JLabel("PIS:");
        JTextField textField12 = new JTextField(10);

        JLabel label13 = new JLabel("Data de Admissão (dd/mm/aaaa):");
        JTextField textField13 = new JTextField(10);

        JLabel label15 = new JLabel("Disponibilidade:");
        Disponibilidade[] disp = Disponibilidade.values();
        JComboBox<Disponibilidade> comboBox5 = new JComboBox<>(disp);

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
        panel.add(label10);
        panel.add(comboBox3);
        panel.add(label11);
        panel.add(comboBox4);
        panel.add(label12);
        panel.add(textField12);
        panel.add(label13);
        panel.add(textField13);
        panel.add(label15);
        panel.add(comboBox5);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Funcionário", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Inicializar objeto Funcionário
        Funcionario funcionario = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            String nome = textField2.getText();
            String telefone = textField3.getText();
            String endereco = textField4.getText();
            String cpf = textField5.getText();
            String dataNascimento = textField6.getText();
            boolean ativo = comboBox1.getSelectedItem().equals("Sim");
            String rg = textField8.getText();
            EstadoCivil estadoCivil = (EstadoCivil) comboBox2.getSelectedItem();
            Escolaridade escolaridade = (Escolaridade) comboBox3.getSelectedItem();
            Cargo cargo = (Cargo) comboBox4.getSelectedItem();
            int pis = Integer.parseInt(textField12.getText());
            String dataAdmissao = textField13.getText();
            Disponibilidade disponibilidade = (Disponibilidade) comboBox5.getSelectedItem();

            //Criar um Funcionário
            funcionario = new Funcionario(
                    id,
                    nome,
                    telefone,
                    endereco,
                    cpf,
                    HandleDates.criarDataAniverssario(dataNascimento.replace('/', '-')),
                    ativo,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admim",
                    "admim",
                    rg,
                    estadoCivil,
                    escolaridade,
                    cargo,
                    pis,
                    HandleDates.criarDataAniverssario(dataAdmissao.replace('/', '-')),
                    null,
                    disponibilidade
            );
        }

        return funcionario;
    }

    public static void listarGarconsDisponiveis(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Garçons Disponíveis ==================== ");
        builder.append("\n");

        for (Funcionario funcionario : funcionarios) {
            builder.append("Id="+funcionario.getId());
            builder.append("- ");
            builder.append(funcionario.getNome());
            builder.append("\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Garçons Disponíveis:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de funcionário no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        int option = JOptionPane.showOptionDialog(null, panel, "Garçons Disponíveis:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }

    public static void listarFuncionarios(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Funcionários ==================== ");
        builder.append("\n");

        for (Funcionario funcionario : funcionarios) {
            builder.append(funcionario);
            builder.append("\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Funcionários Cadastrados:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de funcionário no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        int option = JOptionPane.showOptionDialog(null, panel, "Funcionários Cadastrados:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

    public static int mostrarMenuConsultarFuncionario(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Funcionários ==================== ");
        builder.append("\n");

        for (Funcionario funcionario: funcionarios) {
            builder.append("Id="+funcionario.getId());
            builder.append("- ");
            builder.append(funcionario.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do funcionário que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuExcluirFuncionario(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Funcionários ==================== ");
        builder.append("\n");

        for (Funcionario funcionario: funcionarios) {
            builder.append("Id="+funcionario.getId());
            builder.append("- ");
            builder.append(funcionario.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do funcionário que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuIdAlterarFuncionario(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Funcionários ==================== ");
        builder.append("\n");

        for (Funcionario funcionario: funcionarios) {
            builder.append("Id="+funcionario.getId());
            builder.append("- ");
            builder.append(funcionario.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do funcinário que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    public static Funcionario mostrarMenuAlterarFuncionario(Funcionario funcionarioALterar) {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(15, 2));

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

        JLabel label8 = new JLabel("RG:");
        JTextField textField8 = new JTextField(10);

        JLabel label9 = new JLabel("Estado Civil:");
        EstadoCivil[] ec = EstadoCivil.values();
        JComboBox<EstadoCivil> comboBox2 = new JComboBox<>(ec);

        JLabel label10 = new JLabel("Escolaridade:");
        Escolaridade[] ecl = Escolaridade.values();
        JComboBox<Escolaridade> comboBox3 = new JComboBox<>(ecl);

        JLabel label11 = new JLabel("Cargo:");
        Cargo[] cg = Cargo.values();
        JComboBox<Cargo> comboBox4 = new JComboBox<>(cg);

        JLabel label12 = new JLabel("PIS:");
        JTextField textField12 = new JTextField(10);

        JLabel label13 = new JLabel("Data de Admissão (dd/mm/aaaa):");
        JTextField textField13 = new JTextField(10);

        JLabel label14 = new JLabel("Data de Demissão (dd/mm/aaaa):");
        JTextField textField14 = new JTextField(10);

        JLabel label15 = new JLabel("Disponibilidade:");
        Disponibilidade[] disp = Disponibilidade.values();
        JComboBox<Disponibilidade> comboBox5 = new JComboBox<>(disp);

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
        panel.add(label10);
        panel.add(comboBox3);
        panel.add(label11);
        panel.add(comboBox4);
        panel.add(label12);
        panel.add(textField12);
        panel.add(label13);
        panel.add(textField13);
        panel.add(label14);
        panel.add(textField14);
        panel.add(label15);
        panel.add(comboBox5);

        // Settando os dados do funcionários nos campos
        textField2.setText(funcionarioALterar.getNome());
        textField3.setText(funcionarioALterar.getTelefone());
        textField4.setText(funcionarioALterar.getEndereco());
        textField5.setText(funcionarioALterar.getCpf());
        textField6.setText(HandleDates.formatarData(funcionarioALterar.getDataNascimento()));

        String status = "Sim";
        if (funcionarioALterar.isAtivo() == false)
            status = "Não";
        comboBox1.setSelectedItem(status);

        textField8.setText(funcionarioALterar.getRg());
        comboBox2.setSelectedItem(funcionarioALterar.getEstadoCivil());
        comboBox3.setSelectedItem(funcionarioALterar.getEscolaridade());
        comboBox4.setSelectedItem(funcionarioALterar.getCargo());
        textField12.setText(String.valueOf(funcionarioALterar.getPis()));
        textField13.setText(HandleDates.formatarData(funcionarioALterar.getDataAdmissao()));
        comboBox5.setSelectedItem(funcionarioALterar.getDisponibilidade());


        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Atualizar Cadastro do Funcionário", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            funcionarioALterar.setNome(textField2.getText());
            funcionarioALterar.setTelefone(textField3.getText());
            funcionarioALterar.setEndereco(textField4.getText());
            funcionarioALterar.setCpf(textField5.getText());
            funcionarioALterar.setDataNascimento(HandleDates.criarDataAniverssario(textField6.getText()));
            funcionarioALterar.setAtivo(comboBox1.getSelectedItem().equals("Sim"));
            funcionarioALterar.setRg(textField8.getText());
            funcionarioALterar.setEstadoCivil((EstadoCivil) comboBox2.getSelectedItem());
            funcionarioALterar.setEscolaridade((Escolaridade) comboBox3.getSelectedItem());
            funcionarioALterar.setCargo((Cargo) comboBox4.getSelectedItem());
            funcionarioALterar.setPis(Integer.parseInt(textField12.getText()));
            funcionarioALterar.setDataAdmissao(HandleDates.criarDataAniverssario(textField13.getText()));
            funcionarioALterar.setDataDemissao(HandleDates.criarDataAniverssario(textField14.getText()));
            funcionarioALterar.setDisponibilidade((Disponibilidade) comboBox5.getSelectedItem());
        }

        return funcionarioALterar;
    }

}
