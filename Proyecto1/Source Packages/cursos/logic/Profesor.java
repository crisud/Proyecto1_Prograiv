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
public class Profesor extends Usuario{
    
    private String especialidad;

    public Profesor(String id, String pass, String role, String nombre, String correo, Integer telefono, String especialidad) {
        super( id,  pass,  role,  nombre,  correo,  telefono);
        this.especialidad = especialidad;
      
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
