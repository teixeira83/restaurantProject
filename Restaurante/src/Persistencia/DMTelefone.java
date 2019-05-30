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
}
