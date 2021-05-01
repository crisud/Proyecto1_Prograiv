package cursos.logic;

import database.entidades.CursoFactory;
import database.entidades.MatriculaFactory;
import database.entidades.UsuarioFactory;
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
        usuarios = new HashMap(); //quitar hash map
        matriculas = new ArrayList();
        //(String id, String pass, String role, String cedula, String nombre, String correo, Integer telefono)

        usuarios.put("111", new Estudiante("111", "111", "Estudiante", "J.Perez", "JPerez@gmail.com", 12345678));
        usuarios.put("222", new Usuario("222", "222", "Profesor", "A.Cortes", "ACortes@gmail.com", 88842828));
        usuarios.put("333", new Usuario("333", "333", "Administrador", "B.Diaz", "BDiaz@gmail.com", 78654556));

        //Grupo(String id, String horario, Profesor profesor, Curso curso)
        //Matricula(Estudiante estudiante, Grupo grupo, Double nota)
        //Curso(String id, String nombre, String tematica, double precio, boolean enOferta)
        matriculas.add(new Matricula(new Estudiante("111", "111", "Estudiante", "J.Perez", "JPerez@gmail.com", 12345678),
                new Grupo("122", "4:00 pm a 5:00 pm", new Profesor("222", "222", "Profesor", "A.Cortes", "ACortes@gmail.com", 88842828, "matematica"),
                        new Curso("A5", "Estadistica", "Es un surso de mate", 15000, false)), 0.0));

        matriculas.add(new Matricula(new Estudiante("111", "111", "Estudiante", "J.Perez", "JPerez@gmail.com", 12345678),
                new Grupo("122", "2:00 pm a 3:00 pm", new Profesor("222", "222", "Profesor", "Jose", "ACortes@gmail.com", 88842828, "matematica"),
                        new Curso("A5", "Infoematica", "Es un curso de tecnologia", 15000, true)), 0.0));

        matriculas.add(new Matricula(new Estudiante("111", "111", "Estudiante", "J.Perez", "JPerez@gmail.com", 12345678),
                new Grupo("123", "8:00 pm a 9:00 pm", new Profesor("222", "222", "Profesor", "Laura", "ACortes@gmail.com", 88842828, "matematica"),
                        new Curso("A5", "Ingles", "Es un curso de idiomas", 15000, false)), 0.0));
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

    public void insertUser(Usuario u)
    {
        try
        {
            UsuarioFactory.guardarUsuario(u);
        }
        catch(IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }

    }


    public List<Matricula> getMatriculas(String id_estudiante)
    { //base
        List<Matricula> ma = null;
        try
        {
            ma = MatriculaFactory.recuperarMatricula(id_estudiante);
        }catch(IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return ma;
    }

     public List<Curso> getCursos(){
        List<Curso> cu;
        cu = CursoFactory.listarCursos();
        return cu;
     }
     
     public List<Curso> cursosEnOferta()
     {
         List<Curso> cu;
         cu = CursoFactory.listarCursosEnOferta();
         return cu;
     }
}
