
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cursos.logic.Curso"%>


<%
    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
    Usuario usu = (Usuario) session.getAttribute("usuario");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido al sistema de cursos libres!</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        
        <div class="p-5 mb-4 bg-secondary rounded-3">
            <div class="container-fluid py-5">
              <h1 class="display-5 fw-bold text-light">Matricule ya!</h1>
              <p class="col-md-8 fs-4 text-light">En Cursoslibres.com ofrecemos un amplio catalogo de cursos los cuales van desde la cocina, tecnología, hasta arte, mejora como prefesional y aprende con los mejores profesionales! </p>
              <button class="btn btn-danger btn-lg" type="button">Inscribirse</button>
            </div>
        </div>
        
        <div class = "row row-cols-2 row-cols-sm-3 row-cols-md-4 g-4">
            
            <% for(Curso c : cursos){%>
            <div class = "col">
                <div class="card shadow-sm " style="width: 18rem;">
                    <img src="/Proyecto1/img/cursoPintura.jpg" class="card-img-top" alt="cursoPintura">
                    <div class="card-body">
                        
                        <h5 class="card-title"><%=c.getNombre()%></h5>
                        <h5 class="card-title">Codigo: <%=c.getId()%></h5>
                        <p class="card-text">Precio: <%=c.getPrecio()%></p>
                        <%if(c.enOferta()){%>
                        <br>
                        <p class="card-text">En oferta</p>
                        <%}%>
                        <%if(usu == null){%>
                        <a href="/Proyecto1/presentation/login/show" class="btn btn-danger">Matricular</a>
                        <%}else if(usu.getTipo() == "Estudiante"){%>
                        <a href="/Proyecto1/presentation/estudiante/detalla?curso=<%=c.getId()%> class="btn btn-danger">Matricular</a>
                        
                        
                        <%}%>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        
    </body>
</html>
