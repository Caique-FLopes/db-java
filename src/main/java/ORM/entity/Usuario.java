package ORM.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
//    Cpf cpf;
//    Email email;
//    Telefone telefone;
//    Endereco endereco;
    public String nome;
    public String cpf;
    public String email;
    public String telefone;
    public Date data_nascimento;
//    String endereco;

    public Usuario(){}
    public Usuario(String nome, String cpf, String email, String telefone, Date data_nascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
//        this.endereco = endereco;
    }
}
