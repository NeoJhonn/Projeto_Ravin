package views;

import controllers.ProdutoController;
import enums.EstadoCivil;
import enums.TipoProduto;
import models.Cliente;
import models.Funcionario;
import models.Produto;
import util.HandleDates;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdutoView {

    public ProdutoView() {

    }

    public static Produto adicionarProduto(AtomicInteger idDinamico) {
        //adiciona um id dinâmico
        int id = idDinamico.incrementAndGet();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(10, 2));

        // Create labels and text fields for each input field
        JLabel label2 = new JLabel("Nome:");
        JTextField textField2 = new JTextField(10);

        JLabel label3 = new JLabel("Descrição:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Código:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Preço de Custo:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Preço de Venda:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Tempo de Preparo:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Observações:");
        JTextField textField8 = new JTextField(10);

        JLabel label9 = new JLabel("Tipo de Produto:");
        TipoProduto[] tp = TipoProduto.values();
        JComboBox<TipoProduto> comboBox1 = new JComboBox<>(tp);

        JLabel label10 = new JLabel("Ativo:");
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
        panel.add(textField7);
        panel.add(label8);
        panel.add(textField8);
        panel.add(label9);
        panel.add(comboBox1);
        panel.add(label10);
        panel.add(comboBox2);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Produto", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Inicializar objeto Produto
        Produto produto = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            String nome = textField2.getText();
            String descricao = textField3.getText();
            String codigo = textField4.getText();
            double precoCusto = Double.parseDouble(textField5.getText());
            double precoVenda = Double.parseDouble(textField6.getText());
            String tempoPreparo = textField7.getText();
            String observacoes = textField8.getText();
            TipoProduto tipoProduto = (TipoProduto) comboBox1.getSelectedItem();
            boolean ativo = comboBox2.getSelectedItem().equals("Sim");

            // Criar um Produto
            produto = new Produto(
                    id,
                    nome,
                    descricao,
                    codigo,
                    precoCusto,
                    precoVenda,
                    tempoPreparo,
                    observacoes,
                    tipoProduto,
                    ativo,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }

        return produto;
    }

    public static void operacaoProduto(int opcao, ProdutoController controller, AtomicInteger idCounter) {
        Produto produto = null;
        List<Produto> Produto = null;
        int id = 0;

        switch (opcao) {
            case 1:
                // Adicionar Produto
                produto = adicionarProduto(idCounter);

                try {
                    controller.cadastrar(produto);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
            case 2:
                // Alterar Produto
                break;
            case 3:
                // Excluir Produto
                break;
            case 4:
                // Consultar Produto
                break;
            case 5:
                // Listar Produtos
                break;
            default:
                break;
        }
    }

    public static String montarMenuProdutos() {
        String subMenuGeral= MenuView.montarSubMenuGeral("Produtos");

        StringBuilder builder = new StringBuilder();
        builder.append(subMenuGeral);
        builder.append("6 - Voltar \n");

        return builder.toString();
    }

    public static int mostrarMenuIdAlterarProduto(List<Produto> produtos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Produtos ==================== ");
        builder.append("\n");

        for (Produto produto: produtos) {
            builder.append("Id="+produto.getId());
            builder.append("- ");
            builder.append(produto.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Produto que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    public static Produto mostrarMenuAlterarProduto(Produto produtoALterar) {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(10, 2));

        // Create labels and text fields for each input field
        JLabel label2 = new JLabel("Nome:");
        JTextField textField2 = new JTextField(10);

        JLabel label3 = new JLabel("Descrição:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Código:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Preço de Custo:");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("Preço de Venda:");
        JTextField textField6 = new JTextField(10);

        JLabel label7 = new JLabel("Tempo de Preparo:");
        JTextField textField7 = new JTextField(10);

        JLabel label8 = new JLabel("Observações:");
        JTextField textField8 = new JTextField(10);

        JLabel label9 = new JLabel("Tipo de Produto:");
        TipoProduto[] tp = TipoProduto.values();
        JComboBox<TipoProduto> comboBox1 = new JComboBox<>(tp);

        JLabel label10 = new JLabel("Ativo:");
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
        panel.add(textField7);
        panel.add(label8);
        panel.add(textField8);
        panel.add(label9);
        panel.add(comboBox1);
        panel.add(label10);
        panel.add(comboBox2);

        // Settando os dados do cliente nos campos
        textField2.setText(produtoALterar.getNome());
        textField3.setText(produtoALterar.getDescricao());
        textField4.setText(produtoALterar.getCodigo());
        textField5.setText(String.valueOf(produtoALterar.getPrecoCusto()));
        textField6.setText(String.valueOf(produtoALterar.getPrecoVenda()));
        textField7.setText(produtoALterar.getTempoPreparo());
        textField8.setText(produtoALterar.getObservacoes());
        comboBox1.setSelectedItem(produtoALterar.getTipoProduto());
        String status = "Sim";
        if (produtoALterar.isAtivo() == false)
            status = "Não";
        comboBox2.setSelectedItem(status);



        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);


        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            produtoALterar.setNome(textField2.getText());
            produtoALterar.setDescricao(textField3.getText());
            produtoALterar.setCodigo(textField4.getText());
            produtoALterar.setPrecoCusto(Double.parseDouble(textField5.getText()));
            produtoALterar.setPrecoVenda(Double.parseDouble(textField6.getText()));
            produtoALterar.setTempoPreparo(textField7.getText());
            produtoALterar.setObservacoes(textField8.getText());
            produtoALterar.setTipoProduto((TipoProduto) comboBox1.getSelectedItem());
            produtoALterar.setAtivo(comboBox2.getSelectedItem().equals("Sim"));
        }
        return produtoALterar;
    }

    public static int mostrarMenuExcluirProduto(List<Produto> produtos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Produtos ==================== ");
        builder.append("\n");

        for (Produto produto: produtos) {
            builder.append("Id="+produto.getId());
            builder.append("- ");
            builder.append(produto.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Produto que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuConsultarProduto(List<Produto> produtos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Produtos ==================== ");
        builder.append("\n");

        for (Produto produto: produtos) {
            builder.append("Id="+produto.getId());
            builder.append("- ");
            builder.append(produto.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Produto que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static void listarProdutos(List<Produto> produtos) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Produtos ==================== ");
        builder.append("\n");

        for (Produto produto : produtos) {
            builder.append(produto);
            builder.append("\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Produtos Cadastrados:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de funcionário no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        int option = JOptionPane.showOptionDialog(null, panel, "Produtos Cadastrados:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

}
