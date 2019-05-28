package Apresentacao;

import Modelo.*;
import Persistencia.DMGeral;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

@SuppressWarnings("serial")
public class TelaCliente extends JFrame {

    private JLabel lDados, lEndereco, lContato, lNome, lCpf, lRua, lNumero, lComplemento, lBairro, lCidade, lCep, lEstado, lDdd, lTel, lOperadora;
    private JTextField tNome, tCpf, tRua, tNumero, tComplemento, tBairro, tCidade, tCep, tEstado, tDdd, tTel, tOperadora;
    private JButton bSalvar, bLimpar;

    //vari�veis locais para armazenar o que for digitado
    String cpf, nome, rua, numero, complemento, bairro, cidade, cep, estado, ddd, tel, operadora;


    Cliente cliente;
    Endereco endereco;
    Telefone telefone;

    public TelaCliente() {


        lDados = new JLabel(">>>>> DADOS PESSOAIS <<<<<");
        lDados.setSize(250, 30);
        lDados.setLocation(20, 20);
        this.add(lDados);

        lCpf = new JLabel("CPF:");
        lCpf.setSize(50, 30);
        lCpf.setLocation(20, 60);
        this.add(lCpf);

        tCpf = new JTextField();
        tCpf.setSize(150, 20);
        tCpf.setLocation(80, 65);
        this.add(tCpf);

        lNome = new JLabel("Nome: ");
        lNome.setSize(120, 30);
        lNome.setLocation(250, 60);
        this.add(lNome);

        tNome = new JTextField();
        tNome.setSize(460, 20);
        tNome.setLocation(320, 65);
        this.add(tNome);

        lEndereco = new JLabel(">>>>>>> ENDEREÇO <<<<<<<");
        lEndereco.setSize(250, 30);
        lEndereco.setLocation(20, 110);
        this.add(lEndereco);

        //endere�o
        lRua = new JLabel("Logradouro:");
        lRua.setSize(100, 30);
        lRua.setLocation(20, 150);
        this.add(lRua);

        tRua = new JTextField();
        tRua.setSize(400, 20);
        tRua.setLocation(110, 155);
        this.add(tRua);

        lNumero = new JLabel("Número:");
        lNumero.setSize(120, 30);
        lNumero.setLocation(550, 150);
        this.add(lNumero);

        tNumero = new JTextField();
        tNumero.setSize(100, 20);
        tNumero.setLocation(625, 155);
        this.add(tNumero);

        lComplemento = new JLabel("Complemento:");
        lComplemento.setSize(120, 30);
        lComplemento.setLocation(20, 180);
        this.add(lComplemento);

        tComplemento = new JTextField();
        tComplemento.setSize(150, 20);
        tComplemento.setLocation(130, 185);
        this.add(tComplemento);

        lBairro = new JLabel("Bairro: ");
        lBairro.setSize(120, 30);
        lBairro.setLocation(300, 180);
        this.add(lBairro);

        tBairro = new JTextField();
        tBairro.setSize(220, 20);
        tBairro.setLocation(350, 185);
        this.add(tBairro);

        lCep = new JLabel("CEP:");
        lCep.setSize(60, 30);
        lCep.setLocation(20, 215);
        this.add(lCep);

        tCep = new JTextField();
        tCep.setSize(160, 20);
        tCep.setLocation(70, 220);
        this.add(tCep);

        lCidade = new JLabel("Cidade: ");
        lCidade.setSize(120, 30);
        lCidade.setLocation(250, 215);
        this.add(lCidade);

        tCidade = new JTextField();
        tCidade.setSize(230, 20);
        tCidade.setLocation(320, 220);
        this.add(tCidade);

        lEstado = new JLabel("Estado:");
        lEstado.setSize(120, 30);
        lEstado.setLocation(580, 215);
        this.add(lEstado);

        tEstado = new JTextField();
        tEstado.setSize(80, 20);
        tEstado.setLocation(635, 220);
        this.add(tEstado);


        lContato = new JLabel(">>>>>>> CONTATO <<<<<<<");
        lContato.setSize(250, 30);
        lContato.setLocation(20, 265);
        this.add(lContato);

        lDdd = new JLabel("DDD:");
        lDdd.setSize(120, 30);
        lDdd.setLocation(20, 305);
        this.add(lDdd);

        tDdd = new JTextField();
        tDdd.setSize(50, 20);
        tDdd.setLocation(70, 310);
        this.add(tDdd);

        lTel = new JLabel("Número: ");
        lTel.setSize(80, 30);
        lTel.setLocation(150, 305);
        this.add(lTel);

        tTel = new JTextField();
        tTel.setSize(140, 20);
        tTel.setLocation(220, 310);
        this.add(tTel);

        lOperadora = new JLabel("Operadora: ");
        lOperadora.setSize(150, 30);
        lOperadora.setLocation(370, 305);
        this.add(lOperadora);

        tOperadora = new JTextField();
        tOperadora.setSize(180, 20);
        tOperadora.setLocation(460, 310);
        this.add(tOperadora);

        class OuvinteCliente extends MouseAdapter {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == bSalvar) {

                    cpf = tCpf.getText();
                    nome = tNome.getText();
                    Cliente c = new Cliente(nome, cpf,0,0);

                    rua = tRua.getText();
                    numero = tNumero.getText();
                    complemento = tComplemento.getText();
                    bairro = tBairro.getText();
                    cep = tCep.getText();
                    cidade = tCidade.getText();
                    estado = tEstado.getText();

                    Endereco end = new Endereco(rua, numero, complemento, bairro, cep, cidade, estado);

                    ddd = tDdd.getText();
                    tel = tTel.getText();
                    operadora = tOperadora.getText();

                    Telefone telefone = new Telefone(ddd, tel, operadora);
                    try {
                        new DMGeral().cadastrarCliente(c, end, telefone);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }

                if (e.getSource() == bLimpar) {

                    tCpf.setText("");
                    tNome.setText("");
                    tRua.setText("");
                    tNumero.setText("");
                    tComplemento.setText("");
                    tBairro.setText("");
                    tCep.setText("");
                    tCidade.setText("");
                    tEstado.setText("");
                    tDdd.setText("");
                    tNumero.setText("");
                    tOperadora.setText("");
                    tTel.setText("");

                }
            }

        }


        OuvinteCliente oC = new OuvinteCliente();

        bSalvar = new JButton("Salvar");
        bSalvar.setSize(150, 50);
        bSalvar.setLocation(150, 350);
        bSalvar.setForeground(Color.white);
        bSalvar.setBackground(Color.green);
        bSalvar.addMouseListener(oC);
        this.add(bSalvar);

        bLimpar = new JButton("Limpar");
        bLimpar.setSize(150, 50);
        bLimpar.setLocation(500, 350);
        bLimpar.setForeground(Color.white);
        bLimpar.setBackground(Color.blue);
        bLimpar.addMouseListener(oC);
        this.add(bLimpar);

        this.setSize(800, 450);
        this.setTitle("Cliente");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);



    }
}