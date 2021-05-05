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
                        <div class="card-body bg-secondary">
                            <h5 class="card-title text-light"><%=g.getId()%></h5>
                            <h6 class="card-subtitle mb-2 text-light "><%=g.getNombreCurso()%></h6>
                            <p class="card-text text-light"><%=g.getHorario()%></p>
                            <a href="/Proyecto1/presentation/profesor/estudiantes?id_grupo=<%=g.getId()%>" class="card-link link-dark">Ver Estudiantes</a>
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
