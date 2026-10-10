package ORM;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private String url = "jdbc:mysql://localhost:3306/loja";
    private String usuario = "root";
    private String senha = "";

    private Connection conexao;
    private Statement ponteiro;

    private String tabela;
    private String query = "";

    public Database(String nomeTabela){
        this.tabela = nomeTabela;

        try {
            this.conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);
            this.ponteiro = this.conexao.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void conectar(){}

    public Database selecionar(ArrayList<String> nomeColunas){
        this.query = "SELECT ";

        if(nomeColunas.isEmpty()){
            nomeColunas.add("*");
        }

        for(int indexAtual = 0; nomeColunas.size() > indexAtual; indexAtual++){
            this.query += nomeColunas.get(indexAtual);

            if (indexAtual < nomeColunas.size() - 1){
                this.query += ", ";
            }
        }

        this.query += " FROM " + this.tabela;
        return this;
    }

    public void criar(){}
    public void atualizar(){}
    public void deletar(){}

    public ResultSet executar(){
        this.query += ";";
        System.out.println(this.query);
        try{
            return this.ponteiro.executeQuery(this.query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
