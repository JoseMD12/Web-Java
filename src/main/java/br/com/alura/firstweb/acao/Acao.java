package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
    String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
