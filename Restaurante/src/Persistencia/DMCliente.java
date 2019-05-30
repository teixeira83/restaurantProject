package Persistencia;

import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMCliente extends DMGeral  {

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

    public void consultar(Cliente c){

    }
}
