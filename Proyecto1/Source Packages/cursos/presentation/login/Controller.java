/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.login;

import cursos.logic.Usuario;
import java.io.IOException;
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
 * @author Calef
 */
@WebServlet(name = "LoginController", urlPatterns = {"/presentation/login/show","/presentation/login/login","/presentation/login/logout","/presentation/login/signup"})
public class Controller extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/login/show":
                viewUrl=this.show(request);
                break;              
            case "/presentation/login/login":
                viewUrl=this.login(request);
                break;            
            case "/presentation/login/logout":
                viewUrl=this.logout(request);
                break;
            case "/presentation/login/signup":
                viewUrl=this.signup(request);
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

 //metodos para el logon, valida errores y actualiza los campos del usuario actual para enviarlo
    private String login(HttpServletRequest request) { 
        try{
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return this.loginAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/login/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }         
    }
    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("cedulaFld").isEmpty()){
            errores.put("cedulaFld","Cedula requerida");
        }

        if (request.getParameter("claveFld").isEmpty()){
            errores.put("claveFld","Clave requerida");
        }
        return errores;
    }
    

    void updateModel(HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setId(request.getParameter("cedulaFld"));
        model.getCurrent().setPass(request.getParameter("claveFld"));
   }

//busqueda con la base de datos  
    public String loginAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        cursos.logic.Model  domainModel = cursos.logic.Model.instance();
        HttpSession session = request.getSession(true);
        try {
            Usuario real = domainModel.usuarioFind(model.getCurrent().getId(),model.getCurrent().getPass());
            session.setAttribute("usuario", real);
            String viewUrl="";
            switch(real.getTipo()){
                case "Estudiante":
                    viewUrl="/presentation/estudiante/estudiante.jsp";
                    break;
                case "":
                     viewUrl="";
                    break;             
            }
            return viewUrl;
            
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld","Usuario o clave incorrectos");
            errores.put("noexiste","si");
            return "/presentation/login/View.jsp"; 
        }        
    }  

//salir de la sesion
    public String logout(HttpServletRequest request){
        return this.logoutAction(request);
    }
    
    public String logoutAction(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/Index.jsp";   
    }

    
//inicio de sesion
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        //Model model= (Model) request.getAttribute("model");
        
        
        return "/presentation/login/View.jsp"; 
    }    
  
//crear usuario
    public String signup(HttpServletRequest request){
        return this.signupAction(request);
    }
    
    public String signupAction(HttpServletRequest request){
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setPass(pass);
        usuario.setTipo("Estudiante");
        cursos.logic.Model  domainModel = cursos.logic.Model.instance();
        domainModel.insertUser(usuario);
        return "/presentation/Index.jsp"; 
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
