package br.com.alura.firstweb.servlet;

import java.util.LinkedList;
import java.util.List;

public class Banco {

    private static List<Pessoa> pessoas = new LinkedList<>();
    private static int key = 1;

    static{
        Pessoa pz = new Pessoa("patrick");
        Pessoa p2 = new Pessoa("luisa");
        pz.setId(key++);
        p2.setId(key++);
        pessoas.add(pz);
        pessoas.add(p2);
    }

    public void adiciona(Pessoa p) {
        p.setId(key++);
        Banco.pessoas.add(p);
    }

    public void remove(int id){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getId() == id){
                pessoas.remove(i);
                return;
            }
        }
    }

    public Pessoa getPessoa(int id){
        for(Pessoa p : pessoas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Pessoa> getLista(){
        return Banco.pessoas;
    }
}
