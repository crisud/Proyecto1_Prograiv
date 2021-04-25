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
public class Persona {
    private String cedula;
    private String nombre;
    private Usuario usuario;
    private String correo;
    private Integer telefono;

    public Persona(String cedula, String nombre, Usuario usuario, String correo, Integer telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.telefono = telefono;
    }

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    public String getTipoCuenta(){
        return getUsuario().getTipo();
    }
    
}
