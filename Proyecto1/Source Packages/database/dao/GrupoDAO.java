/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.Database;
import database.crud.GrupoCRUD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<database.entidades.Grupo> listAllIDCurso(String id_curso) throws SQLException, IOException {
        List<database.entidades.Grupo> r = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(LIST_ID_CURSO_CMD)) {
            stm.clearParameters();
            stm.setString(1, id_curso);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(getRecord(rs));
                }
            }
        }
        return r;
    }
    
    public List<database.entidades.Grupo> listAllIDProfe(String id_profe) throws SQLException, IOException {
        List<database.entidades.Grupo> r = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(LIST_ID_PROFE_CMD)) {
            stm.clearParameters();
            stm.setString(1, id_profe);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(getRecord(rs));
                }
            }
        }
        return r;
    }
    
    @Override
    public database.entidades.Grupo getRecord(ResultSet rs) throws SQLException
    {
        return new database.entidades.Grupo(
                rs.getString("id"),
                rs.getString("id_profesor"),
                rs.getString("id_curso"),
                rs.getString("horario")
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
    
    protected static final String LIST_ID_CURSO_CMD =
            "SELECT id, id_profesor, id_curso, horario FROM proyecto1.grupos " 
            + "WHERE id_curso = ? "
            + "ORDER BY id; ";
    
    protected static final String LIST_ID_PROFE_CMD =
            "SELECT id, id_profesor, id_curso, horario FROM proyecto1.grupos " 
            + "WHERE id_profesor = ? "
            + "ORDER BY id; ";
}
