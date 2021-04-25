/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entidades;

/**
 *
 * @author cristopher
 */
public class Usuario
{
    public Usuario(String id, String nombre, String contrasena, String correo, int telefono, String especialidad, String rol)
    {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.rol = rol;
    }
    
    public String getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public String getCorreo()
    {
        return correo;
    }

    public int getTelefono()
    {
        return telefono;
    }

    public String getEspecialidad()
    {
        return especialidad;
    }

    public String getRol()
    {
        return rol;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }

    public void setEspecialidad(String especialidad)
    {
        this.especialidad = especialidad;
    }

    public void setRol(String rol)
    {
        this.rol = rol;
    }
    
    
    private String id;
    private String nombre;
    private String contrasena;
    private String correo;
    private int telefono;
    private String especialidad;
    private String rol;
}
