/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador.profesor;

import cursos.logic.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cris
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
            case "/presentation/administrador/profesor/create/show":
                viewUrl = this.showProfesor(request);
                break;
            case "/presentation/administrador/profesor/create/create":
                viewUrl = this.createProfesor(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String showProfesor(HttpServletRequest request)
    {
        return this.showProfesorAction(request);
    }

    public String showProfesorAction(HttpServletRequest request)
    {
        String viewUrl = "/presentation/administrador/profesores/createProfesor.jsp";

       
        return viewUrl;
    }


    public String createProfesor(HttpServletRequest request)
    {
        return this.createProfesorAction(request);
    }

    public String createProfesorAction(HttpServletRequest request)
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
            viewUrl = "/presentation/administrador/profesores/createProfesor.jsp";
        }

        return viewUrl;
    }


    public Map<String, String> validar(HttpServletRequest request)
    {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("profeID").isEmpty())
        {
            errores.put("profeID", "ID del profesor requerido");
        }

        if (request.getParameter("nombre").isEmpty())
        {
            errores.put("nombre", "Nombre requerido");
        }

        if (request.getParameter("correo").isEmpty())
        {
            errores.put("correo", "Correo requerido");
        }

        if (request.getParameter("contrasena").isEmpty())
        {
            errores.put("contrasena", "Contraseña requerido");
        }

        if (request.getParameter("telefono").isEmpty())
        {
            errores.put("telefono", "numero requerido");
        } else
        {
            int num;
            num = Integer.parseInt(request.getParameter("telefono"));
            if (num <= 0)
            {
                errores.put("telefono", "numero negativo");
            }
        }

        if (request.getParameter("especialidad").isEmpty())
        {
            errores.put("especialidad", "Especialidad requerida");
        }

        return errores;
    }


    public void updateModel(HttpServletRequest request)
    {
        Model model = (Model) request.getAttribute("model");

        Profesor profe;

        profe = new Profesor(
                request.getParameter("profeID"),
                request.getParameter("contrasena"),
                "Profesor",
                request.getParameter("nombre"),
                request.getParameter("correo"),
                Integer.parseInt(request.getParameter("telefono")),
                request.getParameter("especialidad")
        );
        model.setProfesor(profe);
    }

    public String createAction(HttpServletRequest request)
    {
        Model model = (Model) request.getAttribute("model");
        cursos.logic.Model domainModel = cursos.logic.Model.instance();

        try
        {
            domainModel.insertUser(model.getProfesor());
            return "/presentation/person/administrador.jsp";
        } catch (Exception ex)
        {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("profeID", "contrasena, nombre, correo, telefono incorrectos");
            return "/presentation/administrador/profesores/createProfesor.jsp";
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
