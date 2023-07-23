package views;

import controllers.*;
import enums.CategoriaCardapio;
import enums.StatusMesa;
import models.Cardapio;
import models.Cliente;
import models.Funcionario;
import models.Mesa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MesaView {

    public MesaView() {

    }

    public static Mesa adicionarMesa(AtomicInteger idDinamico, FuncionarioController funcionarioController, ComandaController comandaController) {
        //adiciona um id dinâmico
        int id = idDinamico.incrementAndGet();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel label4 = new JLabel("Nome:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Código:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Número:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Quantidade Máxima de Pessoas:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Status da Mesa:");
        StatusMesa[] sm = StatusMesa.values();
        JComboBox<StatusMesa> comboBox3 = new JComboBox<>(sm);


        // Add labels and components to the panel
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
            String nome = textField4.getText();
            String codigo = textField5.getText();
            int numero = Integer.parseInt(textField6.getText());
            int quantidadeMaximaPessoas = Integer.parseInt(textField7.getText());
            StatusMesa statusMesa = (StatusMesa) comboBox3.getSelectedItem();

            // Criar Mesa
            mesa = new Mesa(
                    id,
                    null,
                    null,
                    nome,
                    codigo,
                    numero,
                    quantidadeMaximaPessoas,
                    statusMesa,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }


        return mesa;
    }

    public static Mesa mostrarMenuAlterarMesa(Mesa mesaAlterar, FuncionarioController funcionarioController, ComandaController comandaController) {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Create labels and components for each input field
        JLabel label2 = new JLabel("Funcionário:");
        String[] funcionarios = new String[funcionarioController.listarGarconsDisponiveis().size()];
        for (int i=0; i < funcionarios.length; i++) {
            funcionarios[i] = funcionarioController.listarGarconsDisponiveis().get(i).getNome();
        }
        JComboBox<String> comboBox1 = new JComboBox<>(funcionarios);


        JLabel label3 = new JLabel("Comandas:");
        String[] comandas = new String[comandaController.listarTodos().size()];
        for (int i=0; i < comandas.length; i++) {
            comandas[i] = String.valueOf(comandaController.listarTodos().get(i).getId());
        }
        JComboBox<String> comboBox2 = new JComboBox<>(comandas);

        JLabel label4 = new JLabel("Nome:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Código:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Número:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Quantidade Máxima de Pessoas:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Status da Mesa:");
        StatusMesa[] sm = StatusMesa.values();
        JComboBox<StatusMesa> comboBox3 = new JComboBox<>(sm);


        // Add labels and components to the panel
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

        // setando dados da mesa nos campos
        comboBox1.setSelectedItem(mesaAlterar.getFuncionario().getNome());

        //List<String> comandas = new ArrayList<>();
        //comandas.add((String) comboBox2.getSelectedItem());
        textField4.setText(mesaAlterar.getNome());
        textField5.setText(mesaAlterar.getCodigo());
        textField6.setText(String.valueOf(mesaAlterar.getNumero()));
        textField7.setText(String.valueOf(mesaAlterar.getQuantidadeMaximaPessoas()));
        comboBox3.setSelectedItem(mesaAlterar.getStatusMesa());


        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Atualizar Mesa", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);


        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            String funcionarioNome = (String) comboBox1.getSelectedItem();
            Funcionario funcionario = funcionarioController.listarGarconsDisponiveis().stream().filter(f -> f.getNome() == funcionarioNome).findFirst().orElse(null);
            mesaAlterar.setFuncionario(funcionario);
            //List<String> comandas = new ArrayList<>();
            //comandas.add((String) comboBox2.getSelectedItem());
            mesaAlterar.setNome(textField4.getText());
            mesaAlterar.setCodigo(textField5.getText());
            mesaAlterar.setNumero(Integer.parseInt(textField6.getText()));
            mesaAlterar.setQuantidadeMaximaPessoas(Integer.parseInt(textField7.getText()));
            mesaAlterar.setStatusMesa((StatusMesa) comboBox3.getSelectedItem());
            mesaAlterar.setAlteradoEM(new Timestamp(System.currentTimeMillis()));
            mesaAlterar.setCriadoEM(new Timestamp(System.currentTimeMillis()));
            mesaAlterar.setAlteradoPor("admin");
            mesaAlterar.setCriadoPor("admin");
        }

        return  mesaAlterar;
    }

    public static int mostrarMenuIdAlterarMesa(List<Mesa> mesas) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Mesas ==================== ");
        builder.append("\n");

        for (Mesa mesa: mesas) {
            builder.append("Id=" + mesa.getId());
            builder.append("- ");
            builder.append(mesa.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id da Mesa que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    public static int mostrarMenuExcluirMesa(List<Mesa> mesas) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Mesas ==================== ");
        builder.append("\n");

        for (Mesa mesa: mesas) {
            builder.append("Id=" + mesa.getId());
            builder.append("- ");
            builder.append(mesa.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id da Mesa que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuConsultarMesa(List<Mesa> mesas) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Mesas ==================== ");
        builder.append("\n");

        for (Mesa mesa: mesas) {
            builder.append("Id=" + mesa.getId());
            builder.append("- ");
            builder.append(mesa.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id da Mesa que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static void listarMesas(List<Mesa> mesas, MesaController controller) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Mesas ==================== ");
        builder.append("\n");

        for (Mesa mesa : mesas) {
            if (mesa.getFuncionario() == null && mesa.getCliente() == null) {
                mesa.setFuncionario(new Funcionario());
                mesa.setCliente(new Cliente());
                builder.append(mesa + "\n");
            }else {
                builder.append(mesa + "\n");
            }

        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Mesas Cadastradas:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de cardápios no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        int option = JOptionPane.showOptionDialog(null, panel, "Mesas Cadastradas:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

    public static void listarMesasDidponiveis(MesaController controller) {
        List<Mesa> mesasDisponiveis = controller.listarMesasDisponiveis();
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Mesas Disponíveis ==================== ");
        builder.append("\n");

        for (Mesa mesa : mesasDisponiveis) {
            if (mesa.getFuncionario() == null && mesa.getCliente() == null){
                mesa.setFuncionario(new Funcionario());
                mesa.setCliente(new Cliente());
            }
            builder.append(mesa + "\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Mesas Mesas Disponíveis:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de cardápios no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        JOptionPane.showOptionDialog(null, panel, "Mesas Disponíveis:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

    public static void mostrarMenuReservarMesa(MesaController mesaController, ClienteController clienteController, FuncionarioController funcionarioController) {
        List<Mesa> mesasDisponiveis = mesaController.listarMesasDisponiveis();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Create labels and components for each input field
        JLabel label1 = new JLabel("Cliente:");
        String[] clientes = new String[clienteController.listarTodos().size()];
        for (int i=0; i < clientes.length; i++) {
            clientes[i] = clienteController.listarTodos().get(i).getNome();
        }
        JComboBox<String> comboBox1 = new JComboBox<>(clientes);

        // Create labels and components for each input field
        JLabel label2 = new JLabel("Funcionário:");
        String[] funcionarios = new String[funcionarioController.listarGarconsDisponiveis().size()];
        for (int i=0; i < funcionarios.length; i++) {
            funcionarios[i] = funcionarioController.listarGarconsDisponiveis().get(i).getNome();
        }
        JComboBox<String> comboBox2 = new JComboBox<>(funcionarios);


        JLabel label3 = new JLabel("Mesas Disponíveis:");
        String[] mesasIds = new String[mesasDisponiveis.size()];
        for (int i=0; i < mesasIds.length; i++) {
            mesasIds[i] = String.valueOf(mesasDisponiveis.get(i).getId());
        }
        JComboBox<String> comboBox3 = new JComboBox<>(mesasIds);

        // Add labels and components to the panel
        panel.add(label1);
        panel.add(comboBox1);
        panel.add(label2);
        panel.add(comboBox2);
        panel.add(label3);
        panel.add(comboBox3);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Reserva de Mesa", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            Cliente cliente = clienteController.listarTodos().stream().filter(c -> c.getNome() == comboBox1.getSelectedItem()).findFirst().orElse(null);
            int mesaId = Integer.parseInt(String.valueOf(comboBox3.getSelectedItem()));
            Mesa mesa = mesasDisponiveis.stream().filter(m -> m.getId() == mesaId).findFirst().orElse(null);
            Funcionario garcom = funcionarioController.listarGarconsDisponiveis().stream().filter(g -> g.getNome() == comboBox2.getSelectedItem()).findFirst().orElse(null);

            boolean mesaReservada = false;
            for (Mesa mes: mesaController.listarTodos()) {
                if (mes.getCliente() != null && cliente.getNome() == mes.getCliente().getNome()) {
                    mesaReservada = true;
                }
            }
            // verificar se já uma reserva para o cliente selecionado
            if (mesaReservada) {
                JOptionPane.showMessageDialog(null, "Já uma reserva de mesa para este Cliente!");
            } else {
                // Verificar se há lugares disponíveis antes de reservar a mesa
                if (mesa.getQuantidadeMaximaPessoas() >= 1) {
                    int qtdPessoas = mesa.getQuantidadeMaximaPessoas();
                    mesaController.reservarMesa(cliente, mesa, garcom);
                    mesa.setQuantidadeMaximaPessoas(qtdPessoas--);
                } else {
                    JOptionPane.showMessageDialog(null, "Limite máximo de pessoas por mesa atingido, escolha outra mesa!");
                }
            }
        }
    }

    public static void listarMesasPorEstatus(MesaController mesaController) {
        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Criar um comboBox do status
        StatusMesa[] status = StatusMesa.values();
        JComboBox<StatusMesa> comboBox = new JComboBox<>(status);

        // Crie a área de texto
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione elementos ao painel
        panel.add(comboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        //Adicionar um evento de clique ao comboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegando o status do comboBox e listando as mesas
                List<Mesa> mesasDisponiveis = mesaController.listarMesasPorStatus((StatusMesa) comboBox.getSelectedItem());
                StringBuilder builder = new StringBuilder();

                builder.append(" ==================== Mesas Disponíveis por status ==================== ");
                builder.append("\n");

                for (Mesa mesa : mesasDisponiveis) {
                    if (mesa.getFuncionario() == null && mesa.getCliente() == null) {
                        mesa.setFuncionario(new Funcionario());
                        mesa.setCliente(new Cliente());
                        builder.append(mesa + "\n");
                    } else {
                        builder.append(mesa + "\n");
                    }
                }

                // Setar lista de cardápios no textArea
                textArea.setText(builder.toString());
            }
        });

        // Exiba o diálogo de entrada
        JOptionPane.showOptionDialog(null, panel, "Mesas Disponíveis Por Status:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }
}
