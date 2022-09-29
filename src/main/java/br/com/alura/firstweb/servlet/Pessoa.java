package br.com.alura.firstweb.servlet;

import java.util.Date;

public class Pessoa {

    private String nome;
    private Date data;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData(){
        return this.data;
    }

}
