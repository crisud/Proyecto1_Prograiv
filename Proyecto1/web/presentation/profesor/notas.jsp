<%-- 
    Document   : notas
    Created on : 1 may. 2021, 17:50:36
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cursos.logic.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%List<Estudiante> est = (List<Estudiante>)request.getAttribute("EstGrupo");%>
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
                <li class="list-group-item p-2">
                    <%=e.getNombre()%>
                    <a class = "btn-danger" href='#' style="align-content: flex-end">Registrar Nota</a>
                </li>
                <%}%>
            </ul>
            <%}%>
        </div>
    </body>
</html>
