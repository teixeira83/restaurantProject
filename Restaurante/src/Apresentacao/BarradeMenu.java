package Apresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BarradeMenu{
    Object gui;

    public JMenuBar make(){
        JMenuBar BMenu = new JMenuBar();


        // Criação dos Menus
        JMenu menuCliente = new JMenu("Clientes");
        JMenu menuPedido = new JMenu("Pedidos");
        JMenu menuProduto = new JMenu("Produtos");
        JMenu menuFuncionario = new JMenu("Funcionários");

        // Opcoes Clientes
        //Buscar Cliente
        JMenuItem menuBuscarCliente = new JMenuItem("Buscar Cliente");
        menuBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e, "buscarCliente");
            }
        });
        //Adicionar Cliente
        JMenuItem menuAdicionarCliente = new JMenuItem("Adicionar Cliente");
        menuAdicionarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e, "cadastrarCliente");
            }
        });
        //Remover Cliente
        JMenuItem menuRemoverCliente = new JMenuItem("Remover Cliente");
        menuRemoverCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e,"removerCliente");
            }
        });
        //Editar Cliente
        JMenuItem menuEditarCliente = new JMenuItem("Editar Cliente");
        menuEditarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e,"editarCliente");
            }
        });



        // Opcoes Pedidos
        //Adicionar Pedido
        JMenuItem menuAdicionarPedido = new JMenuItem("Adicionar Pedido");
        menuAdicionarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e, "cadastrarPedido");
            }
        });
        //Remover Pedido
        JMenuItem menuApagarPedido = new JMenuItem("Apagar Pedido");
        menuApagarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e,"apagarPedido");
            }
        });


        // Opcoes Produtos
        //Adicionar Produto
        JMenuItem menuAdicionarProduto = new JMenuItem("Adicionar Produto");
        menuAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e, "cadastrarProduto");
            }
        });
        //Remover Pedido
        JMenuItem menuApagarProduto = new JMenuItem("Apagar Pedido");
        menuApagarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e,"apagarProduto");
            }
        });


        // Opcoes Funcionarios
        //Adicionar Funcionario
        JMenuItem menuAdicionarFuncionario = new JMenuItem("Adicionar Funcionário");
        menuAdicionarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e, "adicionarFuncionario");
            }
        });
        //Editar Funcionario
        JMenuItem menuEditarFuncionario = new JMenuItem("Editar Funcionário");
        menuEditarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e,"editarFuncionario");
            }
        });
        //Apagar Funcionario
        JMenuItem menuApagarFuncionario = new JMenuItem("Apagar Funcionário");
        menuApagarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamaMetodo(e,"apagarFuncionario");
            }
        });


        // Adiciona os itens criados no Menu Cliente
        menuCliente.add(menuBuscarCliente);
        menuCliente.add(menuAdicionarCliente);
        menuCliente.add(menuRemoverCliente);
        menuCliente.add(menuEditarCliente);
        // Adiciona os itens criados no Menu Pedidos
        menuPedido.add(menuAdicionarPedido);
        menuPedido.add(menuApagarPedido);
        // Adiciona os itens criados no Menu Produtos
        menuProduto.add(menuAdicionarProduto);
        menuProduto.add(menuApagarProduto);
        // Adiciona os itens criados no Menu Funcionário
        menuFuncionario.add(menuAdicionarFuncionario);
        menuFuncionario.add(menuEditarFuncionario);
        menuFuncionario.add(menuApagarFuncionario);


        // Adicionar os Menus
        BMenu.add(menuCliente);
        BMenu.add(menuPedido);
        BMenu.add(menuProduto);
        BMenu.add(menuFuncionario);

        return BMenu;


    }

    public void add(Object gui){
        this.gui  = gui;
    }

    private void chamaMetodo(ActionEvent e, String xMetodo){
        Method metodo;

        try{
            metodo = gui.getClass().getMethod(xMetodo, null);
            metodo.invoke(gui, null);
        }
        catch (NoSuchMethodException nsme){
            JOptionPane.showMessageDialog(null, "&RR0");
        }
        catch (IllegalAccessException iae){
            JOptionPane.showMessageDialog(null, "&RR0");
        }
        catch (InvocationTargetException ite){
            ite.getTargetException().printStackTrace();
            JOptionPane.showMessageDialog(null, "&RR0");
        }
    }

}