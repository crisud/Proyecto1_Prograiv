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
    
    public Estudiante getEstudiante()
    {
        return estudiante;
    }
    
    private Estudiante estudiante;
    private Grupo grupo;
    private Double nota;
}
