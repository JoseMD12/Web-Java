package br.com.alura.firstweb.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AppFiltro implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long antes = System.nanoTime();

        chain.doFilter(request, response);

        long depois = System.nanoTime();

        String acao = request.getParameter("acao");
        System.out.println("Tempo de execução de " + acao + " -> " + (depois - antes));
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
}
