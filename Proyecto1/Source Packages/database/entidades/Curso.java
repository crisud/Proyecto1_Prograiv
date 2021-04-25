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
public class Curso
{
    public Curso(String id, String nombre, String tematica, double precio, boolean enOferta)
    {
        this.id = id;
        this.nombre = nombre;
        this.tematica = tematica;
        this.precio = precio;
        this.enOferta = enOferta;
    }
    
    public String getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getTematica()
    {
        return tematica;
    }

    public double getPrecio()
    {
        return precio;
    }

    public boolean getEnOferta()
    {
        return enOferta;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setTematica(String tematica)
    {
        this.tematica = tematica;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public void setEnOferta(boolean enOferta)
    {
        this.enOferta = enOferta;
    }
    
    
    private String id;
    private String nombre;
    private String tematica;
    private double precio;
    private boolean enOferta;
}
