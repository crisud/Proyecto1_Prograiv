
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
        usuarios.put("111", new Usuario("111","111","Estudiante"));
        usuarios.put("222", new Usuario("222","222","Estudiante"));
        usuarios.put("333", new Usuario("333","333","Estudiante"));
    }
    
     public Usuario usuarioFind(String id,String clave) throws Exception{
        if (usuarios.get(id)!=null)
            return usuarios.get(id);
        else
            throw new Exception("Usuario no existe");
    }
    
    
}
