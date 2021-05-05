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
  Estudiante e = new Estudiante();
  String actual = (String) request.getParameter("id_group");
  String id_estu = (String) request.getParameter("id_est");
  for(Estudiante es:est){
      if(id_estu.equals(es.getId())){
          e = es;
      }
  }
  
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class="p-4">
            <form class = "" name="form-nota" action="/Proyecto1/presentacion/profesor/registroNotaUpdate?id_group=<%=actual%>&id_est=<%=e.getId()%>" method="post" > 
                <label for="calif" class="form-label">Introduzca la nota de <%=e.getNombre()%></label>
                <input type="number" class="form-control" name ="nota" placeholder="Introduzca la calificacion">
                <div class=" p-3"><button class="btn btn-danger" >Registrar nota</button> 
                </div>
                
            </form>
        </div>
    </body>
</html>
