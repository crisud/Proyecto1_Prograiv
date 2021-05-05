/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entidades;

import cursos.logic.Administrador;
import cursos.logic.Estudiante;
import cursos.logic.Profesor;
import database.dao.GrupoDAO;
import database.dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristopher
 */
public class UsuarioFactory
{
    public static List<cursos.logic.Profesor> listarProfesores()
    {
        List<cursos.logic.Profesor>  profesores = new ArrayList<>();
        
        
        try
        {
            for(database.entidades.Usuario p: usuarioDAO.listarProfesores())
            {
                profesores.add((Profesor) crearUsuario(p));
            }
        }
        catch(IOException | SQLException ex)
        {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return profesores;
    }
    

    public static cursos.logic.Usuario recuperarUsuario(String id) throws SQLException, IOException
    {
        cursos.logic.Usuario usuario;

        database.entidades.Usuario aux = usuarioDAO.buscar(id);

        usuario = crearUsuario(aux);
        return usuario;
    }

    public static cursos.logic.Usuario crearUsuario(database.entidades.Usuario usuario) throws SQLException, IOException
    {
        String rol = usuario.getRol();
        cursos.logic.Usuario u = null;

        switch (rol)
        {
            case "Administrador":
                u = new Administrador(usuario.getId(),
                        usuario.getContrasena(),
                        usuario.getRol(),
                        usuario.getNombre(),
                        usuario.getCorreo(),
                        usuario.getTelefono()
                );
                break;
            case "Profesor":
                //List<cursos.logic.Grupo> grupos = new ArrayList<>();
                u = new Profesor(usuario.getId(),
                        usuario.getContrasena(),
                        usuario.getRol(),
                        usuario.getNombre(),
                        usuario.getCorreo(),
                        usuario.getTelefono(),
                        usuario.getEspecialidad()
                );
                break;
            case "Estudiante":
                u = new Estudiante(usuario.getId(),
                        usuario.getContrasena(),
                        usuario.getRol(),
                        usuario.getNombre(),
                        usuario.getCorreo(),
                        usuario.getTelefono()
                );

                break;

        }
        return u;
    }

    public static void guardarUsuario(cursos.logic.Usuario usuario) throws SQLException, IOException
    {
        String rol = usuario.getTipo();
        database.entidades.Usuario u = null;
        switch (rol)
        {
            case "Administrador":
                u = new database.entidades.Usuario(usuario.getId(),
                        usuario.getNombre(),
                        usuario.getPass(),
                        usuario.getCorreo(),
                        usuario.getTelefono(),
                        null,
                        "Administrador");
            break;    
            case "Profesor":
                Profesor p = (Profesor) usuario;
                u = new database.entidades.Usuario(usuario.getId(),
                        usuario.getNombre(),
                        usuario.getPass(),
                        usuario.getCorreo(),
                        usuario.getTelefono(),
                        p.getEspecialidad(),
                        "Profesor");
            break; 
            case "Estudiante":
                u = new database.entidades.Usuario(usuario.getId(),
                        usuario.getNombre(),
                        usuario.getPass(),
                        usuario.getCorreo(),
                        usuario.getTelefono(),
                        null,
                        "Estudiante");
            break; 
        }
        usuarioDAO.registar(u);
    }
   

    private final static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final static GrupoDAO grupoDAO = new GrupoDAO();
    
    
//        public static void main(String[] args)
//    {
//        List<cursos.logic.Profesor> matri = null;
//       
//        matri = listarProfesores();
//        
//        if (matri != null)
//        {
//            for(cursos.logic.Profesor curso: matri)
//            System.out.printf("Matri id: %s%n",curso.getEspecialidad());
//            
//        }
//    }
}
