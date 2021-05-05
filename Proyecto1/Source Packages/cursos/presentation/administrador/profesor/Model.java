/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.administrador.profesor;

import cursos.logic.Profesor;

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
        setProfesor(new Profesor());
    }
    
    public void setProfesor(Profesor profe)
    {
        this.profe = profe;
    }
    
    public Profesor getProfesor()
    {
        return profe;
    }
    private Profesor profe;
}
