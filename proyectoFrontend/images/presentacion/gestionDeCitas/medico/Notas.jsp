<%-- 
    Document   : Notas
    Created on : Apr 20, 2022, 12:20:20 PM
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="proyecto.logic.Citas"%>
<%@page import="proyecto.presentacion.gestiondecitas.medico.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    Citas cita = model.getCita();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentacion/head.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Anotaciones</title>
        <meta name="description" content="Anotaciones">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <%@ include file="/presentacion/header.jsp" %>
        <h1>Anotaciones</h1>
        <form action="/proyecto-1-progra-4/presentacion/gestiondecitas/medico/update" method="post">
            <div class="row form-group">
                <div class="col-12 col-md-9"><textarea name="anotaciones" id="textarea-input" rows="9" placeholder="Escriba sus anotaciones..." class="form-control" required></textarea></div>
            </div>
            <div class="row form-group">
                <div class="col-12 col-md-9">
                    <select name="estado" id="selectSm" class="form-control-sm form-control" required>
                        <option value="PENDIENTE">Pendiente</option>
                        <option value="COMPLETADA">Completada</option>
                    </select>
                </div>
            </div>
            <input type="hidden" name="idcita" value="<%=cita.getId()%>" />
            <div class="card-body">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>
     <%@ include file="/presentacion/footer.jsp" %>
    </body>
</html>

