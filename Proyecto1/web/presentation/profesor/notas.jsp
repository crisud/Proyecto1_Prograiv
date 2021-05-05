<%-- 
    Document   : notas
    Created on : 1 may. 2021, 17:50:36
    Author     : Hp
--%>

<%@page import="cursos.logic.Matricula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cursos.logic.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%List<Estudiante> est = (List<Estudiante>)request.getAttribute("EstGrupo");
  List<Matricula> mats = (List<Matricula>)request.getAttribute("matriculas");
  String num = (String) request.getParameter("id_grupo");
  Matricula m = new Matricula();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class = "container-fluid bg-danger p-4 rounded"  >
            <h1>Lista de Estudiantes</h1>
        </div>
        <div class = "container-fluid bg-light rounded mx-auto" >
            <%if(est == null){%>
                <h1>No hay estudiantes en este grupo!</h1>
            <%}else{%>
            <ul class="list-group">
                <%for(Estudiante e:est){%>
                <li class="list-group-item p-4">
                    <%for(Matricula a: mats){
                        if(a.getEstudiante().getId().equals(e.getId()) && a.getGrupo().getId().equals(num))
                            m = a;
                        
                    }
                    %>
                    <h4><%=e.getNombre()%><h4 style="text-end"> Nota: <%=m.getNota()%></h4></h4>
                    <div class = "text-end"><a class = "btn btn-danger" href='/Proyecto1/presentacion/profesor/registroNota?id_est=<%=e.getId()%>&id_group=<%=num%>' ><h4>Registrar Nota</h4></a></div>
                </li>
                <%}%>
            </ul>
            <%}%>
        </div>
    </body>
</html>
