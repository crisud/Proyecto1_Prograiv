/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cristopher
 * @param <T>
 */
public interface DAO<T>
{
    List<T> listarTodos() throws SQLException, IOException;
    T buscar(String id) throws SQLException, IOException; 
    void registar(T t) throws SQLException, IOException;
    void actualizar(T t) throws SQLException, IOException;
}
