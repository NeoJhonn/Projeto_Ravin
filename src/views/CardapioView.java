package views;

import controllers.CardapioController;
import controllers.ProdutoController;
import enums.CategoriaCardapio;
import enums.Escolaridade;
import models.Cardapio;
import models.Produto;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CardapioView {

    public CardapioView() {

    }

    public static Cardapio adicionarCardapio(List<Produto> produtosCriados, AtomicInteger idCounter) {
        //adiciona um id dinâmico
        int id = idCounter.incrementAndGet();

        //Lista de Produtos do cardápio
        List<Produto> produtos = new ArrayList<Produto>();

        // Create a panel with GridLayout for the input fields
        JPanel panel = new JPanel(new GridLayout(6, 2));

        // Create labels and text fields for each input field
        JLabel label2 = new JLabel("Nome:");
        JTextField textField2 = new JTextField(10);

        JLabel label3 = new JLabel("Código:");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("Descrição:");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("Categoria do Cardápio:");
        CategoriaCardapio[] categorias = CategoriaCardapio.values();
        JComboBox<CategoriaCardapio> comboBox1 = new JComboBox<>(categorias);

        JLabel label6 = new JLabel("Ativo:");
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
            String nome = textField2.getText();
            String codigo = textField3.getText();
            String descricao = textField4.getText();
            CategoriaCardapio categoriaCardapio = (CategoriaCardapio) comboBox1.getSelectedItem();
            boolean ativo = comboBox2.getSelectedItem().equals("Sim");

            for (Produto p : produtosCriados) {
                if (String.valueOf(p.getTipoProduto()) == String.valueOf(categoriaCardapio)) {
                    produtos.add(p);
                }
            }

            // Criar o objeto
            cardapio = new Cardapio(
                    id,
                    null,
                    nome,
                    codigo,
                    descricao,
                    categoriaCardapio,
                    ativo,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    "admin",
                    "admin"
            );
        }

        return cardapio;
    }

    public static void operacaoCardapio(int opcao, CardapioController cardapioController,ProdutoController produtoController, AtomicInteger idCounter) {

        switch (opcao) {
            case 1:
                // Adicionar Cardapio
                Cardapio cardapio = CardapioView.adicionarCardapio(produtoController.listarTodos(), idCounter);

                try {
                    cardapioController.cadastrar(cardapio);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
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

    public static String montarMenuCardapios() {
        String subMenuGeral= MenuView.montarSubMenuGeral("Cardápios");

        StringBuilder builder = new StringBuilder();
        builder.append(subMenuGeral);
        builder.append("6 - Voltar \n");

        return builder.toString();
    }
}
