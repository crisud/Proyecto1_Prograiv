/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entidades;

import cursos.logic.Profesor;
import database.dao.GrupoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristopher
 */
public class GrupoFactory
{
    public static List<cursos.logic.Grupo> listarGrupos()
    {
        List<cursos.logic.Grupo> grupos = new ArrayList<>();
        
        try
        {
            for(database.entidades.Grupo g: grupoDAO.listarTodos())
            {
                grupos.add(crearGrupo(g));
            }
        }
        catch(IOException | SQLException ex)
        {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
                
        return grupos;
    }
    
    
    
    public static cursos.logic.Grupo recuperarGrupo(String id_grupo) throws SQLException, IOException
    {
        cursos.logic.Grupo grupo;

        database.entidades.Grupo aux = grupoDAO.buscar(id_grupo);

        grupo = crearGrupo(aux);
        
        return grupo;
    }
    
    public static List<cursos.logic.Grupo> recuperarGrupos_profe(String id_profesor) throws SQLException, IOException
    {
       
        List<cursos.logic.Grupo> grupos = listarGrupos(); //todas las matri de la base
        List<cursos.logic.Grupo> gruposAux = new ArrayList<>(); // se agrega las que el id del estu por buscar sea igual 
        
        for (cursos.logic.Grupo m : grupos)
        {
            if(m.getNomProfesor().equals(id_profesor))
                gruposAux.add(m);
        }

        return gruposAux;
    }
    
    public static cursos.logic.Grupo crearGrupo(database.entidades.Grupo grupo) 
        throws SQLException, IOException
    {
        cursos.logic.Grupo g = null;
        
        if(grupo != null)
        {
            g = new cursos.logic.Grupo(
                grupo.getId(),
                grupo.getHorario(),
                (Profesor) UsuarioFactory.recuperarUsuario(grupo.getId_profesor()),
                CursoFactory.recuperarCurso(grupo.getId_curso()) 
            );
            
            List<cursos.logic.Estudiante> estu = MatriculaFactory.recuperarEstudianteConIDGrupo(g.getId()); //necesario que estu tenga matri?
            
            for(cursos.logic.Estudiante e: estu)
            {
                g.ingresarEstudiantes(e);
            }
        }

        return g;
    }
    private static final GrupoDAO grupoDAO = new GrupoDAO();
}
