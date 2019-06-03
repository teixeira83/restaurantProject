package Persistencia;

import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DMCliente extends DMGeral {

    public void inserirCliente(Cliente c) throws SQLException {


        Connection con = DMGeral.getConnection();

        String sql = "INSERT INTO cliente (cpf,nome, id_endereco, id_telefone) values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c.getCpf());
        stmt.setString(2, c.getNome());
        stmt.setInt(3, c.getIdEndereco());
        stmt.setInt(4, c.getIdTelefone());
        stmt.execute();
        stmt.close();
    }

    public Cliente[] consultar(String nome) throws SQLException {
        Connection con = DMGeral.getConnection();

        String sql = "SELECT * FROM cliente WHERE nome like ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + nome + "%");
        ResultSet r = stmt.executeQuery();
        Cliente[] clientes = new Cliente[getReturnLength(r)];
        ResultSet rs = stmt.executeQuery();

        if (rs.next() == true) {
            int i = 0;
            clientes[0] = new Cliente(0,"", "", 0, 0);
            clientes[0].setIdCliente(rs.getInt("id_cliente"));
            clientes[0].setNome(rs.getString("nome"));
            clientes[0].setCpf(rs.getString("cpf"));
            clientes[0].setIdTelefone(rs.getInt("id_telefone"));
            clientes[0].setIdEndereco(rs.getInt("id_endereco"));
            i++;
            while (rs.next()) {
                clientes[i] = new Cliente(0,"", "", 0, 0);
                clientes[i].setIdCliente(rs.getInt("id_cliente"));
                clientes[i].setNome(rs.getString("nome"));
                clientes[i].setCpf(rs.getString("cpf"));
                clientes[i].setIdTelefone(rs.getInt("id_telefone"));
                clientes[i].setIdEndereco(rs.getInt("id_endereco"));
                i++;
            }
        } else {
            System.out.println("Cliente não encontrado no Banco de Dados.");
        }
        return clientes;
    }

    public void apagarCliente(String c) throws SQLException {
        Connection con = DMGeral.getConnection();
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c);
        stmt.executeUpdate();

    }



    public List<Cliente> help() throws SQLException {
        Connection con = DMGeral.getConnection();

        String sql = "SELECT * FROM cliente";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try{
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();

            while( rs.next()){
                Cliente cl = new Cliente(0,"","",0,0);
                cl.setIdCliente(rs.getInt("id_cliente"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));
                cl.setIdTelefone(rs.getInt("id_telefone"));
                cl.setIdEndereco(rs.getInt("id_endereco"));
                clientes.add(cl);
            }
        }catch (SQLException ex) {
            System.out.println("DEU RUIM BRO");
        }
        return clientes;
    }


}
