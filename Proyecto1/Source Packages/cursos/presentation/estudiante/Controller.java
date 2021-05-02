/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.estudiante;

import cursos.logic.Curso;
import cursos.logic.Estudiante;
import cursos.logic.Matricula;
import cursos.logic.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Calef
 */
@WebServlet(name = "EstudianteController", urlPatterns = {"/presentation/estudiante/datos","/presentation/estudiante/detalla",
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
            case "/presentation/estudiante/detalla":
                viewUrl=this.detalles(request);
                break;
            case "/presentation/estudiante/cursos":
                viewUrl=this.cursos(request);
                break;
            default: viewUrl = "/presentation/person/estudiante.jsp"; break;
            
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 

        }
    
//datos del estudiante
     public String datos(HttpServletRequest request){
        return this.datosAction(request);
    }
    
    public String datosAction(HttpServletRequest request){
        try {
            HttpSession session = request.getSession(true);
            Usuario usua = (Usuario) session.getAttribute("usuario");
           
            
            //Aqui iría la recuperacion con la base de datos
            cursos.logic.Model  domainModel = cursos.logic.Model.instance();
            Usuario usu = domainModel.usuarioFind(usua.getId()); //Tiene que ser estudianteFind
            
            String id =  usu.getId();
            String name =  usu.getNombre();
            String pass =  usu.getPass();
            String email =  usu.getCorreo();
            Integer tel =  usu.getTelefono();

            Estudiante estudiante = new Estudiante(id,pass,"Estudiante",name,email, tel);
            Model mo = new Model();
            mo.setCurrent(estudiante);
            request.setAttribute("modelEstu", mo);

            String viewUrl="/presentation/estudiante/datos/datos.jsp";
            return viewUrl;
        
        } catch (Exception e) {
            String viewUrl="/presentation/Error.jsp";
            return viewUrl; 
        }
       
    }
    
    //actulizar datos del estudiante (Preguntar) //ño ñacer
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
       try {
            HttpSession session = request.getSession(true);
            Usuario usua = (Usuario) session.getAttribute("usuario");
            String id = usua.getId();
            
            //Aqui iría la recuperacion con la base de datos
            cursos.logic.Model  domainModel = cursos.logic.Model.instance();
            List<Matricula> matriculas = domainModel.getMatriculas(id); //Tiene que ser base
            
            request.setAttribute("listaCursos", matriculas);

            String viewUrl="/presentation/estudiante/cursos/cursos.jsp";
            return viewUrl;
        
        } catch (Exception e) {
            String viewUrl="/presentation/Error.jsp";
            return viewUrl; 
        }
    }

    //detalles del curso
    public String detalles(HttpServletRequest request) {
        return this.detallesAction(request);
    }
    
    public String detallesAction(HttpServletRequest request){
        try {
            String id = (String) request.getParameter("curso");
            cursos.logic.Model  domainModel = cursos.logic.Model.instance();
            Curso cur = domainModel.getCurso(id); 

            request.setAttribute("cur", cur);
            String viewUrl="/presentation/estudiante/detalla/detalla.jsp";
            return viewUrl;
        
        } catch (IOException | SQLException e) {
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
}

