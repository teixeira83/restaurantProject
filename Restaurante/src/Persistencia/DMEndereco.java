package Persistencia;

import Modelo.Endereco;

import java.sql.*;

public class DMEndereco extends DMGeral{


    public int incluirEndereco(Endereco e) throws SQLException {
        Connection con = DMGeral.getConnection();
        String sql = "INSERT INTO endereco (rua,numero,complemento,bairro,cep,cidade,estado) values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, e.getLogradouro());
        stmt.setString(2, e.getNum());
        stmt.setString(3, e.getComplemento());
        stmt.setString(4, e.getBairro());
        stmt.setString(5, e.getCep());
        stmt.setString(6, e.getCidade());
        stmt.setString(7, e.getEstado());

        Integer idEndereco = 0;

        if (stmt.executeUpdate() > 0) {

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idEndereco = rs.getInt(1);
        }
        stmt.close();
        return idEndereco;
    }


    public Endereco consutlarEndereco(int e) throws SQLException {
        Connection con = DMGeral.getConnection();
        String sql = "SELECT * FROM endereco WHERE id_endereco like ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, e);
        ResultSet r = stmt.executeQuery();

        Endereco end = new Endereco(0,"", "", "", "", "", "", "");
        if (r.next() == true){

            end.setId_endereco(r.getInt("id_endereco"));
            end.setLogradouro(r.getString("rua"));
            end.setCep(r.getString("cep"));
            end.setNum(r.getString("numero"));
            end.setComplemento(r.getString("complemento"));
            end.setBairro(r.getString("bairro"));
            end.setCidade(r.getString("cidade"));
            end.setEstado(r.getString("estado"));
        }
        return end;
    }

}
