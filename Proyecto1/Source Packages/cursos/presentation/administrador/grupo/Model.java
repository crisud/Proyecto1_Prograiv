/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador.grupo;

import cursos.logic.Curso;
import cursos.logic.Grupo;

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
        this.setGrupo(new Grupo());
    }

    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }

    public Curso getCurso()
    {
        return curso;
    }

    public void setGrupo(Grupo grupo)
    {
        this.grupo = grupo;
    }
    
     public Grupo getGrupo()
    {
        return grupo;
    }

    private Curso curso;
    private Grupo grupo;
}
