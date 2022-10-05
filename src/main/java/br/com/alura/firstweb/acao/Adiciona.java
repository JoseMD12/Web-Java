package br.com.alura.firstweb.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.firstweb.modelo.*;

public class Adiciona implements Acao{
    

    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        String nome = req.getParameter("nome");
        String data = req.getParameter("data");
        String idString = req.getParameter("id");

        Date dataNascimento = null;
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataNascimento = sdf.parse(data);

		} catch (Exception e) {
			throw new ServletException(e);
		}


        Banco b = new Banco();
 
        if(idString.isEmpty()){

            Pessoa p = new Pessoa(nome);
            p.setData(dataNascimento);
            b.adiciona(p);
            req.setAttribute("pessoa", p);

        } else {

            int id = Integer.parseInt(idString);
            Pessoa p = b.achaPessoaId(id);
            p.setNome(nome);
            p.setData(dataNascimento);

        }

        return "redirect:entrada?acao=ListaPessoas";
    }
}
