<%-- 
    Author     : Calef
--%>
<%@page import="cursos.presentation.estudiante.Model"%>
<%@page import="cursos.logic.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Model model = (Model) request.getAttribute("modelEstu");
    Estudiante estu = model.getCurrent();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>informacion</title> 
    </head>
    <body >
        <%@ include file="/presentation/Header.jsp" %>
        <div class="" style="background-image: url('/Proyecto1/img/fondo.jpg'); width: 100%; height: 560px"> 
            <div style="margin-top:100px"></div> 

            <div class="mx-auto  border border-4" style="width: 500px ">
                <div class="d-flex justify-content-center  bg-light text-dark">

                    <div class="justify-content-sm-between">
                        <div class="justify-content-sm-between p-2 bg-dark text-white ">
                            <h1>Informacion del estudiante</h1>
                        </div>
                        <div class=" justify-content-sm-between">
                            <h3>Nombre:</h3>
                            <p><%=estu.getNombre()%></p>
                        </div>
                        <div class=" justify-content-sm-between">
                            <h3>ID</h3>
                            <p><%=estu.getId()%></p>
                        </div>
                        <div class="justify-content-sm-between">
                            <h3>Telefono</h3>
                            <p><%=estu.getTelefono()%></p>
                        </div>
                        <div class="justify-content-sm-between">
                            <h3>Correo</h3>
                            <p><%=estu.getCorreo()%></p>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
