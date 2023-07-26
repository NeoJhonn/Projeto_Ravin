package views;

import controllers.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static views.CardapioView.*;
import static views.ClienteView.*;
import static views.FuncionarioView.*;
import static views.MesaView.*;
import static views.PedidoView.*;
import static views.ProdutoView.*;

public class MenuView extends JFrame {

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

        // Montar a toolbar com os dropdowns
        for (String option : options) {
            JButton button = new JButton(option);
            JPopupMenu popupMenu = new JPopupMenu();
            dropdownFuncionario(options, option, popupMenu, button, toolbar, idDinamico, funcionarioController);
            dropdownCliente(options, option, popupMenu, button, toolbar, idDinamico, clienteController);
            dropdownProduto(options, option, popupMenu, button, toolbar, idDinamico, produtoController);
            dropdownCardapio(options, option, popupMenu, button, toolbar, idDinamico, cardapioController, produtoController);
            dropdownMesa(options, option, popupMenu, button, toolbar, idDinamico, mesaController, comandaController, funcionarioController, clienteController);
            dropdownPedido(options, option, popupMenu, button, toolbar, idDinamico, pedidoController, comandaController, produtoController, pedidoController, clienteController, funcionarioController, mesaController);
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

                        if (funcionario != null)
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

                    if (cliente != null)
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

                    if (produto != null)
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

    public static void dropdownCardapio(String[] options, String option, JPopupMenu popupMenu, JButton button, JToolBar toolbar, AtomicInteger idDinamico, CardapioController controller, ProdutoController produtoController) {
        if(option == options[3]) {
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
                    // Adicionar Cardapio
                    Cardapio cardapio = CardapioView.adicionarCardapio(idDinamico);

                    if (cardapio != null)
                    try {
                        controller.cadastrar(cardapio);
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }
                }
            });

            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Alterar Cardápio
                    List<Cardapio> cardapios = controller.listarTodos();
                    int idCardapioAlterar = mostrarMenuIdAlterarCardapio(cardapios);
                    Cardapio cardapioALterar = controller.consultar(idCardapioAlterar);

                    mostrarMenuAlterarCardapio(cardapioALterar);
                }
            });

            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Excluir Cardapio
                    List<Cardapio> cardapios = controller.listarTodos();
                    int id = mostrarMenuExcluirCardapio(cardapios);
                    controller.excluir(id);
                }
            });

            item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Cardápio
                    List<Cardapio> cardapios = controller.listarTodos();
                    int id = mostrarMenuConsultarCardapio(cardapios);
                    Cardapio cardapioBuscado = controller.consultar(id);
                    JOptionPane.showMessageDialog(null, cardapioBuscado.toString(produtoController.listarProdutosCardapio(cardapioBuscado.getCategoriaCardapio())));
                }
            });

            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar todos
                    List<Cardapio> cardapios = controller.listarTodos();
                    listarCardapios(cardapios, produtoController);
                }
            });
        }
    }

    public static void dropdownMesa(String[] options, String option, JPopupMenu popupMenu, JButton button, JToolBar toolbar, AtomicInteger idDinamico, MesaController controller, ComandaController comandaController, FuncionarioController funcionarioController, ClienteController clienteController) {
        if(option == options[4]) {
            JMenuItem item1 = new JMenuItem("Cadastrar");
            JMenuItem item2 = new JMenuItem("Alterar");
            JMenuItem item3 = new JMenuItem("Excluir");
            JMenuItem item4 = new JMenuItem("Consultar");
            JMenuItem item5 = new JMenuItem("Listar Todas");
            JMenuItem item6 = new JMenuItem("Mesas Disponíveis");
            JMenuItem item7 = new JMenuItem("Reservar Mesa");
            JMenuItem item8 = new JMenuItem("Listar Mesas Por Status");
            popupMenu.add(item1);
            popupMenu.add(item2);
            popupMenu.add(item3);
            popupMenu.add(item4);
            popupMenu.add(item5);
            popupMenu.add(item6);
            popupMenu.add(item7);
            popupMenu.add(item8);
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
                    // Adicionar Mesa
                    Mesa mesa = MesaView.adicionarMesa(idDinamico, funcionarioController, comandaController);

                    if (mesa != null)
                    try {
                        controller.cadastrar(mesa);
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }
                }
            });

            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Alterar Mesa
                    List<Mesa> mesas = controller.listarTodos();
                    int idMesaAlterar = mostrarMenuIdAlterarMesa(mesas);
                    Mesa mesaALterar = controller.consultar(idMesaAlterar);

                    mostrarMenuAlterarMesa(mesaALterar, funcionarioController, comandaController);
                }
            });

            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Excluir Mesa
                    List<Mesa> mesas = controller.listarTodos();
                    int id = mostrarMenuExcluirMesa(mesas);
                    controller.excluir(id);
                }
            });

            item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Mesa
                    List<Mesa> mesas = controller.listarTodos();
                    int id = mostrarMenuConsultarMesa(mesas);
                    Mesa mesaBuscada = controller.consultar(id);
                    JOptionPane.showMessageDialog(null, mesaBuscada);
                }
            });

            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar todas
                    List<Mesa> mesas = controller.listarTodos();
                    listarMesas(mesas, controller);
                }
            });

            item6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Mesas Disponíveis
                    listarMesasDidponiveis(controller);
                }
            });

            item7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Reservar Mesa
                    mostrarMenuReservarMesa(controller, clienteController, funcionarioController);
                }
            });

            item8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar Mesas Por Status
                    listarMesasPorEstatus(controller);
                }
            });
        }
    }

    public static void dropdownPedido(String[] options, String option, JPopupMenu popupMenu, JButton button, JToolBar toolbar, AtomicInteger idDinamico, PedidoController controller, ComandaController comandaController, ProdutoController produtoController, PedidoController pedidoControllerController, ClienteController clienteController, FuncionarioController funcionarioController, MesaController mesaController) {
        if(option == options[5]) {
            JMenuItem item1 = new JMenuItem("Realizar pedido");
            JMenuItem item2 = new JMenuItem("Alterar Pedido");
            JMenuItem item3 = new JMenuItem("Cancelar Pedido");
            JMenuItem item4 = new JMenuItem("Consultar");
            JMenuItem item5 = new JMenuItem("Listar Todos");
            JMenuItem item6 = new JMenuItem("Consultar Status do pedido");
            JMenuItem item7 = new JMenuItem("Listar Comandas Por Status");
            JMenuItem item8 = new JMenuItem("Fechar Comanda");
            popupMenu.add(item1);
            popupMenu.add(item2);
            popupMenu.add(item3);
            popupMenu.add(item4);
            popupMenu.add(item5);
            popupMenu.add(item6);
            popupMenu.add(item7);
            popupMenu.add(item8);

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
                    // Realizar pedido
                    Pedido pedido = PedidoView.adicionarPedido(idDinamico, funcionarioController, clienteController, produtoController, mesaController, controller);


                    if (pedido != null)
                    try {
                        controller.cadastrar(pedido);
                        comandaController.cadastrar(ComandaView.adicionarComanda(idDinamico, mesaController, pedido, controller, clienteController, comandaController));

                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }
                }
            });

            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Alterar Pedido
                    List<Pedido> pedidos = controller.listarTodos();

                    if (pedidos != null) {

                        String idPedidoAlterar = mostrarMenuIdAlterarPedido(pedidos);
                        Pedido pedidoALterar = controller.consultar(Integer.parseInt(idPedidoAlterar));

                        mostrarMenuAlterarPedido(pedidoALterar, produtoController, clienteController);
                    }
                }
            });

            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Cancelar Pedido
                    List<Pedido> pedidos = controller.listarTodos();
                    int id = mostrarMenuExcluirPedido(pedidos);
                    controller.excluir(id);
                }
            });

            item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Pedido
                    List<Pedido> pedidos = controller.listarTodos();
                    int id = mostrarMenuConsultarPedido(pedidos);
                    Pedido pedidoBuscado = controller.consultar(id);
                    JOptionPane.showMessageDialog(null, pedidoBuscado);
                }
            });

            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar todos Pedidos
                    List<Pedido> pedidos = controller.listarTodos();
                    listarPedidos(pedidos);
                }
            });

            item6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Consultar Status do pedido


                }
            });

            item7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Listar Comandas Por Status


                }
            });

            item8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fechar Comanda

                }
            });
        }
    }
}
