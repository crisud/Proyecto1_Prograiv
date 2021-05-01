<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cursos.logic.Grupo"%>
<%@page import="cursos.logic.Profesor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
     List<Grupo> grupos = (List<Grupo>) session.getAttribute("gruposProfe");
     Profesor profe = (Profesor) session.getAttribute("usuario");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        
        <div class = "container-fluid bg-secondary p-4" ><h1 class="text-light">Bienvenido! <%=profe.getNombre()%></h1></div>
        <div class = "container-fluid bg-danger p-4 rounded"  >
            <h1>Lista de Grupos</h1>
        </div>
        <div class = "container-fluid bg-light rounded mx-auto" >
            <%if(grupos!=null){%>
                <%for(Grupo g:grupos){%>
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title"><%=g.getId()%></h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=g.getNombreCurso()%></h6>
                            <p class="card-text"><%=g.getHorario()%></p>
                            <a href="/presentation/profesor/notas.jsp" class="card-link link-dark">Ver Estudiantes</a>
                            <a href="#" class="card-link link-danger">Registrar Notas</a>
                        </div>
                    </div>
                <%}%>
            <%}
            else{%>
                <h1>No hay grupos</h1>
          <%}%>
        </div>
    </body>
</html>
