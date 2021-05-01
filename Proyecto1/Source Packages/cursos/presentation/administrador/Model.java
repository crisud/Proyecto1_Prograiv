/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador;

import cursos.logic.Curso;
import cursos.logic.Profesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristopher
 */
public class Model
{
    public Model()
    {
        this.reset();
    }
    
    public final void reset()
    {
        this.setProfesores(new ArrayList<>());
        this.setCuros(new ArrayList<>());
    }
    
    public void setProfesores(List<Profesor> profesores)
    {
        this.profesores = profesores;
    }
    
    public void setCuros(List<Curso> cursos)
    {
        this.cursos = cursos;
    }
    
    private List<Profesor> profesores;
    private List<Curso> cursos;
}
