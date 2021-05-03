/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cristopher
 */
public class Controller extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String viewUrl = "";
        
        switch (request.getServletPath())
        {
            case "/presentation/administrador/cursos":
                viewUrl = this.cursos(request);
                break;
            case "/presentation/administrador/profesores":
                viewUrl = this.profesores(request);
                break;
        }
        
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }

    private String cursos(HttpServletRequest request)
    {
        return this.cursosAction(request);
    }
    
    private String cursosAction(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        
        
        return "";
    }
    
    private String profesores(HttpServletRequest request)
    {
        return this.profesoresAction(request);
    }
    
    private String profesoresAction(HttpServletRequest request)
    {
        return "";
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
