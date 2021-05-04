/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.logic;

/**
 *
 * @author cristopher
 */
public class Matricula
{
    public Matricula(Estudiante estudiante, Grupo grupo, Double nota)
    {
        this.estudiante = estudiante;
        this.grupo = grupo;
        this.nota = nota;
    }
    
    public Matricula(){
        
    }
    
    public void setNota(Double x){
        this.nota = x;
    }
    
    public Estudiante getEstudiante()
    {
        return estudiante;
    }
    
    public Grupo getGrupo()
    {
        return grupo;
    }

    public Double getNota()
    {
        return nota;
    }
    private Estudiante estudiante;
    private Grupo grupo;
    private Double nota;
}
