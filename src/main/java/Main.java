import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/loja";
        String usuario = "root";
        String senha = "";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT id, nome FROM produto");

            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id") + " - Nome: " + resultado.getString("nome"));
            }

            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
