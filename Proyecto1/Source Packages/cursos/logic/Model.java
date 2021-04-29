
package cursos.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }
    
    HashMap<String,Usuario> usuarios;
    List<Matricula> matriculas;
    
    
    private Model(){
        usuarios = new HashMap();
        matriculas = new ArrayList();
        //(String id, String pass, String role, String cedula, String nombre, String correo, Integer telefono)
        
        usuarios.put("111", new Estudiante("111","111","Estudiante","J.Perez","JPerez@gmail.com",12345678));
        usuarios.put("222", new Usuario("222","222","Profesor","A.Cortes","ACortes@gmail.com",88842828));
        usuarios.put("333", new Usuario("333","333","Administrador","B.Diaz","BDiaz@gmail.com",78654556));
        
        //Grupo(String id, String horario, Profesor profesor, Curso curso)
        //Matricula(Estudiante estudiante, Grupo grupo, Double nota)
        //Curso(String id, String nombre, String tematica, double precio, boolean enOferta)
        matriculas.add(new Matricula( new Estudiante("111","111","Estudiante","J.Perez","JPerez@gmail.com",12345678),
                new Grupo("122", "4:00 pm a 5:00 pm",new Profesor("222","222","Profesor","A.Cortes","ACortes@gmail.com",88842828, "matematica"), 
                        new Curso ("A5","Estadistica","Es un surso de mate",15000, false)), 0.0));
        
         matriculas.add(new Matricula( new Estudiante("111","111","Estudiante","J.Perez","JPerez@gmail.com",12345678),
                new Grupo("122", "2:00 pm a 3:00 pm",new Profesor("222","222","Profesor","Jose","ACortes@gmail.com",88842828, "matematica"), 
                        new Curso ("A5","Infoematica","Es un curso de tecnologia",15000, true)), 0.0));
         
          matriculas.add(new Matricula( new Estudiante("111","111","Estudiante","J.Perez","JPerez@gmail.com",12345678),
                new Grupo("123", "8:00 pm a 9:00 pm",new Profesor("222","222","Profesor","Laura","ACortes@gmail.com",88842828, "matematica"), 
                        new Curso ("A5","Ingles","Es un curso de idiomas",15000, false)), 0.0));
    }
    
    public Usuario usuarioFind(String id,String pass) throws Exception{
        if (usuarios.get(id)!=null){
            if(usuarios.get(id).getPass().equals(pass))
               return usuarios.get(id);
            else
                throw new Exception("Contraseña incorrecta");
        }
        else
            throw new Exception("Usuario no existe");
    }
     
    public Usuario personaFind(String id) throws Exception{
         if (usuarios.get(id)!=null){
             return usuarios.get(id);
         }
        else
            throw new Exception("Usuario no existe");
    } 
    
    public void insertUser(Usuario persona){   
        usuarios.put(persona.getId(), persona);
    }
    
    
    
    public List<Matricula> getMatriculas(String id){
        List<Matricula> ma = new ArrayList();
        for (Matricula m : matriculas) {
            if(m.getEstudiante().getId().equals(id))
                ma.add(m);
        }
        return ma;
     }
}
