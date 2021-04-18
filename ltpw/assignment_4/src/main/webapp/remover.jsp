<%-- 
    Document   : remover
    Created on : 17 de abr de 2021, 17:33:09
    Author     : devwarlt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Remover</title>
    </head>
    <body>
        <button type="button" value="Início"><a href="index.jsp">Início</a></button>
        <br/>
        <form method="POST" action="AnimalController">
            <input type="hidden" name="action" value="delete"/>
            <label for="id_animal">ID</label>
            <input id="id_animal" name="id_animal" type="number" min="1" step="1"/>
            <br/>
            <button type="submit" value="Remover">Remover</button>
        </form>
    </body>
</html>
