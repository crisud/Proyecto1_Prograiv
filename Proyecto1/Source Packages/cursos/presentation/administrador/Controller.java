/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador;

import cursos.logic.Curso;
import cursos.logic.Grupo;
import cursos.logic.Profesor;
import database.entidades.CursoFactory;
import database.entidades.GrupoFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        request.setAttribute("model", new Model());

        switch (request.getServletPath()) // crear grupo - y ver grupos
        {
            case "/presentation/administrador/cursos/show":
                viewUrl = this.cursos(request);
                break;
            case "/presentation/administrador/profesores/show":
                viewUrl = this.profesores(request);
                break;
            case "/presentation/administrador/cursos/update":
                viewUrl = this.updateCurso(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String cursos(HttpServletRequest request)
    {
        return this.cursosAction(request);
    }

    private String cursosAction(HttpServletRequest request)
    {
        String viewUrl;
        try
        {
            //HttpSession session = request.getSession(true);

            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            List<Curso> cursos = domainModel.getCursos();
            Model model = (Model) request.getAttribute("model");
            model.setCursos(cursos);

            //session.setAttribute("model", model); //puede quitarse
            viewUrl = "/presentation/administrador/cursos/cursos.jsp";

            return viewUrl;
        } catch (Exception e)
        {
            viewUrl = "/presentation/Error.jsp";
            return viewUrl;
        }

    }

    private String profesores(HttpServletRequest request)
    {
        return this.profesoresAction(request);
    }

    private String profesoresAction(HttpServletRequest request)
    {
        try
        {
            //HttpSession session = request.getSession(true);
            cursos.logic.Model domainModel = cursos.logic.Model.instance();

            Model model = (Model) request.getAttribute("model");
            List<Profesor> profesores = domainModel.getProfesores();

            model.setProfesores(profesores);

            //session.setAttribute("model", model); //puede quitarse
            String viewUrl = "/presentation/administrador/profesores/profesores.jsp";
            return viewUrl;
        } catch (Exception e)
        {
            String viewUrl = "/presentation/Error.jsp";
            return viewUrl;
        }
    }

    public String updateCurso(HttpServletRequest request)
    {
        return this.updateCursoAction(request);
    }


    public String updateCursoAction(HttpServletRequest request)
    {
        String viewUrl;
        try
        {
            //HttpSession session = request.getSession(true);
            Model model = (Model) request.getAttribute("model");

            String idCurso = request.getParameter("cursoId");
            CursoFactory.actualizarOfertaCurso(idCurso);

            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            List<Curso> cursos = domainModel.getCursos();

            model.setCursos(cursos);

            //request.setAttribute("model", model);
            viewUrl = "/presentation/administrador/cursos/cursos.jsp"; 

        } catch (IOException | SQLException ex)
        {
            viewUrl = "/presentation/Error.jsp";
        }
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
