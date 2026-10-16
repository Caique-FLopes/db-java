package ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public interface CRUD {
    public ResultSet find(ArrayList<String> colunas);
    public Object get_id(int id);

    Object get_id(ArrayList<String> colunas, int id);

    public Object create(HashMap<String,Object> valores);
    public Object update(HashMap<String, Object> camposAtualizados, int id);
    public Object delete(int id);
}
