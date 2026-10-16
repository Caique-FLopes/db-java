import ORM.Produto;

import java.sql.ResultSet;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Object>  dados = new HashMap<>();
        ArrayList<String> campos = new ArrayList<>();
        while (true){
            System.out.println("Escolha uma opção\n1 - Criar Produto\n2 - Listar Produtos\n3 - Atualizar um Produto\n4 - Deletar um produto\n");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            try{
                switch(opcao){
                    case 1:
                        System.out.println("Opção " + opcao);

                        campos.add("nome");
                        campos.add("valor");
                        campos.add("categoria");


                        for (String campo : campos){
                            System.out.println("Defina o valor de " + campo);
                            if (!campo.equals("valor")){
                                dados.put(campo, scanner.next());
                            }else{
                                dados.put(campo, scanner.nextInt());
                            }
                        }

                        Produto.create(dados);
                        break;
                    case 2:
                        System.out.println("Opção " + opcao);
                        ResultSet resultado = Produto.find();
                        while(resultado.next()){
                            System.out.println("ID: " + resultado.getInt("id") + "| Nome: " + resultado.getString("nome") + "| Valor: " + resultado.getFloat("valor") + "| Categoria: " + resultado.getString("categoria"));
                        }
                        break;
                    case 3:
                        System.out.println("Opção " + opcao);
                        int id = scanner.nextInt();
                        campos.add("nome");
                        campos.add("valor");
                        campos.add("categoria");

                        for (String campo : campos){
                            if (!campo.equals("valor")){
                                dados.put(campo, scanner.next());
                            }else{
                                dados.put(campo, scanner.nextInt());
                            }
                        }

                        Produto.update(dados, id);
                        break;
                    case 4:
                        System.out.println("Opção " + opcao);
                        break;
                    default:
                        System.out.println("Digite um valor válido");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
