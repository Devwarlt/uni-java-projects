<%-- 
    Document   : criar
    Created on : 17 de abr de 2021, 16:27:20
    Author     : devwarlt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Criar</title>
    </head>
    <body>
        <button type="button" value="Início"><a href="index.jsp">Início</a></button>
        <br/>
        <form method="POST" action="AnimalController">
            <input type="hidden" name="action" value="create"/>
            <label for="nome_animal">Nome:</label>
            <input id="nome_animal" name="nome_animal" type="text"/>
            <br/>
            <label for="nome_dono">Dono:</label>
            <input id="nome_dono" name="nome_dono" type="text"/>
            <br/>
            <label for="especie">Espécie</label>
            <input id="especie" name="especie" type="text"/>
            <br/>
            <label for="raca">Raça</label>
            <input id="raca" name="raca" type="text"/>
            <br/>
            <label for="sexo">Sexo:</label>
            <input id="sexo" name="sexo" type="text"/>
            <br/>
            <button type="submit" value="Criar">Criar</button>
        </form>
    </body>
</html>
