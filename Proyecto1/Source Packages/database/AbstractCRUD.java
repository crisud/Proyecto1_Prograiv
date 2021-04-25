/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author cristopher
 */  

public abstract class AbstractCRUD {

    public abstract String getListAllCmd();

    public abstract String getAddCmd();

    public abstract String getRetrieveCmd();

    public abstract String getUpdateCmd();
}
