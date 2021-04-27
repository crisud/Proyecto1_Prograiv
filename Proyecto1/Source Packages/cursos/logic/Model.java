
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
  
    
    
    private Model(){
        usuarios = new HashMap();
        
        //(String id, String pass, String role, String cedula, String nombre, String correo, Integer telefono)
        
        usuarios.put("111", new Usuario("111","111","Estudiante","J.Perez","JPerez@gmail.com",12345678));
        usuarios.put("222", new Usuario("222","222","Profesor","A.Cortes","ACortes@gmail.com",88842828));
        usuarios.put("333", new Usuario("333","333","Administrador","B.Diaz","BDiaz@gmail.com",78654556));
        
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
     
    public Usuario personaFind(Usuario usuario) throws Exception{
        if(usuarios.get(usuario.getId())!=null)
            return usuarios.get(usuario.getId());
        else
            throw new Exception("Usuario no existe");
    }
    
    public void insertUser(Usuario persona){   
        usuarios.put(persona.getId(), persona);
    }
}
