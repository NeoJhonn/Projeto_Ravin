package views;

import controllers.CardapioController;
import controllers.ProdutoController;
import enums.CategoriaCardapio;
import enums.Escolaridade;
import models.Cardapio;
import models.Cliente;
import models.Produto;
import util.HandleDates;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CardapioView {

    public CardapioView() {

    }

    public static Cardapio adicionarCardapio(AtomicInteger idCounter) {
        //adiciona um id dinâmico
        int id = idCounter.incrementAndGet();

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
        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Cardápio", JOptionPane.OK_CANCEL_OPTION,
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

    public static Cardapio mostrarMenuAlterarCardapio(Cardapio cardapioAlterar) {
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

        // Settando os dados do cliente nos campos
        textField2.setText(cardapioAlterar.getNome());
        textField3.setText(cardapioAlterar.getCodigo());
        textField4.setText(cardapioAlterar.getDescricao());
        comboBox1.setSelectedItem(cardapioAlterar.getCategoriaCardapio());
        String status = "Sim";
        if (cardapioAlterar.isAtivo() == false)
            status = "Não";
        comboBox2.setSelectedItem(status);

        // Display the input dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Atualizar Cardápio", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Check if the user clicked "OK" (option == 0)
        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the values entered in the text fields and combo boxes
            cardapioAlterar.setNome(textField2.getText());
            cardapioAlterar.setCodigo(textField3.getText());
            cardapioAlterar.setDescricao(textField4.getText());
            cardapioAlterar.setCategoriaCardapio((CategoriaCardapio) comboBox1.getSelectedItem());
            cardapioAlterar.setAtivo(comboBox2.getSelectedItem().equals("Sim"));
            cardapioAlterar.setCriadoEM(new Timestamp(System.currentTimeMillis()));
            cardapioAlterar.setAlteradoEM(new Timestamp(System.currentTimeMillis()));
            cardapioAlterar.setCriadoPor("admin");
            cardapioAlterar.setAlteradoPor("admin");
        }


        return  cardapioAlterar;
    }

    public static void operacaoCardapio(int opcao, CardapioController cardapioController,ProdutoController produtoController, AtomicInteger idCounter) {

        switch (opcao) {
            case 1:
                // Adicionar Cardapio
                Cardapio cardapio = CardapioView.adicionarCardapio(idCounter);

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

    public static int mostrarMenuIdAlterarCardapio(List<Cardapio> cardapios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Cardápios ==================== ");
        builder.append("\n");

        for (Cardapio cardapio: cardapios) {
            builder.append("Id="+cardapio.getId());
            builder.append("- ");
            builder.append(cardapio.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Cardápio que você deseja alterar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder.toString()));
    }

    public static Cardapio mostrarMenuAlterarCliente(Cardapio cardapioALterar) {


        return cardapioALterar;
    }

    public static int mostrarMenuExcluirCardapio(List<Cardapio> cardapios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Cardápio ==================== ");
        builder.append("\n");

        for (Cardapio cardapio: cardapios) {
            builder.append("Id="+cardapio.getId());
            builder.append("- ");
            builder.append(cardapio.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Cardápio que você deseja excluir");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static int mostrarMenuConsultarCardapio(List<Cardapio> cardapios) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== Lista de Cardápios ==================== ");
        builder.append("\n");

        for (Cardapio cardapio: cardapios) {
            builder.append("Id="+cardapio.getId());
            builder.append("- ");
            builder.append(cardapio.getNome());
            builder.append("\n");
        }

        builder.append("Digite o id do Cardápio que você deseja consultar");

        return Integer.parseInt(JOptionPane.showInputDialog(builder));
    }

    public static void listarCardapios(List<Cardapio> cardapios, ProdutoController produtoController) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ==================== Cardápios ==================== ");
        builder.append("\n");

        for (Cardapio cardapio : cardapios) {
            builder.append(cardapio.toString(produtoController.listarProdutosCardapio(cardapio.getCategoriaCardapio()))+ "\n");
        }

        // Crie um painel com um layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crie um rótulo para a área de texto
        JLabel label = new JLabel("Cardápios Cadastrados:");

        // Crie uma área de texto com barras de rolagem
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicione o rótulo e a área de texto ao painel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Setar lista de cardápios no textArea
        textArea.setText(builder.toString());

        // Exiba o diálogo de entrada
        int option = JOptionPane.showOptionDialog(null, panel, "Cardápios Cadastrados:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }
}
