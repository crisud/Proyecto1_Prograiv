/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.logic;

/**
 *
 * @author Hp
 */
public class Usuario {

    private String id;
    private String pass;
    private String role;
    private String nombre;
    private String correo;
    private Integer telefono;

    public Usuario(String id, String pass, String role, String nombre, String correo, Integer telefono) {

        this.id = id;
        this.pass = pass;
        this.role = role;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Usuario() {

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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

  

}
