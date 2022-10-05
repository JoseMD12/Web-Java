package br.com.alura.firstweb.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.firstweb.modelo.Banco;
import br.com.alura.firstweb.modelo.Usuario;

public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        Banco b = new Banco();
        Usuario usuario = b.existeUsuario(login, senha);

        HttpSession session = req.getSession();

        if(usuario != null){
            session.setAttribute("userLogin", usuario);
            return "redirect:entrada?acao=ListaPessoas";
        } else {
            return "redirect:entrada?acao=LoginFormulario";
        }
    }
    
}
