package Persistencia;

import Apresentacao.JanelaPrincipal;
import Modelo.Funcionario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DMLogin extends DMGeral {

    public int realizarLogin(Funcionario obj) throws SQLException {
        int k = 0;
        Connection con = DMGeral.getConnection();

        String sql = "SELECT * FROM funcionario WHERE login like ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, obj.login);

        ResultSet rs = stmt.executeQuery();


        if (rs.next()) {
            String login = rs.getString("login");
            String password = rs.getString("senha");

            if (login.equals(obj.login) && password.equals(obj.password)) {
                new JanelaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Login ou senha incorretos.");
                k++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos.");
            k++;
        }
        con.close();
        return k;
    }
}
