/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.Database;
import database.crud.CursoCRUD;
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
public class CursoDAO extends AbstractDAO<database.entidades.Curso>
{
    public CursoDAO()
    {
        super(new CursoCRUD());
    }
    
    @Override
    public database.entidades.Curso getRecord(ResultSet rs) throws SQLException
    {
        return new database.entidades.Curso(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getString("tematica"),
                rs.getDouble("precio"),
                rs.getBoolean("enOferta")
                
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, database.entidades.Curso value) throws SQLException
    {
        stm.setString(1, value.getId());
        stm.setString(2, value.getNombre());
        stm.setString(3, value.getTematica());
        stm.setDouble(4, value.getPrecio());
        stm.setBoolean(5, value.getEnOferta());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, database.entidades.Curso value) throws SQLException
    {
        stm.setString(1, value.getId());
    }
    
    public List<database.entidades.Curso> listarCursosEnOferta() throws SQLException, IOException
    {
        List<database.entidades.Curso> lista = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(LIST_CURSOS_EN_OFERTA_CMD))
        {
            while (rs.next()) 
            {
                lista.add(getRecord(rs));
            }
        }
            
        return lista;
    }
    
    protected static final String LIST_CURSOS_EN_OFERTA_CMD =
            "SELECT id, nombre, tematica, precio, enOferta FROM proyecto1.cursos " 
            + "WHERE enOferta = 1 "
            + "ORDER BY id; ";
}
