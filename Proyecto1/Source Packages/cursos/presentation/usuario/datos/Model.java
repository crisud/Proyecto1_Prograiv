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
    Usuario current;

    public Model() {
        this.current = new Usuario("", "", "", "", "", 0);
    }

    
    public Usuario getCurrent() {
        return current;
    }

    public String getTipoCuenta(){return getCurrent().getTipo();}
    
    public void setCurrent(Usuario current) {
        this.current = current;
    }
}
