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

        String nome = JOptionPane.showInputDialog("Digite o nome do cliente desejado");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do cliente desejado");
        Cliente cl = new Cliente(nome,cpf,0,0);
        Cliente[] clientes;
        clientes =  new DMCliente().consultar(cl);

        Telefone[] telefones = new Telefone[clientes.length];
        Endereco[] enderecos = new Endereco[clientes.length];

        for(int i = 0; i < clientes.length; i++) {
            telefones[i]  = new DMTelefone().consultarTelefone(clientes[i].idTelefone);
            enderecos[i] = new DMEndereco().consutlarEndereco(clientes[i].idEndereco);
            System.out.println("Cliente nome " + clientes[i].nome + "\n cliente id_tel: " + clientes[i].idTelefone + "\n cliente id_end: " + clientes[i].idEndereco);
            System.out.println("Telefone id_telefone " + telefones[i].id_telefone + "\n numero: " + telefones[i].num);
            System.out.println("Endereço id_endereço " + enderecos[i].id_endereco + "\n rua: " + enderecos[i].num);

        }
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
