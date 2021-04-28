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
import java.util.List;

/**
 *
 * @author cristopher
 */
public class GrupoFactory
{
    public static cursos.logic.Grupo recuperarGrupo(String id) throws SQLException, IOException
    {
        cursos.logic.Grupo grupo;

        database.entidades.Grupo aux = grupoDAO.buscar(id);

        grupo = crearGrupo(aux);
        
        return grupo;
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
            
            List<cursos.logic.Estudiante> estu = MatriculaFactory.recuperarEstuMatricula(g.getId());
            
            for(cursos.logic.Estudiante e: estu)
            {
                g.ingresarEstudiantes(e);
            }
        }

        return g;
    }
    private static final GrupoDAO grupoDAO = new GrupoDAO();
}
