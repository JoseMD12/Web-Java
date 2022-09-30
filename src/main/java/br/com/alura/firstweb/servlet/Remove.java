package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/app/remove")
public class Remove extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        Banco b = new Banco();
        b.remove(id);

        res.sendRedirect("/app/listas");
    }
}
