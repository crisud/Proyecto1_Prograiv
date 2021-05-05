package cursos.logic;

import database.entidades.CursoFactory;
import database.entidades.GrupoFactory;
import database.entidades.MatriculaFactory;
import database.entidades.UsuarioFactory;
import database.entidades.GrupoFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model
{
    private static Model uniqueInstance;

    public static Model instance()
    {
        if (uniqueInstance == null)
        {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    HashMap<String, Usuario> usuarios;
    List<Matricula> matriculas;


    private Model()
    {
    }

    public Usuario usuarioFindPass(String id, String pass) throws Exception
    { //base
        Usuario u = UsuarioFactory.recuperarUsuario(id);

        if (u != null)
        {
            if (u.getPass().equals(pass))
            {
                return u;
            } else
            {
                throw new Exception("Contraseña incorrecta");
            }
        } else
        {
            throw new Exception("Usuario no existe");
        }
    }

    public Usuario usuarioFind(String id) throws Exception
    { //base
        Usuario u = UsuarioFactory.recuperarUsuario(id);
        if (u != null)
        {
            return u;
        } else
        {
            throw new Exception("Usuario no existe");
        }
    }

    public void insertUser(Usuario u) throws SQLException, IOException
    {

        UsuarioFactory.guardarUsuario(u);

    }
    
     public void insertMatricula(Matricula m) throws SQLException, IOException
    {
       
            MatriculaFactory.guardarMatricular(m);
        

    }

     public void insertGrupo(Grupo grupo)throws SQLException, IOException
     {
         GrupoFactory.guardarGrupo(grupo);
     }
     
     public void insertCurso(Curso curso) throws SQLException, IOException
     {
         CursoFactory.guardarCurso(curso);
     }
     
    public List<Matricula> getMatriculas(String id_estudiante)
    { //base
        List<Matricula> ma = null;
        try
        {
            ma = MatriculaFactory.recuperarMatricula(id_estudiante);
        } catch (IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return ma;
    }

        
    public List<Grupo> getGrupos(String id_profesor){
        try
        {
            return GrupoFactory.recuperarGrupos_profe(id_profesor);
        }catch(IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Grupo> getGruposNota(String id_profesor){
        try
        {
            return GrupoFactory.recuperarGrupos_profeNota(id_profesor);
        }catch(IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Estudiante> getEstGrupo(String id_grupo){
        try{
            return MatriculaFactory.recuperarEstudianteConIDGrupo(id_grupo);
        }catch(IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Curso> getCursos(){
        List<Curso> cu;
        cu = CursoFactory.listarCursos();
        return cu;
    }
    
    public Curso getCurso(String id){
        List<Curso> cu;
        cu = CursoFactory.listarCursos();
        for(Curso a:cu){
            if(id.equals(a.getId())){
                return a;
            }
        }
        return null;
    }
    
    
     public List<Curso> cursosEnOferta()
     {
         List<Curso> cu;
         cu = CursoFactory.listarCursosEnOferta();
         return cu;
     }
     
     //otra version
      public Curso getCurso2(String id) throws SQLException, IOException{
         Curso cur = CursoFactory.recuperarCurso(id);
         return cur;
     }
     
     public List<Grupo> getGruposCurso(String id){
         List<Grupo> gu;
         gu = GrupoFactory.listarGruposPorIDCurso(id);
        return gu;
     }
     
     public Grupo getGrupo(String id) throws SQLException, IOException{
        return GrupoFactory.recuperarGrupo(id);
     }
     
    public List<Matricula> getMatriculas(){
        return MatriculaFactory.listarMatriculas();
    }
    
    
    public List<Profesor> getProfesores()
    {
        return UsuarioFactory.listarProfesores();
    }
}
