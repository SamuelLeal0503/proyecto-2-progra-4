<%-- 
    Document   : View
    Created on : 22 abr 2022, 16:05:51
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@page import="proyecto.logic.Horario"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.presentacion.buscar.medico.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Horario> horarios = model.getHorarios();
    Medicos medico = horarios.get(0).getMedico();
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
                                    <li class="active">Horario extendido</li>
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
                                        <img class="align-self-center rounded-circle mr-3" style="width:85px; height:85px;" alt="" src="data:image/jpg;base64,<%=medico.getFoto()%>">
                                    </a>
                                    <div class="media-body">
                                        <h2 class="text-white display-6"><%=medico.getNombre()%></h2>
                                        <p class="text-light"><%=medico.getEspecialidad().getNombre()%></p>
                                    </div>
                                </div>
                            </div>
                            <div class="weather-category twt-category">
                                <ul>
                                    <li class="active">
                                        <h5>Ciudad</h5>
                                        <%=medico.getCiudad().getNombre()%>
                                    </li>
                                    <li>
                                        <h5>Correo</h5>
                                        <%=medico.getCorreo()%>
                                    </li>
                                    <li>
                                        <h5>Costo de consulta</h5>
                                        $<%=medico.getCosto()%>
                                    </li>
                                </ul>
                            </div>
                            <div id = centro class="twt-write col-sm-12">
                                <p><%=medico.getPresentacion()%></p><br>
                            </div>
                        </section>
                    </div>
                    </div>
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Lista de horarios</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Dia</th>
                                            <th>Hora</th>
                                            <th>Agendar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Horario horario : horarios){%>
                                        <% for(String hora : horariosF(horario)){%>
                                        <tr>
                                            <td> <span class="fecha"><%=fecha(horario.getDia())%></span> </td>
                                            <td> <span class="Dia"><%=hora%></span></td>
                                            <td>
                                                <a href="/proyecto-1-progra-4/presentacion/buscar/medico/agendar?idhorario=<%=horario.getId()%>&hora=<%=hora%>">
                                                <button type="button" class="btn btn-secondary btn-lg btn-block">Agendar</button>
                                                </a>
                                            </td>
                                        </tr>
                                        <%}}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/presentacion/footer.jsp" %>
    </body>
</html>
<%!

    public String fecha(int dia){
        switch (dia) {
                case 1:
                    return "Lunes";
                case 2:
                    return "Martes";
                case 3:
                    return "Miercoles";
                case 4:
                    return "Jueves";
                case 5:
                    return "Viernes";
                case 6:
                    return "Sabado";
                case 7:
                    return "Domingo";
                default:
                    throw new AssertionError();
            }
    }

    public List<String> horariosF(Horario h){
        LocalTime horaE = LocalTime.of(h.getHoraEntrada(), 0);
        LocalTime horaS = LocalTime.of(h.getHoraSalida(), 0);
        int frecuencia = h.getFrecuencia();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime fre = horaE;
        List<String> horas = new ArrayList<>();

        while (fre.isBefore(horaS)) {                
            horas.add(fre.format(dtf));
            fre = fre.plusMinutes(frecuencia);
        }

        return horas;
    }


%>