package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.modelo.*;

public class ListaPessoas implements Acao{
    

    public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        Banco b = new Banco();

        req.setAttribute("lista", b.getLista());

        return "forward:lista.jsp";

    }
}