package views;

import controllers.ComandaController;
import controllers.FuncionarioController;
import controllers.MesaController;
import controllers.ProdutoController;
import enums.StatusMesa;
import enums.StatusPreparo;
import models.Funcionario;
import models.Mesa;
import models.Pedido;
import models.Produto;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoView {

    public static Pedido adicionarPedido(AtomicInteger idDinamico, ProdutoController produtoController) {
        //adiciona um id dinâmico
        int id = idDinamico.incrementAndGet();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Create labels and components for each input field
        JLabel label2 = new JLabel("Produto:");
        String[] produtos = new String[produtoController.listarTodos().size()];
        for (int i=0; i < produtos.length; i++) {
            produtos[i] = produtoController.listarTodos().get(i).getNome();
        }
        JComboBox<String> comboBox1 = new JComboBox<>(produtos);



        JLabel label3 = new JLabel("Data e Hora de Solicitação:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Data e Hora de Início de Preparo:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Tempo de Preparo Restante:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Status de Preparo:");
        StatusPreparo[] status = StatusPreparo.values();
        JComboBox<StatusPreparo> comboBox2 = new JComboBox<>(status);



        JLabel label7 = new JLabel("Observação:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Quantidade:");
        JTextField textField8 = new JTextField(10);

        // Add labels and components to the panel
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
            Produto produto = produtoController.listarTodos().stream().filter(p -> p.getNome() == comboBox1.getSelectedItem()).findFirst().orElse(null);
            //Timestamp dataHoraSolicitacao = Timestamp.valueOf(textField3.getText());
            //Timestamp dataHoraInicioPreparo = Timestamp.valueOf(textField4.getText());
            //Timestamp tempoPreparoRestante = Timestamp.valueOf(textField5.getText());
            StatusPreparo statusPreparo = (StatusPreparo) comboBox2.getSelectedItem();
            String observacao = textField7.getText();
            int quantidade = Integer.parseInt(textField8.getText());

            //Criar objeto Pedido
            pedido = new Pedido(
                    id,
                    produto,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    statusPreparo,
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

    public static Pedido mostrarMenuAlterarPedido(Pedido pedidoAlterar, ProdutoController produtoController) {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Create labels and components for each input field
        JLabel label2 = new JLabel("Produto:");
        String[] produtos = new String[produtoController.listarTodos().size()];
        for (int i=0; i < produtos.length; i++) {
            produtos[i] = produtoController.listarTodos().get(i).getNome();
        }
        JComboBox<String> comboBox1 = new JComboBox<>(produtos);



        JLabel label3 = new JLabel("Data e Hora de Solicitação:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Data e Hora de Início de Preparo:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Tempo de Preparo Restante:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Status de Preparo:");
        StatusPreparo[] status = StatusPreparo.values();
        JComboBox<StatusPreparo> comboBox2 = new JComboBox<>(status);



        JLabel label7 = new JLabel("Observação:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Quantidade:");
        JTextField textField8 = new JTextField(10);

        // Add labels and components to the panel
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

        // Settando os dados do Pedido nos campos


        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Criar Pedido", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        //
        Pedido pedido = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            Produto produto = produtoController.listarTodos().stream().filter(p -> p.getNome() == comboBox1.getSelectedItem()).findFirst().orElse(null);
            //Timestamp dataHoraSolicitacao = Timestamp.valueOf(textField3.getText());
            //Timestamp dataHoraInicioPreparo = Timestamp.valueOf(textField4.getText());
            //Timestamp tempoPreparoRestante = Timestamp.valueOf(textField5.getText());
            StatusPreparo statusPreparo = (StatusPreparo) comboBox2.getSelectedItem();
            String observacao = textField7.getText();
            int quantidade = Integer.parseInt(textField8.getText());

            //Criar objeto Pedido
            //pedido = new Pedido(
                   // id,
                   // produto,
                   // new Timestamp(System.currentTimeMillis()),
                   // new Timestamp(System.currentTimeMillis()),
                   // new Timestamp(System.currentTimeMillis()),
                   // statusPreparo,
                   // observacao,
                   // quantidade,
                   // new Timestamp(System.currentTimeMillis()),
                   // new Timestamp(System.currentTimeMillis()),
                   // "admin",
                    //"admin"
        }

        return  pedidoAlterar;
    }

    public static int mostrarMenuIdAlterarPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    public static int mostrarMenuExcluirPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuConsultarPedido(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido: pedidos) {
            builder.append("Id= " + pedido.getId());
            builder.append("\n");
        }

        builder.append("Digite o id do Pedido que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static void listarPedidos(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Lista de Pedidos ==================== ");
        builder.append("\n");

        for (Pedido pedido : pedidos) {
            builder.append(pedido + "\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Pedidos Realizados:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de Pedidos no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo
        JOptionPane.showOptionDialog(null, panel, "Pedidos Realizados:", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

    }
}
