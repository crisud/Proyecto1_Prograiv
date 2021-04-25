/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.crud.MatriculaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cristopher
 */
public class MatriculaDAO extends AbstractDAO<database.entidades.Matricula>
{
    public MatriculaDAO()
    {
        super(new MatriculaCRUD());
    }
    
    @Override
    public database.entidades.Matricula getRecord(ResultSet rs) throws SQLException
    {
        return new database.entidades.Matricula(
                rs.getString("id_estudiante"),
                rs.getString("id_grupo"),
                rs.getDouble("nota")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, database.entidades.Matricula value) throws SQLException
    {
        stm.setString(1, value.getId_estudiante());
        stm.setString(2, value.getId_grupo());
        stm.setDouble(3, value.getNota());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, database.entidades.Matricula value) throws SQLException
    {
        stm.setDouble(1, value.getNota());
        stm.setString(2, value.getId_estudiante());
        stm.setString(3, value.getId_grupo());
    }
}
