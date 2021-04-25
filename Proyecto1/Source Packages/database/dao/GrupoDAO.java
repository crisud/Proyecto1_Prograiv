/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.crud.GrupoCRUD;
import database.entidades.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cristopher
 */
public class GrupoDAO extends AbstractDAO<database.entidades.Grupo>
{
    public GrupoDAO()
    {
        super(new GrupoCRUD());
    }
    
    
    @Override
    public database.entidades.Grupo getRecord(ResultSet rs) throws SQLException
    {
        return new database.entidades.Grupo(
                rs.getString("id"),
                rs.getString("id_profesor"),
                rs.getString("id_curso"),
                rs.getString("horaio")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, database.entidades.Grupo value) throws SQLException
    {
        stm.setString(1, value.getId());
        stm.setString(2, value.getId_profesor());
        stm.setString(3, value.getId_curso());
        stm.setString(4, value.getHorario());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, database.entidades.Grupo value) throws SQLException
    {
        stm.setString(1, value.getHorario());
        stm.setString(2, value.getId());
    }
}
