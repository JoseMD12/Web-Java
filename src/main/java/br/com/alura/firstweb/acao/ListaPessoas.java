package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.modelo.*;

public class ListaPessoas{
    

    public void executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        Banco b = new Banco();

        req.setAttribute("lista", b.getLista());

        RequestDispatcher reqDisp = req.getRequestDispatcher("/lista.jsp");
        reqDisp.forward(req, res);

    }
}