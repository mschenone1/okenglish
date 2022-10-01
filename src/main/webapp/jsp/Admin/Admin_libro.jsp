<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        
    </head>
    <body style="background-color: #C1E8FF">
    <center>
        <form class="form-control-file" action="myFunction()">
            <label>Seleccione nivel del libro a cargar</label><br>
                <select name="nivel">
                    <option>Nivel 1</option>
                    <option>Nivel 2</option>
                    <option>Nivel 2</option>
                </select><br><br>
            <input type="file" name="libro"><br><br>
            <input type="submit" name="aceptar" value="Subir" class="btn btn-primary"> 
	</form>
    </center>
    </body>
</html>
