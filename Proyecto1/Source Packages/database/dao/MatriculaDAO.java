/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.AbstractDAO;
import database.Database;
import database.crud.MatriculaCRUD;
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
    
    public List<database.entidades.Matricula> ListarIDGrupo(String id_grupo) throws SQLException, IOException
    {
        List<database.entidades.Matricula> r = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(LIST_ID_GRUPO_CMD)) {
            stm.clearParameters();
            stm.setString(1, id_grupo);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(getRecord(rs));
                }
            }
        }
        return r;
    }
    
    public List<database.entidades.Matricula> ListarIDEstudiante(String id_estudiante, String id_grupo) throws SQLException, IOException
    {
        List<database.entidades.Matricula> r = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(LIST_ID_ESTUDIANTE_AND_ID_GRUPO_CMD)) {
            stm.clearParameters();
            stm.setString(1, id_estudiante);
            stm.setString(2, id_grupo);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(getRecord(rs));
                }
            }
        }
        return r;
    }
    
    
     
    public void actualizarMatri(Double nota, String id_grupo, String id_estu) throws SQLException, IOException
    {
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getUpdateCmd())) {
            stm.clearParameters();
            stm.setDouble(1, nota);
            stm.setString(2, id_estu);
            stm.setString(3, id_grupo);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    protected static final String LIST_ID_GRUPO_CMD
            = "SELECT id_estudiante, id_grupo, nota FROM proyecto1.estudiantes_grupos "
            + "WHERE id_grupo = ?; ";
    
    protected static final String LIST_ID_ESTUDIANTE_AND_ID_GRUPO_CMD
            = "SELECT id_estudiante, id_grupo, nota FROM proyecto1.estudiantes_grupos "
            + "WHERE id_estudiante = ? AND id_grupo = ?; ";
}
