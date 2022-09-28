package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/app")
public class App extends HttpServlet{

    public static Banco b = new Banco();

    private static final long serialVersionUID = 2806421523585360625L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        String nome = req.getParameter("nome");
 
        Pessoa p = new Pessoa(nome);
        b.adiciona(p);

        RequestDispatcher reqDis = req.getRequestDispatcher("/novaPessoa.jsp");
        req.setAttribute("nome", nome);
        reqDis.forward(req, res);
    }
}
