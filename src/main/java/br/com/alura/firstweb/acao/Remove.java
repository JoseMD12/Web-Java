package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.modelo.*;

public class Remove implements Acao{
    
    
    public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        Banco b = new Banco();
        b.remove(id);

        req.setAttribute("lista", b.getLista());

        return "redirect:entrada?acao=ListaPessoas";
    }
}
