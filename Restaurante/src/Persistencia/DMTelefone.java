package Persistencia;

import Modelo.Telefone;

import java.sql.*;

public class DMTelefone extends DMGeral {

    public int inserirTelefone(Telefone t) throws SQLException {
        Connection con =  DMGeral.getConnection();
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

    public Telefone consultarTelefone(int t) throws SQLException {
        Connection con =  DMGeral.getConnection();

        String sql = "SELECT * FROM telefone WHERE id_telefone = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, t);
        ResultSet r = stmt.executeQuery();
        Telefone tel = new Telefone(0,"","","");
        if( r.next() == true ){
                tel .id_telefone = r.getInt("id_telefone");
                tel.ddd = r.getString("ddd");
                tel.num = r.getString("numero");
                tel.operadora = r.getString("operadora");
        }
        return tel;
    }
}
