/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador.curso;

import cursos.logic.Curso;

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
        this.setCurso(new Curso());
    }
    
    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }
    
    public Curso getCurso()
    {
        return curso;
    }
    private Curso curso;
}
