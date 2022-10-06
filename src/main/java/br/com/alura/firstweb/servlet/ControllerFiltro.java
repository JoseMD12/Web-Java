package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.acao.Acao;

@WebFilter("/entrada")
public class ControllerFiltro implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String acao = req.getParameter("acao");

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


    
    public void init(FilterConfig filterConfig) throws ServletException {}

    
    public void destroy() {}
    
}
