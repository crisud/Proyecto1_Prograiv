<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        
        <div class = " row row-cols-2 row-cols-sm-2 g-2">
            
            <div class="p-2 mb-4 bg-secondary ">
                <div class="container-fluid py-5">
                  <h1 class="display-5 fw-bold text-light">Cursos</h1>
                  <p class="col-md-8 fs-8 text-light">Observe y modifique los cursos y cree sus grupos</p>
                  <a href="/Proyecto1/presentation/administrador/cursos/show" class="btn btn-primary btn-lg" >Modificar cursos</a>
                  <a href="/Proyecto1/presentation/administrador/cursos/create/show" class="btn btn-primary btn-lg" >Crear curso</a> 
                </div>
            </div>
            <div class="p-2 mb-4 bg-secondary ">
                <div class="container-fluid py-5">
                  <h1 class="display-5 fw-bold text-light">Profesores</h1>
                  <p class="col-md-8 fs-8 text-light">Observe y cree profesores</p>
                  <a href="/Proyecto1/presentation/administrador/profesores/show" class="btn btn-primary btn-lg" >Ver profesores</a>
                  <a href="/Proyecto1/presentation/administrador/profesor/create/show" class="btn btn-primary btn-lg" >Crear profesor</a>
                </div>
            </div>
        </div>
        
    </body>
</html>
