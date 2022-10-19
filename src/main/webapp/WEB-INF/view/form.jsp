<%@ page import="java.util.List, br.com.alura.firstweb.modelo.Pessoa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada?acao=Adiciona" var="mostrar" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" lang="pt-br">
    </head>
    <body>
        <form action="${mostrar}" method="post">

            Nome: <input type="text" name="nome" value="${pessoa.nome}">
            Data de Nascimento <input type="text" name="data" value="<fmt:formatDate value="${pessoa.data}" pattern="dd/MM/yy"/>">
            <input type="hidden" name="id" value="${pessoa.id}">
            <input type="hidden" name="acao" value="adicionar">

            <input type="submit">
        </form>
    </body>
</html>