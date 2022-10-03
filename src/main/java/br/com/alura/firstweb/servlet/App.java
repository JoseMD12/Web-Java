package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.acao.*;
import br.com.alura.firstweb.modelo.Banco;

@WebServlet(urlPatterns="/entrada")
public class App extends HttpServlet{

    public static Banco b = new Banco();

    private static final long serialVersionUID = 2806421523585360625L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        String acao = req.getParameter("acao");
        if(acao == null){
            acao = "lista";
        }

        switch(acao){
            case "adiciona":                                        //C
                Adiciona add = new Adiciona();
                add.executa(req, res);
                break;

            case "lista":                                           //R
                ListaPessoas listar = new ListaPessoas();
                listar.executa(req, res);
                break;

            case "edita":                                           //U
                Edita edit = new Edita();
                edit.executa(req, res);
                break;

            case "remove":                                          //D
                Remove rem = new Remove();
                rem.executa(req, res);
                break;
        }
    }
}
