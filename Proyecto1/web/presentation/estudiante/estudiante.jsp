<%-- 
    Author     : Calef
--%>


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
        
        <div class = " row row-cols-2 row-cols-sm-2 row-cols-md-3 g-2">
            
            <div class="p-2 mb-4 bg-secondary rounded-3">
                <div class="container-fluid py-5">
                  <h1 class="display-5 fw-bold text-light">Mi información Personal</h1>
                  <p class="col-md-8 fs-8 text-light">Using a series of utilities, you can create this jumbotron, just like the one in previous versions of Bootstrap. Check out the examples below for how you can remix and restyle it to your liking.</p>
                  <button class="btn btn-info btn-lg" type="button">Ver mi info</button>
                </div>
            </div>
            <div class="p-2 mb-4 bg-secondary rounded-3">
                <div class="container-fluid py-5">
                  <h1 class="display-5 fw-bold text-light">Mis Cursos Matriculados</h1>
                  <p class="col-md-8 fs-8 text-light">Using a series of utilities, you can create this jumbotron, just like the one in previous versions of Bootstrap. Check out the examples below for how you can remix and restyle it to your liking.</p>
                  <button class="btn btn-primary btn-lg" type="button">Ver mis cursos</button>
                </div>
            </div>
            <div class="p-2 mb-4 bg-secondary rounded-3">
                <div class="container-fluid py-5">
                  <h1 class="display-5 fw-bold text-light">Mi historial de cursos</h1>
                  <p class="col-md-8 fs-8 text-light">Using a series of utilities, you can create this jumbotron, just like the one in previous versions of Bootstrap. Check out the examples below for how you can remix and restyle it to your liking.</p>
                  <button class="btn btn-warning btn-lg" type="button">Mi historial</button>
                </div>
            </div>
        </div>
       
        <div class="p-2 mb-4 bg-secondary rounded-3">
            <div class="container-fluid py-5">
              <h1 class="display-5 fw-bold text-light">Matricule ya!</h1>
              <p class="col-md-8 fs-4 text-light">Using a series of utilities, you can create this jumbotron, just like the one in previous versions of Bootstrap. Check out the examples below for how you can remix and restyle it to your liking.</p>
              <button class="btn btn-danger btn-lg" type="button">ver mis cursos</button>
            </div>
        </div>
        
        <div class = "row row-cols-2 row-cols-sm-3 row-cols-md-4 g-4">
            <div class = "col">
                <div class="card shadow-sm " style="width: 18rem;">
                    <img src="/Proyecto1/img/cursoPintura.jpg" class="card-img-top" alt="cursoPintura">
                    <div class="card-body">
                        
                        <h5 class="card-title">Pintura</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-danger">Matricular</a>
                        <a href="#" class="btn btn-outline-danger">ver detalles</a>
                    </div>
                </div>
            </div>
            <div class = "col" >
                <div class="card shadow-sm" style="width: 18rem;">
                    <img src="/Proyecto1/img/cursoPintura.jpg" class="card-img-top" alt="cursoPintura">
                    <div class="card-body">
                        
                        <h5 class="card-title">Pintura</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-danger">Matricular</a>
                        <a href="#" class="btn btn-outline-danger">ver detalles</a>
                    </div>
                </div>
            </div>
            <div class = "col">
                <div class="card shadow-sm" style="width: 18rem;">
                    <img src="/Proyecto1/img/cursoPintura.jpg" class="card-img-top" alt="cursoPintura">
                    <div class="card-body">
                        
                        <h5 class="card-title">Pintura</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-danger">Matricular</a>
                        <a href="#" class="btn btn-outline-danger">ver detalles</a>
                    </div>
                </div>
            </div>
            <div class = "col">
                <div class="card shadow-sm" style="width: 18rem;">
                    <img src="/Proyecto1/img/cursoPintura.jpg" class="card-img-top" alt="cursoPintura">
                    <div class="card-body">
                        
                        <h5 class="card-title">Pintura</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-danger">Matricular</a>
                        <a href="#" class="btn btn-outline-danger">ver detalles</a>
                    </div>
                </div>
            </div>
            <div class = "col">
                <div class="card shadow-sm" style="width: 18rem;">
                    <img src="/Proyecto1/img/cursoPintura.jpg" class="card-img-top" alt="cursoPintura">
                    <div class="card-body">
                        
                        <h5 class="card-title">Pintura</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-danger">Matricular</a>
                        <a href="#" class="btn btn-outline-danger">ver detalles</a>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
