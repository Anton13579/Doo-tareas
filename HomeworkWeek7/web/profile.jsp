<%
    if(session.getAttribute("username") == null)
        response.sendRedirect("login.jsp");    
%>
<%
String color = "";
Cookie[] cookies = request.getCookies();
for(Cookie c : cookies) { 
  if(c.getName().equals("color")) { 
    color = c.getValue();
  }
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esto solo es un ejemplo</title>
    </head>
    <body style="background-color: <%= color %>;">
        
        <h1>Hola, <%= session.getAttribute("fullname") %></h1>
        <form action="ProfileController" method="POST">
            <select name="color">
                <option value="orange">Naranja</option>
                <option value="black">Negro</option>
                <option value="brown">Cafe</option>
            </select>

             
            <input type="submit" value="Guardar">
        </form>
            <a href="LogoutController">Cerrar sesión</a>
        
    </body>
</html>

