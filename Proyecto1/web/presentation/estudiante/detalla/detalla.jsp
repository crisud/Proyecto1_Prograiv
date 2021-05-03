<%-- 
    Document   : historial
    Author     : Calef
--%>
<%@page import="cursos.logic.Curso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Curso curso = (Curso) request.getAttribute("cur");
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
        <div class="mx-auto form" style="width: 50%; height: 500px">
            <div class="d-flex justify-content-center  bg-light text-dark" style="height: 300px">

                <div class="card text-center" style="width: 100%; height: 100%" >
                    <div class="card-header">
                        Codigo: <%=curso.getId()%>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"><%=curso.getNombre()%></h5>
                        <p class="card-text"><%=curso.getTematica()%></p>

                        <%-- Aqui for de los horarios(grupos)--%>
                        <div class="form-check  d-flex justify-content-center p-2">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                            <label class="form-check-label" for="flexRadioDefault1">
                                 Default radio
                            </label>
                        </div>

                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                    <div class="card-footer text-muted">
                        Precio: ₡ <%=curso.getPrecio()%>
                    </div>
                </div>



            </div>
        </div>
        <% } else {%>
        <div class="justify-content-sm-between">
            <h3>error en el curso</h3>

        </div>
        <%}%>


    </body>
</html>

