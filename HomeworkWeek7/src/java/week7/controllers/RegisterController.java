package week7.controllers;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession respuesta = request.getSession(true);
        PrintWriter out = response.getWriter();
        //Declaro e inicio las variables
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        String confirm_password = request.getParameter("password2");
        //Comienzo con las validaciones
        /*
         * Podemos hacer un monton de validaciones, por ejemplo:
         * Campos no vacios, direccion de email valida, nombre de usuario y contraseña
         * sin espacios y/o caracteres especiales.
         */
        
        //campos vacios
        if(username.isEmpty() || name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirm_password.isEmpty()){
            respuesta.setAttribute("error", "Hay campos vacios");
            
        } else {
            //Ahora verifico si la contraseña 1 y la contraseña 2 son iguales
            if(password.equals(confirm_password)){     
                           
                /*
                Registrar los datos mediante el método 
                Database.setUser(name:String, lastName:String,
                userName:String, password:String);
                 */
                Database.setUser(name,lastName,username,password);
                response.sendRedirect("login.jsp");
                
                
            } else {                   
                respuesta.setAttribute("error", "Las contraseñas no son iguales");    
            }
        }
        response.sendRedirect("register.jsp"); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        response.sendRedirect("login.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
