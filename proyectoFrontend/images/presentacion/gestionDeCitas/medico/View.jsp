<%-- 
    Document   : View
    Created on : 13 abr 2022, 16:05:51
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.presentacion.gestiondecitas.medico.Model"%>
<%@page import="proyecto.logic.Citas"%>
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
        <title>Gestion de Citas</title>
        <meta name="description" content="Gestion de Citas">
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
                                <h1>Medico</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="/proyecto-1-progra-4/presentacion/index.jsp">Inicio</a></li>
                                    <li class="active">Gestion de Citas</li>
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
                                            <th>Nombre</th>
                                            <th>Fecha y hora</th>
                                            <th>Estado</th>
                                            <th>Anotaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Citas c : citas){%>
                                        <tr>
                                            <td> <span class="id"><%=c.getId()%></td>
                                            <td>  <span class="nombre"><%=c.getPaciente().getNombre()%></span> </td>
                                            <td> <span class="fecha"><%=fechaToString(c.getFecha())%></span> </td>
                                            <td><span class="hora"><%=c.getEstado()%></span></td>
                                            <td>
                                                <a href="/proyecto-1-progra-4/presentacion/gestiondecitas/medico/showNotas?idcita=<%=c.getId()%>">
                                                <button type="button" class="btn btn-secondary"><i class="fa fa-file-text-o"></i>&nbsp;</button>
                                                </a>
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
<%!

    public String fechaToString(LocalDateTime fecha){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
 
        // Format LocalDateTime to String
        return fecha.format(dateTimeFormatter);
    }


%>