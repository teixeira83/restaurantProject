package Persistencia;

import Modelo.Telefone;

import java.sql.*;

public class DMTelefone extends DMGeral {

    public int inserirTelefone(Telefone t) throws SQLException {
        Connection con =  DMGeral.getConnection();
        String sql = "INSERT INTO telefone (numero,ddd,operadora) values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getNum());
        stmt.setString(2, t.getDdd());
        stmt.setString(3, t.getOperadora());

        Integer idTelefone = 0;

        if (stmt.executeUpdate() > 0) {

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idTelefone = rs.getInt(1);
        }
        stmt.close();
        return idTelefone;
    }

    public Telefone consultarTelefone(int t) throws SQLException {
        Connection con =  DMGeral.getConnection();

        String sql = "SELECT * FROM telefone WHERE id_telefone = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, t);
        ResultSet r = stmt.executeQuery();
        Telefone tel = new Telefone(0,"","","");
        if( r.next() == true ){
                tel.setId_telefone(r.getInt("id_telefone"));
                tel.setDdd(r.getString("ddd"));
                tel.setNum(r.getString("numero"));
                tel.setOperadora(r.getString("operadora"));
        }
        return tel;
    }
}
