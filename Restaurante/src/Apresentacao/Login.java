package Apresentacao;

import Modelo.Funcionario;
import Persistencia.DMGeral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Login extends JFrame{

    private JTextField tLogin, tPassword;
    private JLabel lLogin, lPassword, lIcone;
    private JButton bEnter;
    String login,password;

    public Login(){

        //Ouvintes
        OuvinteEntrar oE = new OuvinteEntrar();


        //Labels
        lLogin = new JLabel("Login:");
        lLogin.setSize(100,30);
        lLogin.setLocation(180,50);
        this.add(lLogin);

        lPassword = new JLabel("Password:");
        lPassword.setSize(100,30);
        lPassword.setLocation(160,90);
        this.add(lPassword);

        //Texts
        tLogin = new JTextField();
        tLogin.setSize(150,20);
        tLogin.setLocation(240,55);
        this.add(tLogin);

        tPassword = new JTextField();
        tPassword.setSize(150,20);
        tPassword.setLocation(240,95);
        this.add(tPassword);


        ImageIcon iconeImage = new ImageIcon("../Restaurante/src/Imagens/icone_login_60.png");
        lIcone = new JLabel();
        lIcone.setSize(156,156);
        lIcone.setLocation(5,10);
        lIcone.setIcon(iconeImage);
        lIcone.setHorizontalAlignment(SwingConstants.CENTER);
        this.add (lIcone);

        bEnter = new JButton("Entrar");
        bEnter.setSize(100,20);
        bEnter.setLocation(215,130);
        bEnter.addMouseListener(oE);
        this.add(bEnter);

        this.setSize(400,200);
        this.setTitle("Login");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public class OuvinteEntrar implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            login = tLogin.getText();
            password = tPassword.getText();
            Funcionario func = new Funcionario("",login,password);
            try {
                int k = new DMGeral().realizarLogin(func);
                if( k == 0 ){
                    dispose();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
        }
    }

}
