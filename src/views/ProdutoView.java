package views;

import enums.TipoProduto;
import models.Produto;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;

public class ProdutoView {

    public ProdutoView() {

    }

    public static Produto adicionarProduto() {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(10, 2));

        // Create labels and text fields for each input field
        JLabel label1 = new JLabel("ID:");
        JTextField textField1 = new JTextField(10);

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
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Opção 1");
        comboBox1.addItem("Opção 2");

        JLabel label10 = new JLabel("Ativo:");
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
            int id = Integer.parseInt(textField1.getText());
            String nome = textField2.getText();
            String descricao = textField3.getText();
            String codigo = textField4.getText();
            double precoCusto = Double.parseDouble(textField5.getText());
            double precoVenda = Double.parseDouble(textField6.getText());
            String tempoPreparo = textField7.getText();
            String observacoes = textField8.getText();
            String tipoProduto = (String) comboBox1.getSelectedItem();
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
                    TipoProduto.Lanche,
                    ativo,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }

        return produto;
    }

    public static void operacaoProduto(int opcao) {

        switch (opcao) {
            case 1:
                // Adicionar Produto
                adicionarProduto();
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
}
