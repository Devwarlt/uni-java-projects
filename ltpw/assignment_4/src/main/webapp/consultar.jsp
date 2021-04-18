<%-- 
    Document   : consultar
    Created on : 17 de abr de 2021, 16:27:02
    Author     : devwarlt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Consultar</title>
    </head>
    <body>
        <button type="button" value="Início"><a href="index.jsp">Início</a></button>
        <br/>
        <%
            String statusStr = request.getParameter("status");
            if (statusStr == null) {
                out.println("<form method=\"GET\" action=\"AnimalController\">");
                out.println("   <input type=\"hidden\" name=\"action\" value=\"read\"/>");
                out.println("   <input type=\"hidden\" name=\"source\" value=\"consultar.jsp\"/>");
                out.println("   <label for=\"id_animal\">ID:</label>");
                out.println("   <input id=\"id_animal\" name=\"id_animal\" type=\"number\" min=\"1\" step=\"1\"/>");
                out.println("   <button type=\"submit\" value=\"Consultar\">Consultar</button>");
                out.println("</form>");
            }
            else {
                try {
                    int status = Integer.parseInt(statusStr);
                    if (status == 200) {
                        String idAnimal = request.getParameter("id_animal");
                        String nomeAnimal = request.getParameter("nome_animal");
                        String nomeDono = request.getParameter("nome_dono");
                        String especie = request.getParameter("especie");
                        String raca = request.getParameter("raca");
                        String sexo = request.getParameter("sexo");
                        out.println("<label for=\"id_animal\">ID:</label>");
                        out.println("<input id=\"id_animal\" name=\"id_animal\" type=\"text\" value=\"" + idAnimal + "\" disabled/>");
                        out.println("<br/>");
                        out.println("<label for=\"nome_animal\">Nome:</label>");
                        out.println("<input id=\"nome_animal\" name=\"nome_animal\" type=\"text\" value=\"" + nomeAnimal + "\" disabled/>");
                        out.println("<br/>");
                        out.println("<label for=\"nome_dono\">Dono:</label>");
                        out.println("<input id=\"nome_dono\" name=\"nome_dono\" type=\"text\" value=\"" + nomeDono + "\" disabled/>");
                        out.println("<br/>");
                        out.println("<label for=\"especie\">Espécie</label>");
                        out.println("<input id=\"especie\" name=\"especie\" type=\"text\" value=\"" + especie + "\" disabled/>");
                        out.println("<br/>");
                        out.println("<label for=\"raca\">Raça</label>");
                        out.println("<input id=\"raca\" name=\"raca\" type=\"text\" value=\"" + raca + "\" disabled/>");
                        out.println("<br/>");
                        out.println("<label for=\"sexo\">Sexo:</label>");
                        out.println("<input id=\"sexo\" name=\"sexo\" type=\"text\" value=\"" + sexo + "\" disabled/>");
                    }
                    else if (status == 404)
                        out.println("Não existe cadastro para o ID do animal no momento.");
                    else
                        out.println("Não foi possível consultar nenhum cadastro.");
                }
                catch (Exception e) { out.println("Não foi possível obter o resultado da requisição."); }
            }
        %>
    </body>
</html>
