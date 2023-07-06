package views;

import controllers.*;
import models.Cliente;
import models.Funcionario;
import models.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static views.ClienteView.*;
import static views.FuncionarioView.*;
import static views.ProdutoView.*;

public class MenuView extends JFrame {

    public static  String montarMenuPrincipal() {
        StringBuilder builder = new StringBuilder();
        builder.append("=========================RAVIN========================= \n");
        builder.append("1 - Funcionário \n");
        builder.append("2 - Cliente \n");
        builder.append("3 - Produto \n");
        builder.append("4 - Cardapio \n");
        builder.append("5 - Mesa \n");
        builder.append("6 - Pedido \n");
        builder.append("7 - Sair \n");

        return builder.toString();
    }

    public static String montarSubMenuGeral(String modulo) {
        StringBuilder builder = new StringBuilder();
        builder.append("========================Gestão de ");
        builder.append(modulo);
        builder.append("======================== \n");
        builder.append("1 - Cadastrar \n");
        builder.append("2 - Alterar \n");
        builder.append("3 - Excluir \n");
        builder.append("4 - Consultar \n");
        builder.append("5 - Listar todos \n");

        return builder.toString();
    }

    public static void menuPrincipalRavin(FuncionarioController funcionarioController, ClienteController clienteController, ProdutoController produtoController, CardapioController cardapioController, MesaController mesaController, PedidoController pedidoController, ComandaController comandaController, AtomicInteger idDinamico) {
        JFrame frame = new JFrame();
        frame.setTitle("Restaurante Ravin");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        // Centraliza a janela na tela
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Restaurante Ravin");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        String[] options = {"Funcionário", "Cliente", "Produto", "Cardápio", "Mesa", "Pedido"};

        for (String option : options) {
            JButton button = new JButton(option);
            JPopupMenu popupMenu = new JPopupMenu();
            dropdownFuncionario(options, option, popupMenu, button, toolbar, idDinamico, funcionarioController);
            dropdownCliente(options, option, popupMenu, button, toolbar, idDinamico, clienteController);
            dropdownProduto(options, option, popupMenu, button, toolbar, idDinamico, produtoController);

        }

        frame.add(toolbar, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void dropdownFuncionario(String[] options, String option, JPopupMenu popupMenu, JButton button, JToolBar toolbar, AtomicInteger idDinamico, FuncionarioController controller) {
            if(option == options[0]) {
                JMenuItem item1 = new JMenuItem("Cadastrar");
                JMenuItem item2 = new JMenuItem("Alterar");
                JMenuItem item3 = new JMenuItem("Excluir");
                JMenuItem item4 = new JMenuItem("Consultar");
                JMenuItem item5 = new JMenuItem("Listar Todos");
                JMenuItem item6 = new JMenuItem("Consultar Garços Disponíveis");
                popupMenu.add(item1);
                popupMenu.add(item2);
                popupMenu.add(item3);
                popupMenu.add(item4);
                popupMenu.add(item5);
                popupMenu.add(item6);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        popupMenu.show(button, 0, button.getHeight());
                    }
                });
                toolbar.add(button);


                item1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Adicionar Funcionario
                        Funcionario funcionario = adicionarFuncionario(idDinamico);

                        try {
                            controller.cadastrar(funcionario);
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(null, f.getMessage());
                        }
                    }
                });

                item2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Alterar Funcionario
                        List<Funcionario> funcionarios = controller.listarTodos();
                        int idFuncionarioAlterar = mostrarMenuIdAlterarFuncionario(funcionarios);
                        Funcionario funcionarioALterar = controller.consultar(idFuncionarioAlterar);

                        mostrarMenuAlterarFuncionario(funcionarioALterar);
                    }
                });

                item3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Excluir Funcionario
                        List<Funcionario> funcionarios = controller.listarTodos();
                        int id = mostrarMenuExcluirFuncionario(funcionarios);
                        controller.excluir(id);
                    }
                });

                item4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Consultar Funcionario
                        List<Funcionario> funcionarios = controller.listarTodos();
                        int id = mostrarMenuConsultarFuncionario(funcionarios);
                        Funcionario funcionarioBuscado = controller.consultar(id);
                        JOptionPane.showMessageDialog(null, funcionarioBuscado);
                    }
                });

                item5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Listar todos
                        List<Funcionario> funcionarios = controller.listarTodos();
                        listarFuncionarios(funcionarios);
                    }
                });

                item6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Consultar Garços Disponíveis
                        List<Funcionario> funcionarios = controller.listarGarconsDisponiveis();
                        listarGarconsDisponiveis(funcionarios);
                    }
                });
            }
    }

    public static void dropdownCliente(String[] options, String option, JPopupMenu popupMenu, JButton button, JToolBar toolbar, AtomicInteger idDinamico, ClienteController controller) {
        if(option == options[1]) {
            JMenuItem item1 = new JMenuItem("Cadastrar");
            JMenuItem item2 = new JMenuItem("Alterar");
            JMenuItem item3 = new JMenuItem("Excluir");
            JMenuItem item4 = new JMenuItem("Consultar");
            JMenuItem item5 = new JMenuItem("Listar Todos");
            popupMenu.add(item1);
            popupMenu.add(item2);
            popupMenu.add(item3);
            popupMenu.add(item4);
            popupMenu.add(item5);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    popupMenu.show(button, 0, button.getHeight());
                }
            });
            toolbar.add(button);


            item1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Adicionar Cliente
                    Cliente cliente = adicionarCliente(idDinamico);

                    try {
                        controller.cadastrar(cliente);
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }
                }
            });

            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Alterar Cliente
                    List<Cliente> clientes = controller.listarTodos();
                    int idClienteAlterar = mostrarMenuIdAlterarCliente(clientes);
                    Cliente clienteALterar = controller.consultar(idClienteAlterar);

                    mostrarMenuAlterarCliente(clienteALterar);
                }
            });

            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Excluir Cliente
                    List<Cliente> clientes = controller.listarTodos();
                    int id = mostrarMenuExcluirCliente(clientes);
                    controller.excluir(id);
                }
            });

            item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Cliente
                    List<Cliente> clientes = controller.listarTodos();
                    int id = mostrarMenuConsultarCliente(clientes);
                    Cliente clienteBuscado = controller.consultar(id);
                    JOptionPane.showMessageDialog(null, clienteBuscado);
                }
            });

            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar todos
                    List<Cliente> clientes = controller.listarTodos();
                    listarClientes(clientes);
                }
            });
        }
    }

    public static void dropdownProduto(String[] options, String option, JPopupMenu popupMenu, JButton button, JToolBar toolbar, AtomicInteger idDinamico, ProdutoController controller) {
        if(option == options[2]) {
            JMenuItem item1 = new JMenuItem("Cadastrar");
            JMenuItem item2 = new JMenuItem("Alterar");
            JMenuItem item3 = new JMenuItem("Excluir");
            JMenuItem item4 = new JMenuItem("Consultar");
            JMenuItem item5 = new JMenuItem("Listar Todos");
            popupMenu.add(item1);
            popupMenu.add(item2);
            popupMenu.add(item3);
            popupMenu.add(item4);
            popupMenu.add(item5);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    popupMenu.show(button, 0, button.getHeight());
                }
            });
            toolbar.add(button);


            item1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Adicionar Produto
                    Produto produto = adicionarProduto(idDinamico);

                    try {
                        controller.cadastrar(produto);
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }
                }
            });

            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Alterar Produto
                    List<Produto> produtos = controller.listarTodos();
                    int idProdutoAlterar = mostrarMenuIdAlterarProduto(produtos);
                    Produto produtoALterar = controller.consultar(idProdutoAlterar);

                    mostrarMenuAlterarProduto(produtoALterar);
                }
            });

            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Excluir Produto
                    List<Produto> produtos = controller.listarTodos();
                    int id = mostrarMenuExcluirProduto(produtos);
                    controller.excluir(id);
                }
            });

            item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Produto
                    List<Produto> produtos = controller.listarTodos();
                    int id = mostrarMenuConsultarProduto(produtos);
                    Produto produtoBuscado = controller.consultar(id);
                    JOptionPane.showMessageDialog(null, produtoBuscado);
                }
            });

            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar todos
                    List<Produto> produtos = controller.listarTodos();
                    listarProdutos(produtos);
                }
            });
        }
    }

}
