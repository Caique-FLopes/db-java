package ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Produto implements CRUD{
    protected static final String TABELA = "produto";
    private static final Database db = new Database(Produto.TABELA);

    public ResultSet find(ArrayList<String> colunas) {
        return db.selecionar(colunas).executarConsulta();
    }
    public ResultSet find() {
        return db.selecionar().executarConsulta();
    }

    public ResultSet get_id(int id) {
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);
        return db.selecionar().where(condicao).executarConsulta();
    }

    public ResultSet get_id(ArrayList<String> colunas, int id) {
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);
        return db.selecionar(colunas).where(condicao).executarConsulta();
    }

    public Integer create(HashMap<String, Object> valores) {
        return db.criar(valores).executarComando();
    }

    public Integer update(HashMap<String, Object> camposAtualizados, int id) {
        return db.atualizar(camposAtualizados, id).executarComando();
    }

    public Integer delete(int id) {
        return db.deletar(id).executarComando();
    }
}
