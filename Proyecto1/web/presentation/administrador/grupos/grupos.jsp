<%-- 
    Author     : cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="cursos.logic.Curso"%>
<%@page import="cursos.logic.Grupo"%>
<%@page import="cursos.logic.Profesor"%>
<%@page import="cursos.presentation.administrador.grupo.Model"%>


<%
    Model model = (Model) request.getAttribute("model");
    Curso curso = model.getCurso();

    List<Profesor> profes = (List<Profesor>) session.getAttribute("profes");

    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");

    Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

        <form class = "" name="form-signup" action="/Proyecto1/presentation/administrador/grupos/create/update" method="post" > 
            <div class="mx-auto" style="width: 300px;">

                <h2 class="font-weight-bold text-danger">Signup</h2>
                <div class="container">
                    <div class="">Introduzca el ID del grupo</div>
                    <div class=""><input class="form-control" placeholder="ID Grupo" type="text" name="grupoID" value="<%= form.get("grupoID")[0]%>" ></div>
                        <%if (erroneo("grupoID", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            ID del grupo requerida o se encuentra repetida
                        </small>      
                    </div>
                    <%} %>
                </div>

                <div class="container">
                    <div class="">Seleccione al profesor</div>
                    <select class="form-select " name="profesorID" type="text">
                        <%for (Profesor p : profes)
                            {%>
                        <option value="<%=p.getId()%>"><%=p.getNombre()%> ID: <%=p.getId()%></option>
                        <%}%>
                    </select>
                </div>


                <div class="container">
                    <div class="">Introduzca el ID del curso</div>
                    <div class=""><input class="form-control" type="text" name="cursoID" value="<%=curso.getId()%>" readonly></div>
                </div>   


                <div class="container">
                    <div class="">Introduzca el horario del grupo</div>
                    <div class=""><input class="form-control" placeholder="Horario" type="text" name="horario" value="<%= form.get("horario")[0]%>"></div>
                        <%if (erroneo("horario", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Horario requerido
                        </small>      
                    </div>
                    <%}%>
                </div>  
                <br>
                <div class="container">
                    <div class="row mb-3 px-3"><button class="btn btn-danger"  style="margin-bottom: 15px">Crear Grupo</button> </div>
                </div>

        </form>
    </body>
</html>

<%!
    private boolean erroneo(String campo, Map<String, String> errores)
    { //
        if ((errores != null) && (errores.get(campo) != null))
        {
            return true;
        } else
        {
            return false;
        }
    }

    private Map<String, String[]> getForm(Model model)
    {
        Map<String, String[]> values = new HashMap<String, String[]>();
        values.put("grupoID", new String[]
        {
            ""
        });
        values.put("horario", new String[]
        {
            ""
        });
        return values;
    }


%>