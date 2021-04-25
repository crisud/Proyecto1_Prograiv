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
public class UsuarioCRUD extends AbstractCRUD
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
            = "SELECT id, nombre, correo, telefono, rol, especialidad FROM proyecto1.usuarios "
            + "ORDER BY id; "; // mostrar contra?
    protected static final String ADD_CMD
            = "INSERT INTO proyecto1.usuarios (id, nombre, contrasena, correo, telefono, especialidad, rol) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); "; 
    protected static final String RETRIEVE_CMD
            = "SELECT id, nombre, contrasena, correo, telefono, especialidad, rol FROM proyecto1.usuarios "
            + "WHERE id = ?; ";
    protected static final String UPDATE_CMD // necesario??
            = "UPDATE proyecto1.usuarios SET nombre = ?, correo = ?, telefono = ? "
            + "WHERE id = ?; ";
}
