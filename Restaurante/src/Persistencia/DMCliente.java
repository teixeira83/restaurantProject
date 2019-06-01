package Persistencia;

import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DMCliente extends DMGeral {

    public void inserirCliente(Cliente c, int idTelefone, int idEndereco) throws SQLException {


        Connection con = DMGeral.getConnection();

        String sql = "INSERT INTO cliente (cpf,nome, id_endereco, id_telefone) values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c.cpf);
        stmt.setString(2, c.nome);
        stmt.setInt(3, idEndereco);
        stmt.setInt(4, idTelefone);
        stmt.execute();
        stmt.close();
    }

    public Object consultar(Cliente c) throws SQLException {
        Connection con = DMGeral.getConnection();

        String sql = "SELECT * FROM cliente WHERE nome like ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + c.nome + "%");
        ResultSet r = stmt.executeQuery();
        Cliente[] clientes = new Cliente[getReturnLength(r)];
        ResultSet rs = stmt.executeQuery();

        if (rs.next() == true) {
            int i = 0;
            clientes[0] = new Cliente("", "", 0, 0);
            clientes[0].nome = rs.getString("nome");
            clientes[0].cpf = rs.getString("cpf");
            clientes[0].idTelefone = rs.getInt("id_telefone");
            clientes[0].idEndereco = rs.getInt("id_endereco");
            i++;
            while (rs.next()) {
                clientes[i] = new Cliente("", "", 0, 0);
                clientes[i].nome = rs.getString("nome");
                clientes[i].cpf = rs.getString("cpf");
                clientes[i].idTelefone = rs.getInt("id_telefone");
                clientes[i].idEndereco = rs.getInt("id_endereco");
                i++;
            }
        } else {
            c = null;
            System.out.println("Cliente não encontrado no Banco de Dados.");
        }
        return clientes;
    }
}
