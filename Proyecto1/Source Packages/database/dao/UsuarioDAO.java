/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.Database;
import database.crud.UsuarioCRUD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristopher
 */
public class UsuarioDAO extends AbstractDAO<database.entidades.Usuario>
{
    public UsuarioDAO()
    {
        super(new UsuarioCRUD());
    }
    
    @Override
    public database.entidades.Usuario getRecord(ResultSet rs) throws SQLException
    {
        return new database.entidades.Usuario(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getString("contrasena"),
                rs.getString("correo"),
                rs.getInt("telefono"),
                rs.getString("especialidad"),
                rs.getString("rol")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, database.entidades.Usuario value) throws SQLException
    {
        stm.setString(1, value.getId());
        stm.setString(2, value.getNombre());
        stm.setString(3, value.getContrasena());
        stm.setString(4, value.getCorreo());
        stm.setInt(5, value.getTelefono());
        stm.setString(6, value.getEspecialidad());
        stm.setString(7, value.getRol());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, database.entidades.Usuario value) throws SQLException
    {
        stm.setString(1, value.getNombre());
        stm.setString(2, value.getCorreo());
        stm.setInt(3, value.getTelefono());
        stm.setString(4, value.getId());
    }
    
    public List<database.entidades.Usuario> listarProfesores() throws SQLException, IOException
    {
        List<database.entidades.Usuario> lista = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(LISTAR_PROFES_CMD))
        {
            while (rs.next()) 
            {
                lista.add(getRecord(rs));
            }
        }
            
        return lista;
    }
    
    
     protected static final String LISTAR_PROFES_CMD
            = "SELECT id, nombre, correo, contrasena, telefono, rol, especialidad FROM proyecto1.usuarios "
            + "WHERE rol = 'Profesor' "
            + "ORDER BY id; ";
}
