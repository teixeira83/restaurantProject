package Persistencia;

import Apresentacao.JanelaPrincipal;
import Apresentacao.TelaCliente;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.Telefone;

import javax.swing.*;
import java.sql.*;

public class DMGeral {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/restaurante", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int realizarLogin(Funcionario f) throws SQLException {
        int k = 0;
        Connection con = getConnection();

        String sql = "SELECT * FROM funcionario WHERE login like ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, f.login);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String login = rs.getString("login");
            String password = rs.getString("senha");

            if (login.equals(f.login) && password.equals(f.password)) {
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

    public void cadastrarCliente(Cliente c, Endereco e, Telefone t) throws SQLException {

        Integer idEndereco = 0;
        Integer idTelefone = 0;


        idEndereco = inserirEndereco(e);
        idTelefone = inserirTelefone(t);
        inserirCliente(c, idEndereco, idTelefone);
    }

    private int inserirEndereco(Endereco e) throws SQLException {

        Connection con = new DMGeral().getConnection();
        String sql = "INSERT INTO endereco (rua,numero,complemento,bairro,cep,cidade,estado) values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, e.logradouro);
        stmt.setString(2, e.num);
        stmt.setString(3, e.complemento);
        stmt.setString(4, e.bairro);
        stmt.setString(5, e.cep);
        stmt.setString(6, e.cidade);
        stmt.setString(7, e.estado);

        Integer idEndereco = 0;

        if (stmt.executeUpdate() > 0) {

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idEndereco = rs.getInt(1);
        }
        stmt.close();
        return idEndereco;
    }

    private int inserirTelefone(Telefone t) throws SQLException {

        Connection con = new DMGeral().getConnection();
        String sql = "INSERT INTO telefone (numero,ddd,operadora) values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.num);
        stmt.setString(2, t.ddd);
        stmt.setString(3, t.operadora);

        Integer idTelefone = 0;

        if (stmt.executeUpdate() > 0) {

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idTelefone = rs.getInt(1);
        }
        stmt.close();
        return idTelefone;
    }

    private void inserirCliente(Cliente c, Integer idEndereco, Integer idTelefone) throws SQLException {

        Connection con = new DMGeral().getConnection();

        String sql = "INSERT INTO cliente (cpf,nome, id_endereco, id_telefone) values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c.cpf);
        stmt.setString(2, c.nome);
        stmt.setInt(3, idEndereco);
        stmt.setInt(4, idTelefone);
        stmt.execute();
        stmt.close();
    }

}