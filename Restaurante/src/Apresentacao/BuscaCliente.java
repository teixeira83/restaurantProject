package Apresentacao;

import Modelo.Cliente;
import Persistencia.DMCliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class BuscaCliente extends JFrame{

    JButton buscar, apagar, editar;
    JLabel lNome;
    JTextField tNome;
    JPanel painel = new JPanel();
    Object [][] dados = new Object[][]{
            {}
    };

    JTable tabela = new JTable(new DefaultTableModel(dados,new Object[]{"ID", "NOME","CPF"}));

    public BuscaCliente() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);

        DMCliente dmc = new DMCliente();
        for (Cliente c : dmc.consultar("")){
            model.addRow(new Object[]{
                    c.getIdCliente(),
                    c.getNome(),
                    c.getCpf()
            });
        }

        JScrollPane barraRolagem = new JScrollPane();
        barraRolagem.setPreferredSize(new Dimension(800,150));
        barraRolagem.setViewportView(tabela);
        painel.add(barraRolagem);
        this.add(painel);

        painel.setLocation(0,100);
        painel.setSize(800,150);
        painel.setLocation(0,100);

        int yBotoes = 70;


        OuvinteCliente oC = new OuvinteCliente();

        lNome = new JLabel("Nome:");
        lNome.setSize(50,20);
        lNome.setLocation(20,20);
        this.add(lNome);

        tNome = new JTextField();
        tNome.setSize(200,20);
        tNome.setLocation(77,23);
        this.add(tNome);

        buscar = new JButton("Buscar");
        buscar.setSize(100,20);
        buscar.setLocation(60,yBotoes);
        buscar.addMouseListener(oC);
        this.add(buscar);

        editar = new JButton("Editar");
        editar.setSize(100,20);
        editar.setLocation(325,yBotoes);
        editar.addMouseListener(oC);
        this.add(editar);

        apagar = new JButton("Apagar");
        apagar.setSize(100,20);
        apagar.setLocation(620,yBotoes);
        apagar.addMouseListener(oC);
        this.add(apagar);


        this.setSize(800,300);
        this.setTitle("Cliente");
        this.getContentPane().setBackground(new Color(177, 148, 227));
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        criarJTable();
    }

    public void criarJTable(){

    }

    class OuvinteCliente extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == buscar) {
                String nome = tNome.getText();
                DMCliente dmc = new DMCliente();
                try {
                    DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                    model.setNumRows(0);
                    for ( Cliente c : dmc.consultar(nome)){
                        model.addRow(new Object[]{
                                c.getIdCliente(),
                                c.getNome(),
                                c.getCpf()
                        });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (e.getSource() == editar) {

            }

            if (e.getSource() == apagar){

            }
        }

    }
}
