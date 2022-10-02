<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Profesores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/menu.js" type="text/javascript"></script>
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body style="background-color: #C1E8FF">
        <%
            List<Profesores> lis = (ArrayList<Profesores>) request.getAttribute("dato");
            %>
        <br><center>
            <a href="AlumnoControl?opc=1" class="btn btn-secondary">Alumno</a>
        <a href="ProfesorControl?opc=1" class="btn btn-secondary">Docente</a>
        <a href="AdministradorControl?opc=1" class="btn btn-secondary">Administrador</a>
        </center><br><br>
        <table class="table table-hover">
            <tr class="bg-gradient-blue" >
                <th>Codigo de docente<th>Nombre y apellidos<th>Correo<th>Contraseña
                    
                    <%
                    for (Profesores x : lis) {
                        out.print("<tr><td>" + x.getIdProfesor()
                                + "<td>" + x.getNombres()
                                + "<td>" + x.getEmail() + "<td>" + x.getEmail());
                    }
                %>
            </table>
  
        <a href='javascript:showMenu();'>prueba</a>
  
    <div id="contextMenu" class="context-menu" 
        style="display:none">
        <ul>
            <li><a href="../Alumno/InicioAlumno.jsp">Eliminar</a></li>
            <li><a href="#">Editar</a></li>
        </ul>
    </div>
    </body>
</html>