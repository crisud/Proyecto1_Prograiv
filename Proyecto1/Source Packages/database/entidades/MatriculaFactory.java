/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entidades;

import cursos.logic.Estudiante;
import database.dao.MatriculaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristopher
 */
public class MatriculaFactory
{

    public static void update(Double nota, String id_grupo, String id_estudiante) throws SQLException, IOException
    {
        matriculaDAO.actualizarMatri(nota, id_grupo, id_estudiante);
    }
    
    
    public static List<cursos.logic.Estudiante> recuperarEstudianteConIDGrupo(String id_grupo)
            throws SQLException, IOException //recuperar estu en base del grupo - (busca en las matriculas)
    {
        List<cursos.logic.Estudiante> estu = new ArrayList<>();
        List<database.entidades.Matricula> matriculas= matriculaDAO.ListarIDGrupo(id_grupo);
        
        for (database.entidades.Matricula m : matriculas)
        {
            estu.add((Estudiante) UsuarioFactory.recuperarUsuario(m.getId_estudiante())); 
        }

        return estu;
    }

    public static List<cursos.logic.Matricula> recuperarMatricula(String id_estudiante)
            throws SQLException, IOException //recuperar las matriculas del estu con su id 
    {
        List<cursos.logic.Matricula> matriculas = listarMatriculas(); //todas las matri de la base
        List<cursos.logic.Matricula> matriculasAux = new ArrayList<>(); // se agrega las que el id del estu por buscar sea igual 
        
        for (cursos.logic.Matricula m : matriculas)
        {
            if(m.getEstudiante().getId().equals(id_estudiante))
                matriculasAux.add(m);
        }

        return matriculasAux;
    }
    
    public static List<cursos.logic.Matricula> listarMatriculas()
    {
        List<cursos.logic.Matricula> matriculas = new ArrayList<>();
        
        try
        {
            for(database.entidades.Matricula m: matriculaDAO.listarTodos())
            {
                matriculas.add(crearMatricula(m));
            }
        }
        catch(IOException | SQLException ex)
        {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
                
        return matriculas;
    }
    
    
    public static cursos.logic.Matricula crearMatricula(database.entidades.Matricula matricula) throws SQLException, IOException
    {
        cursos.logic.Matricula matri = null;

        if (matricula != null)
        {
            matri = new cursos.logic.Matricula(
                    (Estudiante) UsuarioFactory.recuperarUsuario(matricula.getId_estudiante()),
                    GrupoFactory.recuperarGrupo(matricula.getId_grupo()),
                    matricula.getNota()
            );
        }

        return matri;
    }

     public static void guardarMatricular(cursos.logic.Matricula ma) throws SQLException, IOException
    {
      
        database.entidades.Matricula m = null;
        m = new database.entidades.Matricula(ma.getEstudiante().getId(), ma.getGrupo().getId(), 0);
        matriculaDAO.registar(m);
    }
     
//public static void main(String[] args)
//    {
//        List<cursos.logic.Matricula> matri = null;
//       
//        matri = listarMatriculas();
//        
//        if (matri != null)
//        {
//            for(cursos.logic.Matricula curso: matri)
//            System.out.printf("Matri id: %s%n",curso.getEstudiante().getNombre());
//            
//        }
//    }
    
    
    private static final MatriculaDAO matriculaDAO = new MatriculaDAO();
}
