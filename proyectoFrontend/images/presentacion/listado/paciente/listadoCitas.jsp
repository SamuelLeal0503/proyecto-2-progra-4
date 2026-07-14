<%-- 
    Document   : listadoCitas
    Created on : Apr 25, 2022, 1:41:59 PM
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="proyecto.logic.Citas"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.presentacion.listado.paciente.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Citas> citas = model.getCitas();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentacion/head.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Listado Citas</title>
        <meta name="description" content="Listado Citas">
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
                                <h1>Paciente</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="/proyecto-1-progra-4/presentacion/index.jsp">Inicio</a></li>
                                    <li class="active">Listado Citas</li>
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
                                <strong class="card-title">Lista de Citas</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Imagen</th>
                                            <th>Nombre</th>
                                            <th>Fecha y hora</th>
                                            <th>Costo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Citas c : citas){%>
                                        <tr>
                                            <td><%=c.getId()%></td>
                                            <td class ="avatar">
                                                <div id="centro" class="round-img">
                                                    <a href="#"><img class="rounded-circle" width="100" height="100" src="data:image/jpg;base64,<%=c.getMedico().getFoto()%>" alt=""></a>
                                                </div>
                                            </td>
                                            <td><%=c.getMedico().getNombre()%></td>
                                            <td><%=fechaToString(c.getFecha())%></td>
                                            <td>$<%=c.getMedico().getCosto()%></td>
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
<%!

    public String fechaToString(LocalDateTime fecha){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
 
        // Format LocalDateTime to String
        return fecha.format(dateTimeFormatter);
    }


%>