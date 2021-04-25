/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.presentation.usuario.datos;
import cursos.logic.*;
/**
 *
 * @author Hp
 */
public class Model {
    Persona current;

    public Model() {
        this.current = new Persona("","",new Usuario("","",""),"",0);
    }

    
    public Persona getCurrent() {
        return current;
    }

    public String getTipoCuenta(){return getCurrent().getUsuario().getTipo();}
    
    public void setCurrent(Persona current) {
        this.current = current;
    }
}
