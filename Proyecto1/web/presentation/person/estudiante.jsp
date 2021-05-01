<%-- 
    Author     : Calef
--%>
<%@page import="cursos.logic.Curso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    List<Curso> cursos = (List<Curso>) session.getAttribute("cursos");
    
%>

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
                  <h1 class="display-5 fw-bold text-light">Mi información Personal</h1>
                  <p class="col-md-8 fs-8 text-light">Acceda a su información personal y editela si desea.</p>
                  <a href="/Proyecto1/presentation/estudiante/datos" class="btn btn-info btn-lg" > Ver mi info</a>
                </div>
            </div>
            <div class="p-2 mb-4 bg-secondary ">
                <div class="container-fluid py-5">
                  <h1 class="display-5 fw-bold text-light">Mis Cursos Matriculados</h1>
                  <p class="col-md-8 fs-8 text-light">Échele un vistazo al historial de cursos que ha matriculado y su informacion respectiva.</p>
                  <a href="/Proyecto1/presentation/estudiante/cursos" class="btn btn-primary btn-lg" > Ver mis cursos</a>
          
                </div>
            </div>
        </div>
       
        <div class=" sb-9 bg-danger rounded-3">
            <div class="container-fluid py-0">
              <h1 class="display-5 fw-bold text-light">Matricule ya!</h1>
              <p class="col-md-8 fs-4 text-light">Puedes ver todo la oferta de cursos disponibles deslizando para abajo.</p>
             <!-- <button class="btn btn-danger btn-lg" type="button">ver mis cursos</button> -->
            </div>
        </div>
        
        <div class = "row row-cols-2 row-cols-sm-3 row-cols-md-4 g-4">
            <%if (cursos != null)%>
                <% for(Curso cur: cursos){ %>
                <div class = "col">
                    <div class="card shadow-sm " style="width: 18rem;">
                        <img src="/Proyecto1/img/curso<%= cur.getNombre()%>.jpg" class="card-img-top" alt="<%= cur.getNombre()%>">
                        <div class="card-body">

                            <h5 class="card-title"><%= cur.getNombre()%></h5>
                            <p class="card-text"><%= cur.getTematica()%></p>
                           
                            <a href="/Proyecto1/presentation/estudiante/detalles" class="btn btn-outline-danger">ver detalles</a>
                        </div>
                    </div>
                </div>
            <% } %>
           
        </div>
        
    </body>
</html>
