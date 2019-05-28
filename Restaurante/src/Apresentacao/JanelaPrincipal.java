package Apresentacao;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    JLabel lWallpaper;
    private BarradeMenu MenuB;

    public JanelaPrincipal(){


        ImageIcon wallpaperimage = new ImageIcon("../Restaurante/src/Imagens/wallpaper.jpg");
        lWallpaper = new JLabel();
        lWallpaper.setSize(800,400);
        lWallpaper.setLocation(50,50);
        lWallpaper.setIcon(wallpaperimage);
        lWallpaper.setHorizontalAlignment(SwingConstants.CENTER);
        this.add (lWallpaper);

        // Barra de Menu
        MenuB = new BarradeMenu();
        MenuB.add(this);
        this.setJMenuBar(MenuB.make());

        this.setSize(800,700);
        this.setTitle("Restaurante da Esquina");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void buscarCliente(){
        JOptionPane.showMessageDialog(null,"CADASTRAR");
    }

    public void cadastrarCliente(){
        new TelaCliente();
    }

    public void removerCliente(){
        JOptionPane.showMessageDialog(null,"REMOVER");
    }

    public void editarCliente(){
        JOptionPane.showMessageDialog(null,"EDITAR");
    }

    public void cadastrarPedido(){
        JOptionPane.showMessageDialog(null,"CADASTRAR");
    }

    public void apagarPedido(){
        JOptionPane.showMessageDialog(null,"REMOVER");
    }

    public void cadastrarProduto(){
        JOptionPane.showMessageDialog(null,"CADASTRAR");
    }

    public void apagarProduto(){
        JOptionPane.showMessageDialog(null,"REMOVER");
    }

    public void adicionarFuncionario(){
        JOptionPane.showMessageDialog(null,"CADASTRAR");
    }

    public void editarFuncionario(){
        JOptionPane.showMessageDialog(null,"CADASTRAR");
    }

    public void apagarFuncionario(){
        JOptionPane.showMessageDialog(null,"REMOVER");
    }



}
