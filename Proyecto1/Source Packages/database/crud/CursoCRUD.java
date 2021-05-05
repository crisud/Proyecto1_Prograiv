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
public class CursoCRUD extends AbstractCRUD
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
            = "SELECT id, nombre, tematica, precio, enOferta FROM proyecto1.cursos "
            + "ORDER BY id; ";
    protected static final String ADD_CMD
            = "INSERT INTO proyecto1.cursos (id, nombre, tematica, precio, enOferta) "
            + "VALUES (?, ?, ?, ?, ?); "; 
    protected static final String RETRIEVE_CMD
            = "SELECT id, nombre, tematica, precio, enOferta FROM proyecto1.cursos "
            + "WHERE id = ?; ";
    protected static final String UPDATE_CMD // necesario??
            = "UPDATE proyecto1.cursos SET enOferta = NOT enOferta "
            + "WHERE id = ?; ";
}
