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

    public static List<cursos.logic.Estudiante> recuperarEstuMatricula(String id_grupo)
            throws SQLException, IOException //recuperar estu en base del grupo - falta recuperar matri con estu
    {
        List<cursos.logic.Estudiante> estu = new ArrayList<>();
        List<database.entidades.Matricula> matriculas= matriculaDAO.ListarIDGrupo(id_grupo);
        
        for (database.entidades.Matricula m : matriculas)
        {
            estu.add((Estudiante) UsuarioFactory.recuperarUsuario(m.getId_estudiante())); 
        }

        return estu;
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


    private static final MatriculaDAO matriculaDAO = new MatriculaDAO();
}
