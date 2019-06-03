package Apresentacao;

import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Telefone;
import Persistencia.DMCliente;
import Persistencia.DMEndereco;
import Persistencia.DMTelefone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class TelaBuscaCliente extends JFrame {

    JButton buscar, apagar, editar;
    JLabel lNome;
    JTextField tNome;

    Cliente[] clientes;
    Telefone[] telefones;
    Endereco[] enderecos;

    //public TelaBuscaCliente(Cliente[] clientes, Telefone[] telefones, Endereco[] enderecos){
    public TelaBuscaCliente(){
        this.clientes = clientes;
        this.telefones = telefones;
        this.enderecos = enderecos;


        OuvinteCliente oC = new OuvinteCliente();

        int yBotoes = 70;

        lNome = new JLabel("Nome:");
        lNome.setSize(50,20);
        lNome.setLocation(20,20);
        add(lNome);

        tNome = new JTextField();
        tNome.setSize(200,20);
        tNome.setLocation(77,23);
        add(tNome);

        buscar = new JButton("Buscar");
        buscar.setSize(100,20);
        buscar.setLocation(60,yBotoes);
        buscar.addMouseListener(oC);
        add(buscar);

        editar = new JButton("Editar");
        editar.setSize(100,20);
        editar.setLocation(325,yBotoes);
        editar.addMouseListener(oC);
        add(editar);

        apagar = new JButton("Apagar");
        apagar.setSize(100,20);
        apagar.setLocation(620,yBotoes);
        apagar.addMouseListener(oC);
        add(apagar);

        setTitle("Exemplo de JTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,460);
        this.setResizable(false);
        Object [][] dados = {
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"}
        };
        String [] colunas = {"Nome", "Telefone", "Email","cpf","rg"};
        setup(dados,colunas);
    }

    private void setup(Object[][] dados, String[] colunas){

        JPanel painel = new JPanel();
        JTable table = new JTable(dados, colunas);

        // Inserindo tabela dentro da barra de rolagem
        JScrollPane barraRolagem = new JScrollPane(table);
        barraRolagem.setPreferredSize(new Dimension(800,100));
        // Adicionando barra de rolagem no panel
        painel.add(barraRolagem);

        // Adicionado no JFrame
        add(painel);
        setVisible(true);

        painel.setLocation(0,100);
        painel.setSize(800,800);

        //setLocation(500,500);
        setTitle("Busca");
        this.getContentPane().setLayout(null);
        setResizable(false);
        setSize(800,250);
        setVisible(true);
    }
    public void fazAlgumaCoisa() throws SQLException {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente desejado");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do cliente desejado");
        Cliente cl = new Cliente(0,nome,cpf,0,0);
        Cliente[] clientes;
        clientes =  new DMCliente().consultar("");

        Telefone[] telefones = new Telefone[clientes.length];
        Endereco[] enderecos = new Endereco[clientes.length];

        for(int i = 0; i < clientes.length; i++) {
            telefones[i]  = new DMTelefone().consultarTelefone(clientes[i].getIdTelefone());
            enderecos[i] = new DMEndereco().consutlarEndereco(clientes[i].getIdEndereco());
            System.out.println("Cliente nome " + clientes[i].getNome() + "\n cliente id_tel: " + clientes[i].getIdTelefone() + "\n cliente id_end: " + clientes[i].getIdEndereco());
            System.out.println("Telefone id_telefone " + telefones[i].getId_telefone() + "\n numero: " + telefones[i].getNum());
            System.out.println("Endereço id_endereço " + enderecos[i].getId_endereco() + "\n rua: " + enderecos[i].getNum());

        }
    }


    class OuvinteCliente extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == buscar) {
                System.out.println("teste");
                Object [][] dados = {
                        {"Outra", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                        {"Outra", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                        {"Outra", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                        {"Outra", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                        {"Outra", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"},
                        {"Outra", "48 9923-7898", "ana.monteiro@gmail.com","165165","478489498"}
                };

                String [] colunas = {"Nome", "Telefone", "Email","cpf","rg"};

                setup(dados,colunas);

            }

            if (e.getSource() == editar) {

            }

            if (e.getSource() == apagar){

            }
        }

    }
}
