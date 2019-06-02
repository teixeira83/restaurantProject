package Persistencia;

import Modelo.Endereco;
import Modelo.Funcionario;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.sql.*;

public class DMEndereco extends DMGeral{


    public int incluirEndereco(Endereco e) throws SQLException {
        Connection con = DMGeral.getConnection();
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


    public Endereco consutlarEndereco(int e) throws SQLException {
        Connection con = DMGeral.getConnection();
        String sql = "SELECT * FROM endereco WHERE id_endereco like ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, e);
        ResultSet r = stmt.executeQuery();

        Endereco end = new Endereco(0,"", "", "", "", "", "", "");
        if (r.next() == true){

            end.id_endereco = r.getInt("id_endereco");
            end.logradouro = r.getString("rua");
            end.cep = r.getString("cep");
            end.num = r.getString("numero");
            end.complemento = r.getString("complemento");
            end.bairro = r.getString("bairro");
            end.cidade = r.getString("cidade");
            end.estado = r.getString("estado");
        }
        return end;
    }

}
