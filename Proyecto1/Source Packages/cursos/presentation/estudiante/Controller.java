/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.estudiante;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calef
 */
@WebServlet(name = "EstudianteController", urlPatterns = {"/presentation/estudiante/datos","/presentation/estudiante/historial",
"/presentation/estudiante/update","/presentation/estudiante/cursos"})
public class Controller extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       request.setAttribute("modelEstu", new Model()); 
        
       String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/estudiante/datos":
                viewUrl=this.datos(request);
                break;              
            case "/presentation/estudiante/update":
                viewUrl=this.update(request);
                break;            
            case "/presentation/estudiante/historial":
                viewUrl=this.historial(request);
                break;
            case "/presentation/estudiante/cursos":
                viewUrl=this.cursos(request);
            
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 

        }
    
//datos del estudiante
     public String datos(HttpServletRequest request){
        return this.datosAction(request);
    }
    
    public String datosAction(HttpServletRequest request){
       String viewUrl="/presentation/estudiante/datos/datos.jsp";
        return viewUrl; 
    }
    
    //actulizar datos del estudiante (Preguntar)
    public String update(HttpServletRequest request){
        return this.updateAction(request);
    }
    
    public String updateAction(HttpServletRequest request){
        String viewUrl="/Proyecto1/presentation/View.jsp";
        return viewUrl; 
    }
    
    //cursos del estudiante
    public String cursos(HttpServletRequest request){
        return this.cursosAction(request);
    }
    
    public String cursosAction(HttpServletRequest request){
        String viewUrl="/Proyecto1/presentation/View.jsp";
        return viewUrl; 
    }

    //historial del estudiante
    public String historial(HttpServletRequest request){
        return this.historialAction(request);
    }
    
    public String historialAction(HttpServletRequest request){
        String viewUrl="/Proyecto1/presentation/View.jsp";
        return viewUrl; 
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

