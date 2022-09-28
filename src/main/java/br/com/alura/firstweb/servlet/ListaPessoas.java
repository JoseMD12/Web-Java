package br.com.alura.firstweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/app/listas")
public class ListaPessoas extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        Banco b = new Banco();
        List<Pessoa> pessoas = b.getLista();

        req.setAttribute("lista", pessoas);

        RequestDispatcher reqDisp = req.getRequestDispatcher("/lista.jsp");
        reqDisp.forward(req, res);

    }
}
