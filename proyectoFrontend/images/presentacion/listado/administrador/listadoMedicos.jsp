<%-- 
    Document   : listadoMedicos
    Created on : Apr 14, 2022, 5:37:15 PM
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="proyecto.presentacion.listado.administrador.Model"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.logic.Medicos"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Medicos> medicos = model.getMedicos();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentacion/head.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Listado Medicos</title>
        <meta name="description" content="Listado Medicos">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
    <%@ include file="/presentacion/header.jsp" %>
        <div class="breadcrumbs">
            <div class="breadcrumbs-inner">
                <div class="row m-0">
                    <div class="col-sm-4">
                        <div class="page-header float-left">
                            <div class="page-title">
                                <h1>Administrador</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="/proyecto-1-progra-4/presentacion/index.jsp">Inicio</a></li>
                                    <li class="active">Listado Medicos</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="content">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Lista de Medicos</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Correo</th>
                                            <th>Estado</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Medicos m:medicos){%>
                                        <tr>
                                            <td><%=m.getId()%></td>
                                            <td><%=m.getNombre()%></td>
                                            <td><%=m.getCorreo()%></td>
                                            <td>
                                                <% if(m.getEstado().equals("DENEGADO")){%>
                                                <a href="/proyecto-1-progra-4/presentacion/listado/administrador/updateEstadoMedico?idmedico=<%=m.getId()%>&estadomedico=ACEPTADO"><button type="submit" class="btn btn-success"><i class="fa fa-plus"></i>&nbsp; Aceptar</button></a>
                                                <%}else{%>
                                                ACEPTADO
                                                <%}%>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
        <%@ include file="/presentacion/footer.jsp" %>
    </body>
</html>
