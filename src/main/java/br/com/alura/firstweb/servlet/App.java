package br.com.alura.firstweb.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        Pessoa p = null;

        String nome = req.getParameter("nome");
        String dataNascimento = req.getParameter("data");
        String idString = req.getParameter("id");

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yy");
        Date data = null;

        try {
            data = fmt.parse(dataNascimento);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        if(!idString.isEmpty()){
            int id = Integer.parseInt(idString);
            p = b.getPessoa(id);
            p.setData(data);
            p.setNome(nome);

        } else {
            p = new Pessoa(nome);
            p.setData(data);

            b.adiciona(p);
        }

        res.sendRedirect("/app/listas");
    }
}
