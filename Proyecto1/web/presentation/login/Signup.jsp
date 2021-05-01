<%-- 
    verificar que ningun campo este vacií y que el numero no sea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
         <%@ include file="/presentation/Header.jsp" %>
         <% String error = (String) request.getAttribute("error");%>
         
         <div style="margin-top:50px"></div>
         <form class = "" name="form-signup" action="/Proyecto1/presentation/login/signup" method="post" > 
            <div class="mx-auto" style="width: 400px;">
                
                <h2 class="font-weight-bold text-danger">Signup</h2>
                <div class="container">
                    <div class="">Introduzca su cedula de identificacion</div>
                    <div class=""><input class="form-control" placeholder="Cedula del usuario" type="text" name="id" ></div>
                </div>
                <div class="container">
                    <div class="">Introduzca su nombre completo</div>
                    <div class=""><input class="form-control" placeholder="Nombre Completo" type="text" name="name" ></div>
                </div>
                
                <div class="container">
                    <div class="">Introduzca su numero de telefono</div>
                    <div class=""><input class="form-control" placeholder="Telefono" type="number" name="tel" ></div>
                </div>
                
                <div class="container">
                    <div class="">Introduzca su cedula de identificacion</div>
                    <div class=""><input class="form-control" placeholder="Correo Electronico" type="text" name="email" ></div>
                </div>
                
                <div class="container">
                    <div class="">Clave</div>
                    <div class=""><input class="form-control" placeholder="Clave del usuario" type="password" name="pass"   ></div>
                </div>
                <div style="margin-top:10px"></div>
                <div class="container">
                    <div class="row mb-3 px-3"><button class="btn btn-danger"  style="margin-bottom: 15px">Registrarse</button> </div>
                </div>
                
                <%if( error == "si"){ %>
                    <div class="alert alert-warning" role="alert">
                        Ingrese los valores requeridos y correctamente...
                    </div>
                    <% } %>
            </div>
        </form>
    </body>
</html>
