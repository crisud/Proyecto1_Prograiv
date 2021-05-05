<%-- 
    Author     : cristopher
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cursos.logic.Profesor"%>
<%@page import="cursos.presentation.administrador.Model"%>


<%
    Model model = (Model) request.getAttribute("model");
    List<Profesor> profesores = model.getProfesores();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

        <blockquote class="blockquote text-center">
            <h1 class="mb-0">Lista de Profesores</h1>
        </blockquote>

        <div class="card-deck">
            <% for (Profesor p : profesores)
                {%>
            <div class="card mb-4">
                <div class="card-body">
                    <h5 class="card-title">ID: <%=p.getId()%></h5>
                    <p class="card-text">Nombre: <%=p.getNombre()%>
                        <br>
                    Especialidad: <%=p.getEspecialidad()%>
                </div>
            </div> 
            <%}%>
        </div>

    </body>
</html>
