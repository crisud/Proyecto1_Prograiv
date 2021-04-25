/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.crud.CursoCRUD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
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
        stm.setString(1, value.getNombre());
        stm.setString(2, value.getTematica());
        stm.setDouble(3, value.getPrecio());
        stm.setBoolean(4, value.getEnOferta());
        stm.setString(5, value.getId());
    }
    
    public static void main(String[] args)
    {
        //new Usuario_DAO().add(u.getNombre(), new modelo.entidades.Usuario(u.getNombre(),
                //u.getNombreCompleto(), u.getClave(), u.getUltimoAcceso()));
        
        CursoDAO curso = new CursoDAO();
        
        //database.entidades.Curso enti = new database.entidades.Curso("id1", "nombre1", "tematica1", 233, true);
       // try
        //{
        //    curso.registar(enti);
        //}catch(IOException | SQLException ex)
        //{
        //    System.err.println(ex.getMessage());
       // }
        database.entidades.Curso enti = null;
       try
        {
           enti = curso.buscar("id1");
        }catch(IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
       
       if(enti != null)
           System.out.println("encontrado");
    }
}
