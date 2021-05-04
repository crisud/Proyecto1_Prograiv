<%-- 
    Author     : Calef
--%>

<%@page import="cursos.logic.Matricula"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    List<Matricula> matriculas = (List<Matricula>) request.getAttribute("listaCursos");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>

    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

        <div style="margin-top:25px"></div> 
        <div class="mx-auto p-3 mb-2 bg-secondary text-white text-center border-3" style="width: 800px"><h3> Lista de Cursos</h3></div>
        <div style="margin-top:25px"></div> 

        <%if (matriculas != null) {%>
            <%if (!matriculas.isEmpty()) {%>

                 <% for (Matricula ma : matriculas) {%>
                    <div class="mx-auto" style="width: 800px">
                        <div class="card">
                            <div class="card-header bg-dark text-white">
                                <p> Nota <%=ma.getNota()%></p>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title p-3 mb-2 bg-light text-dark text-center"> <%=ma.getGrupo().getNombreCurso()%></h5>
                                <p class="card-text">Profesor: <%=ma.getGrupo().getNomProfesor()%>.</p>
                                <p class="card-text">Id del curso: <%=ma.getGrupo().getId()%>.</p>
                                <p class="card-text">Horario: <%=ma.getGrupo().getHorario()%>.</p>
                                <%-- <a href="#" class="btn btn-primary">Go somewhere</a>  --%>
                            </div>
                        </div>
                    </div>
                    <div style="margin-top:25px"></div> 
                <%} %>
                 <div class="d-flex justify-content-center">
                     <a target='_blank' href="/Proyecto1/presentation/estudiante/imprime" class="btn btn-primary"> imprimir </a>
                 </div>
                 <div style="margin-top:25px"></div> 
             <%} else {%>
                <h1 class= " position-fixed">  No hay Cursos matriculados   </h1>
                <% } %>
        <% }%>


    </body>
</html>
