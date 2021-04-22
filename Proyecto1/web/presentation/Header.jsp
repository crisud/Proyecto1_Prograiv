<!--Poner aqui el import -->
<%@page import="cursos.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>
<header>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class = "navbar-brand" href="/Proyecto1/presentation/Index.jsp">
                    <img src = "/Proyecto1/img/logo.png" alt = "imagenLogo" width="170">
                </a>
           
                <div class="collapse navbar-collapse" >
                    <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                        <li class="nav-item"><a class="nav-link px-2 link-light" href = "/Proyecto1/presentation/Index.jsp">Home</a></li>
                       
                    </ul>
                </div>
                
                <div class = "col-md-4 text-end">
                    <form class="col-12 mb-3 mb-lg-0 me-lg-3">
                        <input type="search" class="form-control" placeholder="Search...">
                    </form>
                </div>
                
                <div class="col-md-3 text-end">
                    <!--< if (usuario==null){>-->
                    
                    <!--< } >-->
                    <!--< if (usuario==null){>-->
                    <a type="button" class="btn btn-outline-light " href = "/Proyecto1/presentation/login/show">Login</a>
                    <a type="button" class="btn btn-danger" href = "/Proyecto1/presentation/login/show">Sign-up</a>
                    <!--< } >-->
                </div>
                
                
            </div>
        </nav>
</header>
