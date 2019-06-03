package Apresentacao;

import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Imagem;
import Modelo.Telefone;
import Persistencia.DMCliente;
import Persistencia.DMEndereco;
import Persistencia.DMGeral;
import Persistencia.DMTelefone;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class JanelaPrincipal extends JFrame {

    JLabel lWallpaper;
    private BarradeMenu MenuB;

    public JanelaPrincipal(){

        Imagem wallpapper = new Imagem();
        ImageIcon wallpaperimage = new ImageIcon(wallpapper.montarCaminho("wallpaper.jpg"));
        lWallpaper = new JLabel();
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

    public void buscarCliente() throws SQLException {

        new BuscaCliente();
    }

    public void cadastrarCliente(){
        new TelaCliente();
    }

    public void removerCliente() throws SQLException {
        String id = JOptionPane.showInputDialog("digite o id");
        new DMCliente().apagarCliente(id);
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
