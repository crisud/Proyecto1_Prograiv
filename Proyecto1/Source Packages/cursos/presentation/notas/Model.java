/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.notas;

import cursos.logic.Grupo;

public class Model {
    
    Grupo current;
    
    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Grupo());        
    }
    
    public Grupo getCurrent() {
        return current;
    }

    public void setCurrent(Grupo current) {
        this.current = current;
    }
}
