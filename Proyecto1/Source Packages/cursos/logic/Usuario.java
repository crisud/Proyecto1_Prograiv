/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.logic;

/**
 *
 * @author PC de Sebastian
 */
public class Usuario implements java.io.Serializable{
    private String id;
    private String pass;
    private String role;
    
    public Usuario(String id, String pass, String role) {
       this.id = id;
       this.pass = pass;
       this.role = role;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getTipo() {
        return this.role;
    }
    
    public void setTipo(String role) {
        this.role = role;
    }
}
