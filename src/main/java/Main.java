import ORM.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("produto");
        ArrayList<String> nomeColunas = new ArrayList<>();

        ResultSet resultado;

        try{
            resultado = db.selecionar(nomeColunas).executar();

            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("nome") + " - Valor: " + resultado.getFloat("valor"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }




//        try {
//            Connection conexao = DriverManager.getConnection(url, usuario, senha);
//            Statement statement = conexao.createStatement();
//            ResultSet resultado = statement.executeQuery("SELECT id, nome FROM produto");
//
//            while (resultado.next()) {
//                System.out.println("ID: " + resultado.getInt("id") + " - Nome: " + resultado.getString("nome"));
//            }
//
//            conexao.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
