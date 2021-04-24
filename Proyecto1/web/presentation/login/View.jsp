<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cursos.presentation.login.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body class=" ">

        <%@ include file="/presentation/Header.jsp" %>

        <% Model model = (Model) request.getAttribute("model"); %>
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");%>
       <div style="margin-top:100px"></div>
        <form class = "" name="form" action="/Proyecto1/presentation/login/login" method="post" > 
            <div class="mx-auto" style="width: 400px;">
                
                <h2 class="font-weight-bold text-danger">Login</h2>
                <div class="container">
                    <div class="">Cedula</div>
                    <div class=""><input class="<%=erroneo("cedulaFld",errores)%>" placeholder="Cedula del usuario" type="text" name="cedulaFld" ></div>
                    <div class="text-danger"> <%=title("cedulaFld",errores)%> </div>
                </div>
                <div class="container">
                    <div class="">Clave</div>
                    <div class=""><input class="<%=erroneo("claveFld",errores)%>" placeholder="Clave del usuario" type="password" name="claveFld"   ></div>
                    <div class="text-danger"> <%=title("claveFld",errores)%> </div>
                </div>
                <div style="margin-top:10px"></div>
                <div class="container">
                    <div class="row mb-3 px-3"><button class="btn btn-danger" style="margin-bottom: 15px">Ingresar</button> </div>
                </div>
                    <%if( title("noexiste",errores) == "si"){ %>
                    <div class="alert alert-warning" role="alert">
                        Registrate! <a href="#" class="alert-link"> Aquí </a>. En caso de no tener un cuenta.
                    </div>
                    <% } %>
            </div>
        </form>

    </body>
</html>

<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "form-control is-invalid";
        } else {
            return "form-control";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

%> 
