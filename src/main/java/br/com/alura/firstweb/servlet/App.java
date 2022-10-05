package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.firstweb.acao.*;
import br.com.alura.firstweb.modelo.Banco;

@WebServlet(urlPatterns="/entrada")
public class App extends HttpServlet{

    public static Banco b = new Banco();

    private static final long serialVersionUID = 2806421523585360625L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        String acao = req.getParameter("acao");

        HttpSession session = req.getSession();
        boolean isLogado = !(session.getAttribute("userLogin") == null);
        boolean isAcaoProtegida = !(acao.equals("Login") || acao.equals("LoginFormulario"));
        if(isAcaoProtegida && !isLogado){
            res.sendRedirect("/entrada?acao=LoginFormulario");
        }
        String redirecionamento;
    
        try {

            Class classe = Class.forName("br.com.alura.firstweb.acao." + acao);
            Acao acaoObj = (Acao) classe.newInstance();
            redirecionamento = acaoObj.executa(req, res);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }


        String[] endereco = redirecionamento.split(":");

        if(endereco[0].equals("forward")){

            RequestDispatcher reqDisp = req.getRequestDispatcher("WEB-INF/view/" + endereco[1]);
            reqDisp.forward(req, res);

        } else {

            res.sendRedirect(endereco[1]);

        }
        
    }
}
