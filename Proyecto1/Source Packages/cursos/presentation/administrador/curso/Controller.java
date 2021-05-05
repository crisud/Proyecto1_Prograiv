/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador.curso;

import cursos.logic.Curso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
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
            case "/presentation/administrador/cursos/create/show":
                viewUrl = this.showCursos(request);
                break;
            case "/presentation/administrador/cursos/create/create":
                viewUrl = this.createCursos(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String showCursos(HttpServletRequest request)
    {
        return showCursosAction(request);
    }

    public String showCursosAction(HttpServletRequest request)
    {
        String viewUrl = "/presentation/administrador/cursos/createCursos.jsp";

        return viewUrl;

    }

    public String createCursos(HttpServletRequest request)
    {
        return createCursosAction(request);

    }


    public String createCursosAction(HttpServletRequest request)
    {
        String viewUrl;

        Map<String, String> errores = this.validar(request);

        if (errores.isEmpty())
        { 
            this.updateModel(request);
            viewUrl = this.createAction(request);
        } else
        {
            request.setAttribute("errores", errores);
            viewUrl = "/presentation/administrador/cursos/createCursos.jsp";
        }

        return viewUrl;
    }

    public Map<String, String> validar(HttpServletRequest request)
    {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("cursoID").isEmpty())
        {
            errores.put("cursoID", "ID del grupo requerido");
        }

        if (request.getParameter("nombre").isEmpty())
        {
            errores.put("nombre", "Nombre requerido");
        }

        if (request.getParameter("tematica").isEmpty())
        {
            errores.put("tematica", "Tematica requerido");
        }

        
        if (request.getParameter("precio").isEmpty())
        {
            errores.put("precio", "precio requerido");
        } else
        {
            int num;
            num = Integer.parseInt(request.getParameter("precio"));
            if (num <= 0)
            {
                errores.put("precio", "precio negativo");
            }
        }

        return errores;
    }

    public void updateModel(HttpServletRequest request)
    {
        Model model = (Model) request.getAttribute("model");
        boolean enOferta;
        enOferta = request.getParameter("oferta").equals("1");
        
        Curso curso = new Curso(
                request.getParameter("cursoID"),
                request.getParameter("nombre"),
                request.getParameter("tematica"),
                Integer.parseInt(request.getParameter("precio")),
                enOferta
        );
         
        model.setCurso(curso);     
    }
    
    public String createAction(HttpServletRequest request)
    {
        Model model = (Model) request.getAttribute("model");
        cursos.logic.Model domainModel = cursos.logic.Model.instance();
        
        try
        {
            domainModel.insertCurso(model.getCurso());
            return "/presentation/person/administrador.jsp";//cambiar
        } catch (IOException | SQLException ex)
        {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("grupoID", "cursoID, profesorID, horario incorrectos");
            return "/presentation/administrador/cursos/createCursos.jsp";
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
