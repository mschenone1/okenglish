<%@page import="dao.AdministradorDao"%>
<%@page import="dao.AlumnoDao"%>
<%@page import="dao.ProfesorDao"%>
<%@page import="modelo.*"%>
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
        <br><center>
        <a href="../../AlumnoControl?opc=1" class="btn btn-secondary">Alumno</a>
        <a href="../../ProfesorControl?opc=1" class="btn btn-secondary">Docente</a>
        <a href="../../AdministradorControl?opc=1" class="btn btn-secondary">Administrador</a>

        
    </center>
</body>
</html>