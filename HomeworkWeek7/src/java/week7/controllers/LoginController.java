package week7.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import week7.models.User;
import database.Authenticate;
import database.Database;
import javax.servlet.RequestDispatcher;

public class LoginController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      //El objeto request obtiene la sesión de la aplicación a través de getSession()
      //Se almacena la sesión en el objeto session de tipo HttpSession
      HttpSession session = request.getSession();
      String username = request.getParameter("Usuario");
      String password = request.getParameter("Contrasenia");
      if(Authenticate.isValid(username, password)) {
          User user;

          /*
          Authentication.isValid(username:String, password:String) para este fin.
          En caso de ser válido, deberá obtener la información 
          restante del usuario mediante Database.getUserByUsername(username:String):User
          */
          user = Database.getUserByUsername(username);
          session.setAttribute("username", user.getUsername());
          session.setAttribute("Nombre", user.getName());
          response.sendRedirect("profile.jsp");
          
      }
      else {
          RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
          dispatcher.forward(request, response);
      }        
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
        processRequest(request, response);
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
