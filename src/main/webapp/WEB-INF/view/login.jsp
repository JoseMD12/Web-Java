<%@ page import="java.util.List, br.com.alura.firstweb.modelo.Pessoa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada?acao=Login" var="log" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" lang="pt-br">
    </head>
    <body>
        <form action="${log}" method="post">

            Login: <input type="text" name="login">
            Senha: <input type="password" name="senha">
            <input type="hidden" name="acao" value="login">

            <input type="submit">
        </form>
    </body>
</html>