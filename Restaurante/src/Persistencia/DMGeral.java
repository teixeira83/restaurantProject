package Persistencia;

import Apresentacao.JanelaPrincipal;
import Apresentacao.TelaCliente;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.Telefone;

import javax.swing.*;
import java.sql.*;

public abstract class DMGeral {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/restaurante", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    public void cadastrarCliente(Cliente c, Endereco e, Telefone t) throws SQLException {
//
//        Integer idEndereco = 0;
//        Integer idTelefone = 0;
//
//
//        idEndereco = inserirEndereco(e);
//        idTelefone = inserirTelefone(t);
//        inserirCliente(c, idEndereco, idTelefone);
//    }


    private int inserirTelefone(Telefone t) throws SQLException {


        return 0;
    }

    private void inserirCliente(Cliente c, Integer idEndereco, Integer idTelefone) throws SQLException {


    }




}