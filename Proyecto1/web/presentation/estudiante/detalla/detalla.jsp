<%-- 
    Document   : historial
    Author     : Calef
--%>
<%@page import="cursos.logic.Grupo"%>
<%@page import="cursos.logic.Curso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Curso curso = (Curso) request.getAttribute("cur");
    List<Grupo> grupos = (List<Grupo>) request.getAttribute("gru");
    String error = (String) request.getAttribute("error");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>JSP Page</title>
    </head>

    <body >
        <%@ include file="/presentation/Header.jsp" %>
        <div style="margin-top:100px"></div> 
        <% if (curso != null) {%>
        <form class="mx-auto form" action="/Proyecto1/presentation//estudiante/matricular" method="post" style="width: 50%; height: 500px">
            <div class="d-flex justify-content-center  bg-light text-dark" style="height: 400px">

                <div class="card text-center" style="width: 100%; height: 100%" >
                    <div class="card-header">
                        Codigo: <%=curso.getId()%>
                    </div>
                    <div class="card-body">
                        <h3 class="card-title text-danger"><%=curso.getNombre()%></h3>
                        <p class="card-text"><%=curso.getTematica()%></p>

                        
                        <% if (grupos != null && !grupos.isEmpty()) {%>
                        <p class="card-text text-muted"> Horarios disponibles</p>
                        
                        <% for (Grupo gru : grupos) {%>
                        <div class="form-check  d-flex justify-content-center p-2">
                            <input class="form-check-input" type="radio" name="grupo" value="<%=gru.getId()%>" required>
                            <p class="card-text"><%=gru.getHorario()%></p>
                            <p class="card-text">| <%=gru.getNomProfesor()%></p>
                            <p class="card-text"> | <%=gru.getId()%></p>
                        </div>
                        <% }%>
                        

                        <button class="btn btn-primary">Matricular</button>
                        <% }%>
                    </div>
                    <div class="card-footer text-muted">
                        Precio: ₡ <%=curso.getPrecio()%>
                    </div>
                </div>
            </div>
        </form>
        <% } else {%>
        <div class="justify-content-sm-between">
            <h3>error en el curso</h3>

        </div>
        <%}%>


    </body>

</html>

