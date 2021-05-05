<%-- 
    Author     : cristopher
--%>

<%@page import="java.util.List"%>
<%@page import="cursos.logic.Curso"%>
<%@page import="cursos.logic.Grupo"%>
<%@page import="cursos.presentation.administrador.grupo.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Grupo> grupos = (List<Grupo>) request.getAttribute("grupos");
    Curso curso = model.getCurso();
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
            <h1 class="mb-0">Lista de Grupos del Curso: <%=curso.getNombre()%> <%=curso.getId()%></h1>
        </blockquote>

        <div class="card-deck">
            <% for (Grupo g : grupos)
                {%>
            <div class="card mb-4">
                <div class="card-body">
                    <h5 class="card-title">Codigo: <%=g.getId()%></h5>
                    <p class="card-text">Profesor: <%= g.getNomProfesor()%>
                    <br> ID Profesor: <%= g.getIdProfe()%>
                </div>
            </div> 
            <%}%>
        </div>


    </body>
</html>
