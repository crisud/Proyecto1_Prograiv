/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.logic;

import java.util.ArrayList;
import java.util.List;

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
    
    private String id;
    private String nombre;
    private String tematica;
    private double precio;
    private boolean enOferta;
    
}
