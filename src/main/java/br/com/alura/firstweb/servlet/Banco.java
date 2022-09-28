package br.com.alura.firstweb.servlet;

import java.util.LinkedList;
import java.util.List;

public class Banco {

    private static List<Pessoa> pessoas = new LinkedList<>();

    static{
        Pessoa pz = new Pessoa("patrick");
        Pessoa p2 = new Pessoa("luisa") ;
        pessoas.add(pz);
        pessoas.add(p2);
    }

    public void adiciona(Pessoa p) {
        Banco.pessoas.add(p);
    }

    public List<Pessoa> getLista(){
        return Banco.pessoas;
    }

}
