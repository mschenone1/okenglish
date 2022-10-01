<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/menu.js" type="text/javascript"></script>
        <link href="../../css/mystyle.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body style="background-color: #C1E8FF">
            <table class="table table-hover">
                <tr class="bg-gradient-blue" >
                    <th>Leccion<th>Descripción<th>
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