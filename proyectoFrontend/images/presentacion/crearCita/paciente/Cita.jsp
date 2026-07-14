<%-- 
    Document   : Cita
    Created on : Apr 16, 2022, 4:56:53 PM
    Author     : Rodrigo, Samuel y Jose
--%>
<%
    Paciente usuario = null;
    try {
        usuario = (Paciente) session.getAttribute("usuario");
    } catch (Exception e) {
    }
    if (usuario == null) {
        String redirectURL = "/proyecto-1-progra-4/presentation/paciente/login/show";
        response.sendRedirect(redirectURL);
    }
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
                                    <li class="active">Agendar Cita</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="animated fadeIn">
                <div>
                    <div>
                        <section class="card">
                            <div class="twt-feed blue-bg">
                                <div class="corner-ribon black-ribon">
                                    <i class="fa"></i>
                                </div>
                                <div class="fa wtt-mark"></div>

                                <div class="media">
                                    <a href="#">
                                        <img class="align-self-center rounded-circle mr-3" style="width:85px; height:85px;" alt="" src="/proyecto-1-progra-4/images/avatar/64-2.jpg">
                                    </a>
                                    <div class="media-body">
                                        <h2 class="text-white display-6">Keylor Navas</h2>
                                        <p class="text-light">Medico General</p>
                                    </div>
                                </div>
                            </div>
                            <div class="weather-category twt-category">
                                <ul>
                                    <li class="active">
                                        <h5>Ciudad</h5>
                                        Heredia
                                    </li>
                                    <li>
                                        <h5>Correo</h5>
                                        KeylorNavas@gmail.com
                                    </li>
                                    <li>
                                        <h5>Costo de consulta</h5>
                                        $ 5000
                                    </li>
                                </ul>
                            </div>
                            <div id = centro class="twt-write col-sm-12">
                                <p>Keylor Antonio Navas Gamboa, simplemente conocido como Keylor Navas, es un futbolista costarricense, nacionalizado español.​ Juega de portero y su equipo actual es el París Saint-Germain F. C. de la Ligue 1 de Francia</p><br>
                            </div>
                        </section>
                    </div>
                    </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header"><strong>Informacion de la cita</strong></div>
                                    <div class="card-body card-block">
                                        <div class="row form-group">
                                            <form action="/presentacion/crearcita/paciente/agregar">
                                                <div class="col-8">
                                                    <div class="form-group"><label for="disable-input" class=" form-control-label">Fecha</label><input type="text" id="disabled-input" name="disabled-input" placeholder="xx/xx/xxxx" disabled="" class="form-control"></div>
                                                </div>
                                                <div class="col-8">
                                                    <div class="form-group"><label for="disable-input" class=" form-control-label">Hora</label><input type="text" id="disabled-input" name="disabled-input" placeholder="xx:xx" disabled="" class="form-control"></div>
                                                </div>
                                                <div class="col-8">
                                                    <div class="form-actions form-group">
                                                        <button type="submit" class="btn btn-success"><i class="fa fa-check"></i>&nbsp; Reservar</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    <%@ include file="/presentacion/footer.jsp" %>
    </body>
</html>
