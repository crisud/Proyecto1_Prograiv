<%-- 
    Author     : cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cursos.logic.Curso"%>
<%@page import="cursos.presentation.administrador.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Curso> cursos = model.getCursos();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

        <blockquote class="blockquote text-center">
            <h1 class="mb-0">Lista de Cursos</h1>
        </blockquote>

        <div class="card-deck">
            <% for (Curso c : cursos)
                {%>
            <div class="card mb-4">
                <div class="card-body">
                    <h5 class="card-title">NRC: <%=c.getId()%></h5>
                    <p class="card-text"><%=c.getNombre()%>
                        <% if (c.enOferta())
                        {%>
                        <br>
                        En oferta</p>
                        <%} else
                    {%>
                    <br>
                    No está en oferta</p>
                    <%}%>
                    <a href="/Proyecto1/presentation/administrador/cursos/update?cursoId=<%=c.getId()%>"><small class="btn btn-info btn-sm">Modificar estado de oferta</small></a>
                    <a href="/Proyecto1/presentation/administrador/grupos/show?cursoId=<%=c.getId()%>"><small class="btn btn-info btn-sm">Ver grupos</small></a>
                    <a href="/Proyecto1/presentation/administrador/grupos/create/show?cursoId=<%=c.getId()%>"><small class="btn btn-info btn-sm">Crear Grupo</small></a>
                </div>
            </div> 
            <%}%>
        </div>
    </body>
</html>
