<%-- 
    Document   : View
    Created on : 22 abr 2022, 16:05:51
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="proyecto.presentacion.buscar.medico.Model"%>
<%@page import="java.util.List"%>
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
        <title>Gestion de Citas</title>
        <meta name="description" content="Gestion de Citas">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <style>
            #centro{
                text-align : center;
            }
        </style>
    </head>
    <body>
        <%@ include file="/presentacion/header.jsp" %>
        <div class="breadcrumbs">
            <div class="breadcrumbs-inner">
                <div class="row m-0">
                    <div class="col-sm-4">
                        <div class="page-header float-left">
                            <div class="page-title">
                                <h1>Pacientes</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="/proyecto-1-progra-4/presentacion/index.jsp">Inicio</a></li>
                                    <li class="active">Buscar</li>
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
                                            <th>Foto de perfil</th>
                                            <th>Nombre</th>
                                            <th>Correo</th>
                                            <th>Especialidad</th>
                                            <th>Ciudad</th>
                                            <th>Costo</th>
                                            <th>Agendar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Medicos m:medicos){%>
                                            <% if(m.getEstado().equals("ACEPTADO")){%>
                                            <tr>
                                                <td> <span class="id"><%=m.getId()%></td>
                                                <td class ="avatar">
                                                    <div id="centro" class="round-img">
                                                        <a href="#"><img class="rounded-circle" width="50" height="50" src="data:image/jpg;base64,<%=m.getFoto()%>" alt=""></a>
                                                    </div>
                                                </td>
                                                <td> <span class="nombre"><%=m.getNombre()%></span> </td>
                                                <td> <span class="correo"><%=m.getCorreo()%></span></td>
                                                <td> <span class="especialidad"><%=m.getEspecialidad().getNombre()%></span></td>
                                                <td> <span class="ciudad"><%=m.getCiudad().getNombre()%></span> </td>
                                                <td><span class="costo">$<%=m.getCosto()%></span></td>
                                                <td>
                                                    <a href="/proyecto-1-progra-4/presentacion/buscar/medico/horarios?idmedico=<%=m.getId()%>">
                                                    <button type="button" class="btn btn-primary btn-lg btn-block">Horarios</button>
                                                    </a>
                                                </td>
                                            </tr>
                                            <%}%>
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
