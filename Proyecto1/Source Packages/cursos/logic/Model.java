
package cursos.logic;

import java.util.HashMap;

public class Model {
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }
    
    HashMap<String,Usuario> usuarios;
    HashMap<String,Persona> personas;
    
    
    private Model(){
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111","111","Estudiante"));
        usuarios.put("222", new Usuario("222","222","Profesor"));
        usuarios.put("333", new Usuario("333","333","Administrador"));
        
        personas = new HashMap();
        personas.put("111", new Estudiante("111","J.Perez",usuarios.get("111"),"JPerez@gmail.com",12345678));
        personas.put("222", new Profesor("Pintura","222","A.Cortes",usuarios.get("222"),"ACortes@gmail.com",83472332));
        personas.put("333", new Administrador("333","A.sera",usuarios.get("333"),"ASera@gmail.com",12345448));
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
     
    public Persona personaFind(Usuario usuario) throws Exception{
        if(personas.get(usuario.getId())!=null)
            return personas.get(usuario.getId());
        else
            throw new Exception("Usuario no existe");
    }
    
    public void insertUser(Persona persona){
        usuarios.put(persona.getCedula(),persona.getUsuario());
        personas.put(persona.getCedula(), persona);
    }
}
