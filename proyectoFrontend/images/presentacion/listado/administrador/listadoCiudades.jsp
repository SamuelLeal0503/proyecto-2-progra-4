<%-- 
    Document   : listadoCiudades
    Created on : Apr 14, 2022, 5:37:33 PM
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="proyecto.presentacion.listado.administrador.Model"%>
<%@page import="proyecto.logic.Ciudades"%>
<%@page import="java.util.List"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Ciudades> ciudades = model.getCiudades();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentacion/head.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Listado Ciudades</title>
        <meta name="description" content="Listado Ciudades">
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
                                    <li class="active">Listado Ciudades</li>
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
                                <strong class="card-title">Lista de Ciudades</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <%--<th>Editar</th>--%>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Ciudades c:ciudades){%>
                                        <tr>
                                            <td><%=c.getId()%></td>
                                            <td><%=c.getNombre()%></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="card">
                            <div class="card-header">Agregar Ciudad</div>
                            <div class="card-body card-block">
                                <form action="/proyecto-1-progra-4/presentacion/listado/administrador/agregarCiudad" method="post" class="">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" name="nombreciudad" placeholder="Ciudad" class="form-control" required>
                                            <div class="input-group-addon"><i class="fa fa-building-o"></i></div>
                                        </div>
                                    </div>
                                    <div class="form-actions form-group"><button type="submit" class="btn btn-success"><i class="fa fa-plus"></i>&nbsp; Agregar</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
        <%@ include file="/presentacion/footer.jsp" %>
    </body>
</html>
