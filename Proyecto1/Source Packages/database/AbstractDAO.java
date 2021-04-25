/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
 * @param <T>
 */
public abstract class AbstractDAO<T> implements DAO<T>
{
    public AbstractDAO(AbstractCRUD crud)
    {
        this.crud = crud;
    }
    
    @Override
    public List<T> listarTodos() throws SQLException, IOException
    {
        List<T> lista = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(getCRUD().getListAllCmd()))
        {
            while (rs.next()) 
            {
                lista.add(getRecord(rs));
            }
        }
            
        return lista;
    }

    @Override
    public T buscar(String id) throws SQLException, IOException
    {
        T r = null;
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = getRecord(rs);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return r;
    }

    @Override
    public void registar(T t) throws SQLException, IOException
    {
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, t);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void actualizar(T t) throws SQLException, IOException
    {
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getUpdateCmd())) {
            stm.clearParameters();
            setUpdateParameters(stm, t);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }
   
    public abstract T getRecord(ResultSet rs) throws SQLException;

    public abstract void setAddParameters(PreparedStatement stm, T value)// puede incluirse el id
            throws SQLException;

    public abstract void setUpdateParameters(PreparedStatement stm, T value)// puede incluirse el id
            throws SQLException;

    public AbstractCRUD getCRUD() {
        return crud;
    }
    
    private final AbstractCRUD crud;
}