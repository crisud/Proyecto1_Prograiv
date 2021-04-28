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
public class Grupo
{
    public Grupo(String id, String horario, Profesor profesor, Curso curso)
    {
        this.id = id;
        this.horario = horario;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        this.curso = curso;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void ingresarEstudiantes(Estudiante e)
    {
        estudiantes.add(e);
    }
    
   
    
    private String id;
    private String horario;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    private Curso curso;
}
