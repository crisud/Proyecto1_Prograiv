/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador.grupo;

import cursos.logic.Curso;
import cursos.logic.Grupo;
import cursos.logic.Profesor;
import database.entidades.CursoFactory;
import database.entidades.GrupoFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        request.setAttribute("model", new Model());

        switch (request.getServletPath()) // crear grupo - y ver grupos
        {
            case "/presentation/administrador/grupos/show":
                viewUrl = this.showGrupos(request);
                break;
            case "/presentation/administrador/grupos/create/show": //id curso por parametro
                viewUrl = this.showCreateGrupos(request);
                break;
            case "/presentation/administrador/grupos/create/update": //create
                viewUrl = this.updateCreateGrupos(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String showGrupos(HttpServletRequest request)
    {
        return this.showGruposAction(request);
    }

    public String showGruposAction(HttpServletRequest request)
    {
        String viewUrl;

        try
        {
            HttpSession session = request.getSession(true);

            Model model = (Model) request.getAttribute("model");

            String idCurso = request.getParameter("cursoId");
            Curso curso = CursoFactory.recuperarCurso(idCurso);
            List<Grupo> grupos = GrupoFactory.listarGruposPorIDCurso(idCurso);

            model.setCurso(curso);

            request.setAttribute("grupos", grupos);
            session.setAttribute("curso", curso);

            viewUrl = "/presentation/administrador/grupos/cursosGrupos.jsp";
        } catch (Exception ex)
        {
            viewUrl = "/presentation/Error.jsp";
        }
        return viewUrl;
    }

    public String showCreateGrupos(HttpServletRequest request)
    {
        return this.showCreateGruposAction(request);

    }

    public String showCreateGruposAction(HttpServletRequest request) // id por parametro (anchor)
    {
        String viewUrl;

        try
        {
            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);

            
            List<Profesor> profes = domainModel.getProfesores();
            session.setAttribute("profes", profes);

            String cursoID = request.getParameter("cursoId");
            Curso curso = CursoFactory.recuperarCurso(cursoID);
            model.setCurso(curso);
            session.setAttribute("curso", curso);//recuperar en update

            viewUrl = "/presentation/administrador/grupos/grupos.jsp";
        } catch (IOException | SQLException ex)
        {
            viewUrl = "/presentation/Error.jsp";
        }
        return viewUrl;

    }

    public String updateCreateGrupos(HttpServletRequest request)
    {
        return this.updateCreateGruposAction(request);
    }

    public String updateCreateGruposAction(HttpServletRequest request)
    {
        String viewUrl;

        try
        {
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);

            Curso curso = (Curso) session.getAttribute("curso");
            model.setCurso(curso);
            Map<String, String> errores = this.validar(request);

            if (errores.isEmpty())
            {
                this.updateModel(request);
                viewUrl = this.createAction(request);
            }
            else
            {
                request.setAttribute("errores", errores);
                viewUrl = "/presentation/administrador/grupos/grupos.jsp";
            }
        } catch (Exception ex)
        {
            viewUrl = "/presentation/Error.jsp";
        }
        return viewUrl;
    }

    public Map<String, String> validar(HttpServletRequest request)
    {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("grupoID").isEmpty())
        {
            errores.put("grupoID", "ID del grupo requerido");
        }

        if (request.getParameter("profesorID").isEmpty())
        {
            errores.put("profesorID", "Profesor requerido");
        }

        if (request.getParameter("horario").isEmpty())
        {
            errores.put("horario", "Horario requerido");
        }

        return errores;
    }

    public void updateModel(HttpServletRequest request) throws Exception
    {
        Model model = (Model) request.getAttribute("model");
        cursos.logic.Model domainModel = cursos.logic.Model.instance();

        Profesor profe = (Profesor) domainModel.usuarioFind((request.getParameter("profesorID")));
        String cursoID = request.getParameter("cursoID");
        Curso curso = CursoFactory.recuperarCurso(cursoID);
        String horario = request.getParameter("horario");
        String id = request.getParameter("grupoID");
        model.setGrupo(new Grupo(
                id,
                horario,
                profe,
                curso
        ));
    }

    public String createAction(HttpServletRequest request)
    {
        Model model = (Model) request.getAttribute("model");
        cursos.logic.Model domainModel = cursos.logic.Model.instance();

        try
        {
            domainModel.insertGrupo(model.getGrupo());
            return "/presentation/person/administrador.jsp";//cambiar
        } catch (IOException | SQLException ex)
        {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("grupoID", "cursoID, profesorID, horario incorrectos");
            return "/presentation/administrador/grupos/grupos.jsp";
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
