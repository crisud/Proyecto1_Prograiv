/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos.logic;

/**
 *
 * @author Hp
 */
public class Profesor extends Persona{
    
    private String especialidad;

    public Profesor(String especialidad, String cedula, String nombre, Usuario usuario, String correo, Integer telefono) {
        super(cedula, nombre, usuario, correo, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
