package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.modelo.*;

public class Remove{
    
    
    public void executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        Banco b = new Banco();
        b.remove(id);

        req.setAttribute("lista", b.getLista());

        RequestDispatcher reqDisp = req.getRequestDispatcher("/lista.jsp");
        reqDisp.forward(req, res);
    }
}
