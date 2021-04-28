/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristopher
 */
public class CursoFactory
{
    public static List<cursos.logic.Curso> listarCursos()
    {
        List<cursos.logic.Curso> cursos = new ArrayList<>();
        
        try
        {
            for(database.entidades.Curso c: cursoDAO.listarTodos())
            {
                cursos.add(crearCurso(c));
            }
        }
        catch(IOException | SQLException ex)
        {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
                
        return cursos;
    }
    
    public static cursos.logic.Curso recuperarCurso(String id) throws SQLException, IOException
    {
        cursos.logic.Curso curso;

        database.entidades.Curso aux = cursoDAO.buscar(id);

        curso = crearCurso(aux);
        return curso;
    }

    public static cursos.logic.Curso crearCurso(database.entidades.Curso curso) throws SQLException, IOException
    {
        cursos.logic.Curso c = null;

        if (curso != null)
        {
            List<cursos.logic.Grupo> grupos = new ArrayList<>();

            c = new cursos.logic.Curso(
                    curso.getId(),
                    curso.getNombre(),
                    curso.getTematica(),
                    curso.getPrecio(),
                    curso.getEnOferta()
            );
        }
        return c;
    }


    public static void main(String[] args)
    {
        List<cursos.logic.Curso> cursos = null;
       
        cursos = listarCursos();
        
        if (cursos != null)
        {
            for(cursos.logic.Curso curso: cursos)
            System.out.printf("Curso id: %s%n",curso.getId());
            
        }
    }


    private final static database.dao.GrupoDAO grupoDAO = new database.dao.GrupoDAO();
    private final static database.dao.CursoDAO cursoDAO = new database.dao.CursoDAO();
}
