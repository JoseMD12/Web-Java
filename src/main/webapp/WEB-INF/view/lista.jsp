<%@ page import="java.util.List, br.com.alura.firstweb.modelo.Pessoa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8" lang="pt-br">
        </head>
        <body>

            Usuario Logado: ${userLogin.login}

            <br/>
            <br/>
            <br/>

            <c:if test="${not empty pessoa}">
                ${pessoa.nome} cadastrado com sucesso! 
            </c:if>
            
            <br />

            Lista Pessoas:
            
            <ul>

                <c:forEach items="${lista}" var="pessoa">
                    <li>${pessoa.nome} - <fmt:formatDate value="${pessoa.data}" pattern="dd/MM/yy"/> 
                    <a href="/entrada?acao=Edita&id=${pessoa.id}">edita</a>
                    <a href="/entrada?acao=Remove&id=${pessoa.id}">remove</a>
                    </li>
                </c:forEach>

            </ul>

            <br />

            <a href="/entrada?acao=Formulario">adicionar nova pessoa</a> <c:import url="logout.jsp"/>
        </body>
    </html>
