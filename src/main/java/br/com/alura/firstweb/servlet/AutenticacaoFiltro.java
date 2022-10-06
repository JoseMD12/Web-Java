package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AutenticacaoFiltro implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String acao = req.getParameter("acao");

        HttpSession session = req.getSession();
        boolean isLogado = !(session.getAttribute("userLogin") == null);
        boolean isAcaoProtegida = !(acao.equals("Login") || acao.equals("LoginFormulario"));
        if(isAcaoProtegida && !isLogado){
            res.sendRedirect("/entrada?acao=LoginFormulario");
            return;
        }
        
        chain.doFilter(req, res);
    }


    
    public void init(FilterConfig filterConfig) throws ServletException {}

    
    public void destroy() {}
    
}
