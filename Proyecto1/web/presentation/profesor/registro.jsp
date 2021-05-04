<%-- 
    Document   : registro
    Created on : 2 may. 2021, 19:22:37
    Author     : Hp
--%>

<%@page import="cursos.logic.Matricula"%>
<%@page import="java.util.List"%>
<%@page import="cursos.logic.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Estudiante> est = (List<Estudiante>)request.getAttribute("EstGrupo");
  List<Matricula> mats = (List<Matricula>)request.getAttribute("matriculas");
  Estudiante e = new Estudiante();
  Matricula m = new Matricula();
  String actual = (String) request.getParameter("id_group");
  String id_estu = (String) request.getParameter("id_est");
  for(Estudiante es:est){
      if(id_estu.equals(es.getId())){
          e = es;
      }
  }
  for(Matricula a: mats){
        if(a.getEstudiante().getId().equals(e.getId()) && a.getGrupo().getId().equals(actual))
            m = a;
    }
  request.setAttribute("matri", m);
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class="p-4">
            <form class = "" name="form-signup" action="/Proyecto1/presentation/profesor/estua" method="post" > 
                <label for="nota" class="form-label">Introduzca la nota de <%=e.getNombre()%></label>
                <input type="number" class="form-control" id="calif" placeholder="Introduzca la calificacion">
                <div class=" p-3"><button class="btn btn-danger" >Registrar nota</button> 
                    <%Matricula ma = (Matricula)request.getAttribute("matri");
                      ma.setNota((Double)request.getAttribute("calif"));
                    %>
                </div>
            </form>
        </div>
    </body>
</html>
