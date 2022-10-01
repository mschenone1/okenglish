<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/mystyle.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/cambiarPestanna.js" type="text/javascript"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <header class="cabecera">
            <a href="../../index.html">
            <img id="logo" src="../../imagenes/Logos/alumno.png" alt=""/></a>
        <nav>
            <div class="principal">
            <h4 style="margin-top: 30px">Nombre de alumno</h4>
            <img src="../../imagenes/Usuarios/hombre.jpg" alt="" class="img-circle" style="width: 80px; height: 80px"/>
            <a href="../../index.html">
                <img style="margin-top: 30px" id="icono" src="../../imagenes/icosalir.png" alt=""/>
            </a>
        </nav>	
    </header>
     <body onload="javascript:cambiarPestanna(pestanas,pestana1);" style="background-image: url('../../imagenes/fondo.png');background-repeat: no-repeat; background-size: cover">
      <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <div class="contenedor">
            <div id="pestanas">
                <ul id=lista>
                    <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>Información Académica</a></li>
                    <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>Lecciones</a></li>
                    <li id="pestana3"><a href='javascript:cambiarPestanna(pestanas,pestana3);'>Libro</a></li>
                    <li id="pestana4"><a href='javascript:cambiarPestanna(pestanas,pestana4);'>Horario</a></li>
                </ul>
            </div>
            <div id="contenidopestanas">
                <div id="cpestana1" class="embed-container">
                    <iframe src="Alumno_curso.jsp" frameborder="0" allowfullscreen></iframe> 
                </div>
                <div id="cpestana2" class="embed-container">
                    <iframe src="Alumno_leccion.jsp" frameborder="0" allowfullscreen></iframe> 
                </div>
                <div id="cpestana3" class="embed-container">
                    <iframe src="Alumno_libro.jsp" frameborder="0" allowfullscreen></iframe> 
                </div>
                <div id="cpestana4" class="embed-container">
                    <iframe src="Alumno_horario.jsp" frameborder="0" allowfullscreen></iframe> 
                </div>
            </div>
        </div>
    </body>
 	
</html>
