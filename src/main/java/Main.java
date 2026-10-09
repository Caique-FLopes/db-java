import ORM.Database;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("produto");
        ArrayList<String> colunas = new ArrayList<String>();
        ResultSet resultado;

        try {
            resultado = db.select(colunas).execute();

            while(resultado.next()){
                System.out.println("ID: " + resultado.getInt("id") + " - Nome: " + resultado.getString("nome"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
