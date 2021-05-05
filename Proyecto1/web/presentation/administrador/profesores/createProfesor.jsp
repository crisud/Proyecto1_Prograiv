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


        <form class = "" name="form-signup" action="/Proyecto1/presentation/administrador/profesor/create/create" method="post" > 
            <div class="mx-auto" style="width: 300px;">

                <h2 class="font-weight-bold text-danger">Registro de Profesor</h2>
                <div class="container">
                    <div class="">Introduzca el ID del profesor</div>
                    <div class=""><input class="form-control" placeholder="ID Profesor" type="text" name="profeID" value="<%=form.get("profeID")[0]%>"></div>
                        <%if (erroneo("profeID", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            ID es requerida o ya se encuentra registrada
                        </small>      
                    </div>
                    <%} %>
                </div>

                <div class="container">
                    <div class="">Introduzca el nombre del profesor</div>
                    <div class=""><input class="form-control" placeholder="Nombre" type="text" name="nombre" value="<%=form.get("nombre")[0]%>"></div>
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
                    <div class="">Introduzca la contraseña del profesor</div>
                    <div class=""><input class="form-control" placeholder="Contraseña" type="text" name="contrasena" value="<%=form.get("contrasena")[0]%>"></div>
                        <%if (erroneo("contrasena", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Contraseña requerida
                        </small>      
                    </div>
                    <%}%>
                </div>

                <div class="container">
                    <div class="">Introduzca el telefono del profesor</div>
                    <div class=""><input class="form-control" placeholder="Telefono" type="number" name="telefono" value="<%=form.get("telefono")[0]%>"></div>
                        <%if (erroneo("telefono", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Telefono requerido
                        </small>      
                    </div>
                    <%}%>
                </div>

                <div class="container">
                    <div class="">Introduzca la especialidad del profesor</div>
                    <div class=""><input class="form-control" placeholder="Especialidad" type="text" name="especialidad" value="<%=form.get("especialidad")[0]%>"></div>
                        <%if (erroneo("especialidad", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Especialidad requerida
                        </small>      
                    </div>
                    <%}%>
                </div>


                <div class="container">
                    <div class="">Introduzca el correo del profesor</div>
                    <div class=""><input class="form-control" placeholder="Correo" type="text" name="correo" value="<%=form.get("correo")[0]%>"></div>
                        <%if (erroneo("correo", errores))
                            {%>
                    <div class="text-danger">
                        <small id="passwordHelp" class="text-danger">
                            Correo requerido
                        </small>      
                    </div>
                    <%}%>
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
        values.put("profeID", new String[]
        {
            ""
        });
        values.put("nombre", new String[]
        {
            ""
        });
        values.put("contrasena", new String[]
        {
            ""
        });
        values.put("telefono", new String[]
        {
            ""
        });
        values.put("especialidad", new String[]
        {
            ""
        });
        values.put("tematica", new String[]
        {
            ""
        });
        values.put("correo", new String[]
        {
            ""
        });
        return values;
    }

%>