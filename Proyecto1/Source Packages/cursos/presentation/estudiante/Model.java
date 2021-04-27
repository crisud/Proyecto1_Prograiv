/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.estudiante;

import cursos.logic.Estudiante;
import cursos.logic.Usuario;

/**
 *
 * @author Calef
 */
public class Model {

    Estudiante current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Estudiante());        
    }
    
    public Estudiante getCurrent() {
        return current;
    }

    public void setCurrent(Estudiante current) {
        this.current = current;
    }
}