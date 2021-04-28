/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author cristopher
 */
public class Database extends MysqlDataSource {

    private Database() throws IOException {
        this.configuration = new Properties();
        configuration.load(getClass().getResourceAsStream(CONFIGURATION_PATH));

        setURL(String.format("%s//%s/%s",
                this.configuration.getProperty("protocol"),
                this.configuration.getProperty("server_url"),
                this.configuration.getProperty("database")
        ));
        setUser(this.configuration.getProperty("user"));
        setPassword(this.configuration.getProperty("password"));
    }

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    public static Database getInstance() throws IOException {
        if (instance == null) {
            try {
                instance = new Database();
            } catch (IOException ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
                throw ex;
            }
        }
        return instance;
    }

    private static final String CONFIGURATION_PATH = "db.properties";
    private static Database instance = null;
    private Properties configuration = null;
}
