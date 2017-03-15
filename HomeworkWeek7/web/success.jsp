

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esto solo es un ejemplo</title>
    </head>
    <body>
        <h1>Hola, <%= request.getAttribute("username") %></h1>
    </body>
    
</html>
