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
        <h1>Animal CRUD</h1>
        <hr/>
        <%
            String statusStr = request.getParameter("status");
            String message = request.getParameter("message");
            if (statusStr != null && message != null)
                try {
                    int status = Integer.parseInt(statusStr);
                    StringBuilder sb = new StringBuilder();
                    sb.append("<strong>");
                    sb.append(status == 200 ? "Sucesso!" : "Falha " + statusStr + "!");
                    sb.append("</strong> ");
                    sb.append(message);
                    sb.append("<hr/>");
                    out.println(sb.toString());
                }
                catch (Exception e) { out.println("Não foi possível obter o resultado da requisição."); }
        %>
        <br/>
        <div>
            <button type="button" value="Create"><a href="criar.jsp">Create</a></button>
            <br/>
            <button type="button" value="Read"><a href="consultar.jsp">Read</a></button>
            <br/>
            <button type="button" value="Update"><a href="atualizar.jsp">Update</a></button>
            <br/>
            <button type="button" value="Delete"><a href="remover.jsp">Delete</a></button>
        </div>
    </body>
</html>
