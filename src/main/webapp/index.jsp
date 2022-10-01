<%-- 
    Document   : index
    Created on : Sep 27, 2022, 7:29:03 PM
    Author     : msche
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr">
    <head>
        <title>Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script> 
            function ventanaSecundaria (URL){ 
            window.open(URL,"ventana1","width=500,height=300,scrollbars=NO"); 
            } 
        </script>
    </head>
    <body>
        <main>
            <div class="principal">
                <div class="item-principal">
                    <img id="img-prin" src="imagenes/principal.png" />
                    </div>
                <div class="item-principal" style="background-color: #38b6ff">
                    <br><br><h3>Inicia sesión</h3><br>
                    <center>
                        <form name="form"  action="LoginControl" method="post" style="width: 400px;">
                            <input type="hidden" name="opc" value="1"> 
                            <label>Usuario</label> 
                            <input type="text" class="form-control" id="nro" name="username" required><br>
                            <label>Contraseña</label> 
                            <input type="password" class="form-control" id="nro" name="password" required><br>
                            <a href="javascript:ventanaSecundaria('jsp/contrasena/recuperar.jsp')" class="text-black-50 text-indigo">Recuperar contraseña</a><br><br>
                            <div class="g-recaptcha" data-sitekey="6LfRSNISAAAAAMfRc6rmKwWZbJQA2EdpoR2Rr0XA"></div><br><br>
                            <button type="submit" class="btn btn-primary">Ingresar</button> 
                            <button type="submit" class="btn btn-primary">Cancelar</button> 
                        </form>
                    </center>
                    <br>
		</div>	
            </div>
	</main>
        <footer style="background-color: #C1E8FF">
            <center>
                <h2>Contáctanos</h2>
		<p>Av. Arequipa 245 - Cercado de Lima</p>
		<p>Telefonos: 325-9854</p>
            </center>
	</footer>
    </body>
</html>
