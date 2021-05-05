/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.estudiante;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.sun.javafx.font.FontFactory;
import cursos.logic.Curso;
import cursos.logic.Estudiante;
import cursos.logic.Grupo;
import cursos.logic.Matricula;
import cursos.logic.Usuario;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "EstudianteController", urlPatterns = {"/presentation/estudiante/datos", "/presentation/estudiante/detalla",
    "/presentation/estudiante/matricular", "/presentation/estudiante/cursos" , "/presentation/estudiante/imprime"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("modelEstu", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/estudiante/datos":
                viewUrl = this.datos(request);
                break;
            case "/presentation/estudiante/matricular":
                viewUrl = this.matricular(request);
                break;
            case "/presentation/estudiante/detalla":
                viewUrl = this.detalles(request);
                break;
            case "/presentation/estudiante/cursos":
                viewUrl = this.cursos(request);
                break;
            case "/presentation/estudiante/imprime":
                viewUrl = this.imprime(request, response);
                break;
            default:
                viewUrl = "/presentation/person/estudiante.jsp";
                break;

        }
        request.getRequestDispatcher(viewUrl).forward(request, response);

    }

//datos del estudiante
    public String datos(HttpServletRequest request) {
        return this.datosAction(request);
    }

    public String datosAction(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            Usuario usua = (Usuario) session.getAttribute("usuario");

            //Aqui iría la recuperacion con la base de datos
            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            Usuario usu = domainModel.usuarioFind(usua.getId()); //Tiene que ser estudianteFind

            String id = usu.getId();
            String name = usu.getNombre();
            String pass = usu.getPass();
            String email = usu.getCorreo();
            Integer tel = usu.getTelefono();

            Estudiante estudiante = new Estudiante(id, pass, "Estudiante", name, email, tel);
            Model mo = new Model();
            mo.setCurrent(estudiante);
            request.setAttribute("modelEstu", mo);

            String viewUrl = "/presentation/estudiante/datos/datos.jsp";
            return viewUrl;

        } catch (Exception e) {
            String viewUrl = "/presentation/Error.jsp";
            return viewUrl;
        }

    }

    //actulizar datos del estudiante (Preguntar) //ño ñacer
    public String matricular(HttpServletRequest request) {
        return this.matricularAction(request);
    }

    public String matricularAction(HttpServletRequest request) {
        try {
            //Obtengo el estudiante y el id del grupo seleccionado
            HttpSession session = request.getSession(true);
            Usuario usua = (Usuario) session.getAttribute("usuario");
            String idGrupo = (String) request.getParameter("grupo");
            
            if("default".equals(idGrupo)){
                request.setAttribute("error", "No se pudo realizar la matricula, Horario no seleccionado");
                String viewUrl = "/presentation/estudiante/detalla/mensaje.jsp";
                return viewUrl;
            }

            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            Grupo gru = domainModel.getGrupo(idGrupo);

            Matricula m = new Matricula((Estudiante) usua, gru, 0.0);
            domainModel.insertMatricula(m);
            request.setAttribute("error", "La matricula de este curso se realizo con exito!");
            String viewUrl = "/presentation/estudiante/detalla/mensaje.jsp";
            return viewUrl;

        } catch (IOException | SQLException e) {
            request.setAttribute("error", "No se pudo realizar la matricula, Curso ya matriculado");
            String viewUrl = "/presentation/estudiante/detalla/mensaje.jsp";
            return viewUrl;
        }

    }

    //cursos del estudiante
    public String cursos(HttpServletRequest request) {
        return this.cursosAction(request);
    }

    public String cursosAction(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            Usuario usua = (Usuario) session.getAttribute("usuario");
            String id = usua.getId();

            //Aqui iría la recuperacion con la base de datos
            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            List<Matricula> matriculas = domainModel.getMatriculas(id); //Tiene que ser base

            request.setAttribute("listaCursos", matriculas);

            String viewUrl = "/presentation/estudiante/cursos/cursos.jsp";
            return viewUrl;

        } catch (Exception e) {
            String viewUrl = "/presentation/Error.jsp";
            return viewUrl;
        }
    }

    //detalles del curso
    public String detalles(HttpServletRequest request) {
        return this.detallesAction(request);
    }

    public String detallesAction(HttpServletRequest request) {
        try {
            //Obtengo el curso
            String id = (String) request.getParameter("curso");
            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            Curso cur = domainModel.getCurso2(id);

            //obtengo los cursos disponibles de
            List<Grupo> grupos = domainModel.getGruposCurso(id);

            request.setAttribute("cur", cur);
            request.setAttribute("gru", grupos);
            String viewUrl = "/presentation/estudiante/detalla/detalla.jsp";
            return viewUrl;

        } catch (IOException | SQLException e) {
            String viewUrl = "/presentation/Error.jsp";
            return viewUrl;
        }

    }
    
    
    private String imprime(HttpServletRequest request,  HttpServletResponse response) throws IOException {  
        try {
            
            HttpSession session = request.getSession(true);
            Usuario usua = (Usuario) session.getAttribute("usuario");
            String id = usua.getId();
            String nom = usua.getNombre();
            
            cursos.logic.Model domainModel = cursos.logic.Model.instance();
            List<Matricula> matriculas = domainModel.getMatriculas(id);
            
            PdfDocument pdf = new PdfDocument(new PdfWriter(response.getOutputStream()));
            Document doc = new Document(pdf, PageSize.A4.rotate());
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            PdfFont font1 = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont font2 = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLDOBLIQUE);
            
            
            doc.add(new Paragraph(" Cursos Libres ").setFont(font1).setFontSize(20).setFontColor(ColorConstants.BLUE)); 
            doc.add(new Paragraph("")); 
            doc.add(new Paragraph(" Certificado de matriculas del estudiante").setFont(font2).setFontSize(16)); 
            doc.add(new Paragraph("")); 
            
            doc.add(new Paragraph(" Estudiante: "+ nom + " -  ID: " + id).setFont(font1).setFontSize(14)); 
            doc.add(new Paragraph("")); 

            for(Matricula ma: matriculas){
                doc.add(new Paragraph("")); 
                doc.add(new Paragraph(" -   Curso: "+ ma.getGrupo().getNombreCurso() + "      ||     ID: " + ma.getGrupo().getId()).setFont(font).setFontColor(ColorConstants.DARK_GRAY)); 
                doc.add(new Paragraph("     Profesor: "+ ma.getGrupo().getNomProfesor() ).setFont(font)); 
                doc.add(new Paragraph("     Nota: "+ ma.getNota() ).setFont(font)); 
                doc.add(new Paragraph("")); 
            }   
  
            doc.close();
            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "inline");
            return null;
        } catch (IOException ex) {
            return "/presentation/Error.jsp";
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
