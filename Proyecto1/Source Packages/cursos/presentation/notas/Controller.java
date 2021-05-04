/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.notas;

import cursos.logic.Estudiante;
import cursos.logic.Grupo;
import cursos.logic.Matricula;
import cursos.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "registroGrupos", urlPatterns = {"/presentation/profesor/estudiantes","/presentacion/profesor/registroNota","/presentacion/profesor/registroNota/update"})
public class Controller extends HttpServlet {

   
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       request.setAttribute("modelNotas", new cursos.presentation.estudiante.Model()); 
        
       String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/profesor/estudiantes":
                viewUrl=this.datosEstudiantes(request);
                break;              
            case "/presentacion/profesor/registroNota":
                viewUrl=this.registroNota(request);
                break; 
            case "/presentacion/profesor/registroNota/update":
                viewUrl=this.registroNotaUpdate(request);
                break;
            
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 

    }
     
    public String datosEstudiantes(HttpServletRequest request){
        return this.datosEstudiantesAction(request);
    }
    
    public String datosEstudiantesAction(HttpServletRequest request){
        try{
       
            cursos.logic.Model  domainModel = cursos.logic.Model.instance();
            String actual = (String) request.getParameter("id_grupo");
            List<Estudiante> group = domainModel.getEstGrupo(actual);
            List<Matricula> mats = domainModel.getMatriculas();
            request.setAttribute("EstGrupo",group);
            request.setAttribute("matriculas", mats);
            return "/presentation/profesor/notas.jsp";
        }
        catch (Exception e) {
            String viewUrl="/presentation/Error.jsp";
            return viewUrl; 
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
    public String registroNota(HttpServletRequest request){
        return this.registroNotaAction(request);
    }

    public String registroNotaAction(HttpServletRequest request){
        cursos.logic.Model  domainModel = cursos.logic.Model.instance();
        String actual = (String) request.getParameter("id_group");
        List<Estudiante> group = domainModel.getEstGrupo(actual);
        List<Matricula> mats = domainModel.getMatriculas();
        request.setAttribute("matriculas", mats);
        request.setAttribute("EstGrupo",group);
        return "/presentation/profesor/registro.jsp";
    }
    
    public String registroNotaUpdate(HttpServletRequest request){
        return this.registroNotaUpdateAction(request);
    }
    
    public String registroNotaUpdateAction(HttpServletRequest request){
        return "/Proyecto1/presentacion/profesor/notas.jsp";
    }
}


