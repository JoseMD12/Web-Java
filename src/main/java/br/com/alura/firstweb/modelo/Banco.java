package br.com.alura.firstweb.modelo;

import java.util.LinkedList;
import java.util.List;

public class Banco {
    private static List<Pessoa> pessoas = new LinkedList<Pessoa>();
    private static int key = 1;

    static{
        Pessoa pz = new Pessoa("Patrick");
        pz.setId(key++);
        Pessoa p2 = new Pessoa("Luísa");
        p2.setId(key++);
        pessoas.add(pz);
        pessoas.add(p2);
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


}
