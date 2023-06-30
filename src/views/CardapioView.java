package views;

import enums.CategoriaCardapio;
import models.Cardapio;
import models.Produto;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;

public class CardapioView {

    public CardapioView() {

    }

    public static Cardapio adicionarCardapio(List<Produto> produtos) {
        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(6, 2));

        // Create labels and text fields for each input field
        JLabel label1 = new JLabel("ID:");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Nome:");
        JTextField textField2 = new JTextField(10);

        JLabel label3 = new JLabel("Código:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Descrição:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Categoria do Cardápio:");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Opção 1");
        comboBox1.addItem("Opção 2");

        JLabel label6 = new JLabel("Ativo:");
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
        panel.add(comboBox1);
        panel.add(label6);
        panel.add(comboBox2);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Carápio", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Inicializar Objeto Cardapio
        Cardapio cardapio = null;

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            int id = Integer.parseInt(textField1.getText());
            String nome = textField2.getText();
            String codigo = textField3.getText();
            String descricao = textField4.getText();
            String categoriaCardapio = (String) comboBox1.getSelectedItem();
            boolean ativo = comboBox2.getSelectedItem().equals("Sim");

            // Criar o objeto
            cardapio = new Cardapio(
                    id,
                    null,
                    nome,
                    codigo,
                    descricao,
                    CategoriaCardapio.Lanches,
                    ativo,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }

        return cardapio;
    }

    public static void operacaoCardapio(int opcao) {

        switch (opcao) {
            case 1:
                // Adicionar Cardapio
                CardapioView.adicionarCardapio(null);
                break;
            case 2:
                // Alterar Cardapio
                break;
            case 3:
                // Excluir Cardapio
                break;
            case 4:
                // Consultar Cardapio
                break;
            case 5:
                // Listar Cardapios
                break;
            default:
                break;
        }
    }
}
