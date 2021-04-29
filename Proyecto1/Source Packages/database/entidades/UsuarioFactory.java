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

/**
 *
 * @author cristopher
 */
public class UsuarioFactory
{

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
                        "Administrador");
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
    // String id, String nombre, String contrasena, String correo, int telefono, String especialidad, String rol

    private final static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final static GrupoDAO grupoDAO = new GrupoDAO();
}
