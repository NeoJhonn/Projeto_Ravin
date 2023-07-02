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
import java.util.Date;
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
            String dataDemissao = textField14.getText();
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

    private static void listarGarconsDisponiveis(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Garçons Disponíveis ==================== ");
        builder.append("\n");

        for (Funcionario funcionario : funcionarios) {
            builder.append(funcionario);
            builder.append("\n");
        }


        JOptionPane.showMessageDialog(null, builder.toString());
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Funcionários ==================== ");
        builder.append("\n");

        for (Funcionario funcionario : funcionarios) {
            builder.append(funcionario);
            builder.append("\n");
        }

        JOptionPane.showMessageDialog(null, builder.toString());
    }

    private static int mostrarMenuConsultarFuncionario() {
        // TODO Auto-generated method stub
        return Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário que você deseja consultar"));
    }

    private static int mostrarMenuExcluirFuncionario() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário que você deseja excluir"));
    }

    private static int mostrarMenuIdAlterarFuncionario(List<Funcionario> funcionarios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Funcionários ==================== ");
        builder.append("\n");

        for (Funcionario funcionario: funcionarios) {
            builder.append(funcionario.getId());
            builder.append("-");
            builder.append(funcionario.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do funcinário que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    private static Funcionario mostrarMenuAlterarFuncionario(Funcionario funcionarioALterar) {
        funcionarioALterar.setNome(JOptionPane.showInputDialog("Digite o Nome do funcionário:", funcionarioALterar.getNome()));
        funcionarioALterar.setRg(JOptionPane.showInputDialog("Digite o RG do funcionário:", funcionarioALterar.getRg()));
        funcionarioALterar.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(JOptionPane.showInputDialog(
                "Digite o estado civíl do funcionario: \n [0 - Solteiro \n 1 - Casado \n 2 - Viúvo \n 3 - Divorciado \n 4 - Separado]",
                funcionarioALterar.getEstadoCivil()))]);
        funcionarioALterar.setCargo(Cargo.values()[Integer.parseInt(JOptionPane.showInputDialog(
                "Digite o cargo do funcionário: \n 0 - Faxineiro \n 1 - Garçom \n 2 - Cozinheiro \n 3 - Gerente",
                funcionarioALterar.getCargo()))]);
        funcionarioALterar.setEscolaridade(Escolaridade.values()[Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a escolaridade do funcionario: \n 0 - Fundamental \n 1 - Médio \n 2 - Superior ",
                funcionarioALterar.getEscolaridade()))]);
        funcionarioALterar.setPis(Integer.parseInt(JOptionPane.showInputDialog("Digite o PIS do funcionário", funcionarioALterar.getPis())));


        return funcionarioALterar;
    }

    public static String montarMenuFuncionarios() {
        String subMenuGeral= MenuView.montarSubMenuGeral("Funcionarios");

        StringBuilder builder = new StringBuilder();
        builder.append(subMenuGeral);
        builder.append("6 - Consultar Garços Disponíveis \n");
        builder.append("7 - voltar");

        return builder.toString();
    }

    public static void operacaoFuncionario(int opcao, FuncionarioController controller, AtomicInteger idDinamico) {
        Funcionario funcionario = null;
        List<Funcionario> funcionarios = null;
        int id = 0;

        switch (opcao) {
            case 1:
                // Adicionar Funcionario
                funcionario = adicionarFuncionario(idDinamico);

                try {
                    controller.cadastrar(funcionario);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                break;
            case 2:
                // Alterar Funcionario
                funcionarios = controller.listarTodos();
                int idFuncionarioAlterar = mostrarMenuIdAlterarFuncionario(funcionarios);
                Funcionario funcionarioALterar = controller.consultar(idFuncionarioAlterar);

                mostrarMenuAlterarFuncionario(funcionarioALterar);
                break;
            case 3:
                // Excluir Funcionario
                id = mostrarMenuExcluirFuncionario();
                controller.excluir(id);
                break;
            case 4:
                // Consultar Funcionario
                id = mostrarMenuConsultarFuncionario();
                Funcionario funcionarioBuscado = controller.consultar(id);
                JOptionPane.showMessageDialog(null, funcionarioBuscado);
                break;
            case 5:
                // Listar todos
                funcionarios = controller.listarTodos();
                listarFuncionarios(funcionarios);
                break;
            case 6:
                // Consultar Garços Disponíveis
                funcionarios = controller.listarGarconsDisponiveis();
                listarGarconsDisponiveis(funcionarios);
                break;
            default:
                break;
        }
    }
}
