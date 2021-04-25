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
public class Matricula
{
    public Matricula(String id_estudiante, String id_grupo, double nota)
    {
        this.id_estudiante = id_estudiante;
        this.id_grupo = id_grupo;
        this.nota = nota;
    }
    
    public String getId_estudiante()
    {
        return id_estudiante;
    }

    public String getId_grupo()
    {
        return id_grupo;
    }

    public double getNota()
    {
        return nota;
    }

    public void setId_estudiante(String id_estudiante)
    {
        this.id_estudiante = id_estudiante;
    }

    public void setId_grupo(String id_grupo)
    {
        this.id_grupo = id_grupo;
    }

    public void setNota(double nota)
    {
        this.nota = nota;
    }
    
    
    private String id_estudiante;
    private String id_grupo;
    private double nota;
}
