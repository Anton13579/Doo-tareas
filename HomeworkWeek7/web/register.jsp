<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
       <body>
        <h1>Iniciar sesion</h1>
        <p><a href="login.jsp">Iniciar Sesion</a></p>
        
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="Register" method="post">
            <p>Nombre de Usuario: <input type="text" name="username"></p>
            <p>Nombre: <input type="text" name="name"></p>
            <p>Apellidos: <input type="text" name="lastName"></p>
            <p>Email: <input type="text" name="email"></p>
            <p>Contraseña: <input type="password" name="password1"></p>
            <p>Confirma contraseña <input type="password" name="password2"></p>
            <p><input type="submit" value="Entrar"></p>
        </form>
    </body>
</html>
