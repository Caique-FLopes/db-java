package ORM.mappers;

import ORM.entity.Usuario;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioMapper {
    public static ArrayList<Usuario> mapper(ResultSet resultado) throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();

        while(resultado.next()){
            Usuario usuario = new Usuario(resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"), resultado.getString("telefone"), resultado.getDate("data_nascimento"));
            lista.add(usuario);
        }

        return lista;
    }
    public static Usuario mapperUnique(ResultSet resultado) throws SQLException {

        while(resultado.next()){
            Usuario usuario = new Usuario(resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"), resultado.getString("telefone"), resultado.getDate("data_nascimento"));
            return usuario;
        }
        return null;
    }
}
