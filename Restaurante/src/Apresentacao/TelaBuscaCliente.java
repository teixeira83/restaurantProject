package Apresentacao;

import javax.swing.*;
import java.awt.*;

public class TelaBuscaCliente extends JFrame {

    JTable table;
    JScrollPane tableScrollPane;


    Object [][] dados = {
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
    };

    String [] colunas = {"Nome", "Telefone", "Email"};


    public TelaBuscaCliente(){

        super ("Contatos");

        table = new JTable(dados, colunas);
        tableScrollPane = new JScrollPane(table);

        table.setSize(800,600);

        JPanel tablePanel = new JPanel(new GridLayout());
        tablePanel.add(tableScrollPane);
        this.add(tablePanel);


        setTitle("Busca");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
