package br.com.alura.firstweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/app/edita")
public class Edita extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        Banco b = new Banco();
        List<Pessoa> pessoas = b.getLista();

        for(Pessoa p : pessoas){
            if(p.getId() == id){
                req.setAttribute("pessoa", p);
                break;
            }
        }

        RequestDispatcher reqDisp = req.getRequestDispatcher("/form.jsp");
        reqDisp.forward(req, res);
    }
}
