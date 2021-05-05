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
        this.setCursos(new ArrayList<>());
    }
    
    public void setProfesores(List<Profesor> profesores)
    {
        this.profesores = profesores;
    }
    
    public void setCursos(List<Curso> cursos)
    {
        this.cursos = cursos;
    }
    
    public List<Profesor> getProfesores()
    {
        return profesores;
    }

    public List<Curso> getCursos()
    {
        return cursos;
    }
    
    
    private List<Profesor> profesores;
    private List<Curso> cursos;
}
