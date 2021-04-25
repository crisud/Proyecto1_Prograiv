/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.usuario.datos;

import cursos.logic.Persona;
import cursos.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "UsuarioDatosControlles", urlPatterns = {"/presentation/persona/datos/profile", "/presentation/profile/update"})
public class Controller extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        request.setAttribute("model", new Model());
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/persona/datos/profile":
              viewUrl = this.profile(request);
              break;
          case "/presentation/profile/update":
            //  viewUrl = this.update(request);
              break;              
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }

    public String profile(HttpServletRequest request){
        return this.profileAction(request);
    }
    
    public String profileAction(HttpServletRequest request){
       
        Model model = (Model) request.getAttribute("model");
        cursos.logic.Model domainModel = cursos.logic.Model.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Persona cliente;
        try {
            cliente = domainModel.personaFind(usuario);
        } catch (Exception ex) { cliente=null; }
        try {        
            model.setCurrent(cliente);
            String viewUrl="";
            switch(model.getTipoCuenta()){
                case "Estudiante":
                    viewUrl="/presentation/persona/estudiante/estudiante.jsp";
                    break;
                case "Profesor":
                    viewUrl="/presentation/persona/profesor/profesor.jsp";
                    break; 
                case "Administrador":
                    viewUrl="/presentation/persona/administrador/administrador.jsp";
                    break;
            }
            return viewUrl;
        } catch (Exception ex) { return ""; }     
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
