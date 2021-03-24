<%-- 
    Document   : index
    Created on : 24 de mar de 2021, 12:39:36
    Author     : devwarlt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Início</title>
    </head>
    <body>
        <h1>Inserção de notas:</h1>
        <p align="justify">Preencha o formulário para calcular a média das notas.</p>
        <hr/>
        <form method="POST" action="NotaController">
            <c:forEach var="i" begin="1" end="3">
                <c:out value="<label for='nota${i}'>${i}ª nota:</label>"/>
                <c:out value="<input id='nota${i}' name='nota${i}' type='number' min='0' max='10'/>"/>
            </c:forEach>
            <br/>
            <button type="submit" value="Enviar">Enviar</button>
        </form>
    </body>
</html>
