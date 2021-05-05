<%-- 
    Author     : Calef
--%>
<%@page import="cursos.presentation.estudiante.Model"%>

<%
    String mensaje = (String) request.getAttribute("error");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>informacion</title> 
    </head>
    <body >
        <div class="" style="background-image: url('/Proyecto1/img/fondo.jpg'); width: 100%; height: 600px"> 
            <%@ include file="/presentation/Header.jsp" %>
            <div style="margin-top:100px"></div> 

            <div class="mx-auto" style="width: 500px">
                <div class="d-flex justify-content-center  bg-light text-dark">

                    <div class="justify-content-sm-between">
                        <div class="justify-content-sm-between">
                            <h1>Informacion del Matricula</h1>
                        </div>
                        <div class="justify-content-sm-between">
                            <h3><%= mensaje%></h3>
                        </div>
                        <div class="justify-content-sm-between">
                        <a href="/Proyecto1/presentation/person/profile" class="btn btn-primary">Ir al inicio</a>
                        </div>
                    </div>

                </div>
            </div>
        </div >
    </body>
</html>