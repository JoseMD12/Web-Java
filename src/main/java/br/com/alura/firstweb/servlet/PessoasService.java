package br.com.alura.firstweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.firstweb.modelo.*;

@WebServlet("/listar")
public class PessoasService extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        List<Pessoa> pessoas = new Banco().getLista();

        String header = req.getHeader("Accept");

        if(header.contains("xml")){

            XStream xStream = new XStream();
            xStream.alias("Pessoa", Pessoa.class);
            String xml = xStream.toXML(pessoas);
            res.setContentType("application/xml");
            res.getWriter().println(xml);

        } else if(header.contains("json")){

            Gson gson = new Gson();
            String json = gson.toJson(pessoas);
            res.setContentType("application/json");
            res.getWriter().println(json);

        } else {

            res.setContentType("application/json");
            res.getWriter().println("{ message : no content }");
            
        }
        

        

    }

}
