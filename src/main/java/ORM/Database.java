package ORM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String usuario = "root";
    private String senha = "";
    private String database = "";
    private String url = "jdbc:mysql://localhost:3306/loja" + this.database;

    private String tabela;
    private String query = "";
    private Connection conexao;
    private Statement ponteiro;

    public Database(String nomeTabela){
        try {
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            this.ponteiro = conexao.createStatement();
            this.tabela = nomeTabela;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Database select(ArrayList<String> colunas){
        this.query += "SELECT ";

        if (colunas.isEmpty()){
            colunas.add("*");
        }

        for (int colunaAtual = 0; colunas.size() > colunaAtual ; colunaAtual++){
            this.query +=  colunas.get(colunaAtual) + " ";

            if (colunaAtual < colunas.size() - 1){
                this.query += ", ";
            }
        }

        this.query += "FROM " + this.tabela;

        return this;
    }

    public ResultSet execute(){
        try {
            this.query +=";";
            System.out.println(this.query);
            ResultSet resultado = this.ponteiro.executeQuery(this.query);
            return resultado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
