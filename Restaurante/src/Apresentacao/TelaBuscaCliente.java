package Apresentacao;

import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Telefone;

import javax.swing.*;
import java.awt.*;

public class TelaBuscaCliente extends JFrame {

    JTable table;
    JScrollPane tableScrollPane;

    Cliente[] clientes;
    Telefone[] telefones;
    Endereco[] enderecos;

    public TelaBuscaCliente(Cliente[] clientes, Telefone[] telefones, Endereco[] enderecos){
        this.clientes = clientes;
        this.telefones = telefones;
        this.enderecos = enderecos;

        setTitle("Exemplo de JTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,460);
        this.setResizable(false);
        setup();
    }



    private void setup(){
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



        JPanel painel = new JPanel();

        JTable table = new JTable(dados, colunas);

        // Inserindo tabela dentro da barra de rolagem
        JScrollPane barraRolagem = new JScrollPane(table);


        // Adicionando barra de rolagem no panel
        painel.add(barraRolagem);

        // Adicionado no JFrame
        add(painel);
        setVisible(true);



        setTitle("Busca");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
