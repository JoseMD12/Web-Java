package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Formulario implements Acao{
    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        return "forward:form.jsp";

    }
}
