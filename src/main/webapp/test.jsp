<%-- 
    Document   : test
    Created on : Oct 1, 2022, 7:16:07 PM
    Author     : msche
--%>

<%@page import="dao.AdministradorDao"%>
<%@page import="modelo.Administradores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            AdministradorDao obj = new AdministradorDao();

        %>    
    <center>
        <h3>Lista de Clientes</h3>
        <a href="control?opc=3">Resumen</a>
        <table class="table table-hover">
            <tr class="bg-dark text-white"><th>Codigo<th>Cliente<th>Telefono<th>Ver
                    <%                        for (Administradores x : obj.encontrarTodos()) {
                            out.print("<tr><td>" + x.getNombres() + "<td>" + x.getNumDoc()
                                    + "<td>" + x.getId());
                        }
                    %>  
        </table>
    </center>
</body>
</html>
