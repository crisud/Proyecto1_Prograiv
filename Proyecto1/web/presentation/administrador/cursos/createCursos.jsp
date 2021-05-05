<%--
    Author     : cristopher
--%>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");

    Map<String, String[]> form = (errores == null) ? this.getForm() : request.getParameterMap();

%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>


        <form class = "" name="form-signup" action="/Proyecto1/presentation/administrador/cursos/create/create" method="post" > 
            <div class="mx-auto" style="width: 300px;">

                <h2 class="font-weight-bold text-danger">Creación de curso</h2>
                <div class="container">
                    <div class="">Introduzca el ID del curso</div>
                    <div class=""><input class="form-control" placeholder="ID Curso" type="text" name="cursoID" value="<%= form.get("cursoID")[0]%>"></div>
                        <%if (erroneo("cursoID", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            ID del curso requerida o se encuentra repetida
                        </small>      
                    </div>
                    <%} %>
                </div>

                <div class="container">
                    <div class="">Introduzca el nombre del curso</div>
                    <div class=""><input class="form-control" placeholder="Nombre" type="text" name="nombre" value="<%= form.get("nombre")[0]%>"></div>
                        <%if (erroneo("nombre", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Nombre requerido
                        </small>      
                    </div>
                    <%}%>
                </div>

                <div class="container">
                    <div class="">Introduzca la tematica del curso</div>
                    <div class=""><input class="form-control" placeholder="Tematica" type="text" name="tematica" value="<%= form.get("tematica")[0]%>"></div>
                        <%if (erroneo("tematica", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Tematica requerida
                        </small>      
                    </div>
                    <%}%>
                </div>

                <div class="container">
                    <div class="">Introduzca el precio curso</div>
                    <div class=""><input class="form-control" placeholder="Precio" type="number" step = "0.01" name="precio" value="<%= form.get("precio")[0]%>"></div>
                        <%if (erroneo("precio", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Precio requerido
                        </small>      
                    </div>
                    <%}%>
                </div>

                <div class="container">
                    <div class="">Eliga la disponibilidad del curso</div>
                    <select class="form-select " name="oferta" type="text">
                        <option selected value="1">En oferta</option>
                        <option value="0">No en oferta</option>
                    </select>
                </div>

                <br>
                <div class="container">
                    <div class="row mb-3 px-3"><button class="btn btn-danger"  style="margin-bottom: 15px">Crear Grupo</button> </div>
                </div>
        </form>
    </body>
</html>


<%!
    private boolean erroneo(String campo, Map<String, String> errores)
    { //
        if ((errores != null) && (errores.get(campo) != null))
        {
            return true;
        } else
        {
            return false;
        }
    }

    private Map<String, String[]> getForm()
    {
        Map<String, String[]> values = new HashMap<String, String[]>();
        values.put("cursoID", new String[]
        {
            ""
        });
        values.put("nombre", new String[]
        {
            ""
        });
        values.put("tematica", new String[]
        {
            ""
        });
        values.put("precio", new String[]
        {
            ""
        });
        return values;
    }


%>