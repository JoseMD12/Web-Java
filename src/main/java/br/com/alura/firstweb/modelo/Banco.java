package br.com.alura.firstweb.modelo;

import java.util.LinkedList;
import java.util.List;

public class Banco {
    private static List<Pessoa> pessoas = new LinkedList<Pessoa>();
    private static List<Usuario> usuarios = new LinkedList<Usuario>();
    private static int key = 1;

    static{
        Pessoa pz = new Pessoa("Patrick");
        pz.setId(key++);

        Pessoa p2 = new Pessoa("Luísa");
        p2.setId(key++);

        pessoas.add(pz);
        pessoas.add(p2);

        Usuario uz = new Usuario();
        uz.setLogin("pz");
        uz.setSenha("pz23");

        Usuario u2 = new Usuario();
        u2.setLogin("jose");
        u2.setSenha("pze06");

        usuarios.add(uz);
        usuarios.add(u2);
    }

    public List<Pessoa> getLista(){
        return pessoas;
    }

    public void remove(int id) {
        for(Pessoa p : pessoas){
            if(p.getId() == id){
                pessoas.remove(p);
            }
        }
    }

    public void adiciona(Pessoa p) {
        pessoas.add(p);
        p.setId(key++);
    }

    public Pessoa achaPessoaId(int id){
        for(Pessoa p : pessoas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public Usuario existeUsuario(String login, String senha) {
        
        for(Usuario u : usuarios){
            if(u.ehIgual(login, senha)){
                return u;
            }
        }

        return null;
    }


}
