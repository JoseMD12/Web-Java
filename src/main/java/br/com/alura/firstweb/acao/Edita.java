package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.modelo.*;

public class Edita{
    
    
    public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        Banco b = new Banco();

        Pessoa p = b.achaPessoaId(id);

        req.setAttribute("pessoa", p);

        RequestDispatcher reqDisp = req.getRequestDispatcher("/form.jsp");
        reqDisp.forward(req, res);
    }
}
