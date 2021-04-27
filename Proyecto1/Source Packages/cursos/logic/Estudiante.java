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
public class Estudiante extends Usuario {
   public Estudiante(String id, String pass, String role, String nombre, String correo, Integer telefono) {
        super( id,  pass,  role,  nombre,  correo,  telefono);
    
   }
   public Estudiante(){
       
   }
}
