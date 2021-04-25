/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entidades;

/**
 *
 * @author cristopher
 */
public class Grupo
{
    public Grupo(String id, String id_profesor, String id_curso, String horario)
    {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_curso = id_curso;
        this.horario = horario;
    }
    
    public String getId()
    {
        return id;
    }

    public String getId_profesor()
    {
        return id_profesor;
    }

    public String getId_curso()
    {
        return id_curso;
    }

    public String getHorario()
    {
        return horario;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setId_profesor(String id_profesor)
    {
        this.id_profesor = id_profesor;
    }

    public void setId_curso(String id_curso)
    {
        this.id_curso = id_curso;
    }

    public void setHorario(String horario)
    {
        this.horario = horario;
    }
    
    
    
    private String id;
    private String id_profesor;
    private String id_curso;
    private String horario;
}
