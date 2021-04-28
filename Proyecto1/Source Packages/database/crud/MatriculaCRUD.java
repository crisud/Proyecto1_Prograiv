/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.crud;

import database.AbstractCRUD;

/**
 *
 * @author cristopher
 */
public class MatriculaCRUD extends AbstractCRUD
{
    @Override
    public String getListAllCmd()
    {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd()
    {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd()
    {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd()
    {
        return UPDATE_CMD;
    }
    
    protected static final String LIST_CMD
            = "SELECT id_estudiante, id_grupo, nota FROM proyecto1.estudiantes_grupos "
            + "ORDER BY id; ";
    protected static final String ADD_CMD
            = "INSERT INTO proyecto1.estudiantes_grupos (id_estudiante, id_grupo, nota) "
            + "VALUES (?, ?, ?); "; 
    protected static final String RETRIEVE_CMD
            = "SELECT id_estudiante, id_grupo, nota FROM proyecto1.estudiantes_grupos "
            + "WHERE id_estudiante = ? and id_grupo = ?; "; // id_estudiante and id_grupo??
    protected static final String UPDATE_CMD // necesario??
            = "UPDATE proyecto1.estudiantes_grupos SET nota = ? "
            + "WHERE id_estudiante = ? and id_grupo = ?; ";
}
