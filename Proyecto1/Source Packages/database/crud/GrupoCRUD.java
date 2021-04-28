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
public class GrupoCRUD extends AbstractCRUD
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
            = "SELECT id, id_profesor, id_curso, horario FROM proyecto1.grupos "
            + "ORDER BY id; ";
    protected static final String ADD_CMD
            = "INSERT INTO proyecto1.grupos (id, id_profesor, id_curso, horario) "
            + "VALUES (?, ?, ?, ?); "; 
    protected static final String RETRIEVE_CMD
            = "SELECT id, id_profesor, id_curso, horario FROM proyecto1.grupos "
            + "WHERE id = ?; ";
    protected static final String UPDATE_CMD // necesario??
            = "UPDATE proyecto1.grupos SET horario = ? "
            + "WHERE id = ?; ";
}
