<%@page import="proyecto.logic.Medicos"%>
<%@page import="proyecto.presentacion.perfil.medico.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    Medicos medico = model.getCurrent();
%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    
<head>
     <%@ include file="/presentacion/head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Perfil medico</title>
    <meta name="description" content="Perfil Medico">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
    <body>
    <%@ include file="/presentacion/header.jsp" %>
        <div class="content">
            <div class="animated fadeIn">                     
                        <div>
                            <div class="card">
                                <div class="card-header">
                                    <i class="fa fa-user"></i><strong class="card-title pl-2">Perfil Medico</strong>
                                </div>
                                <div class="card-body">
                                    <div class="mx-auto d-block">
                                        <% if(medico.getFoto() != null){%>
                                        <img class="rounded-circle mx-auto d-block" width="100" height="100" src="data:image/jpg;base64,<%=medico.getFoto()%>" alt="Card image cap">
                                        <%}%>
                                        <h5 class="text-sm-center mt-2 mb-1"><%=medico.getNombre()%></h5>
                                        <div class="location text-sm-center"><i class="fa fa-envelope"></i> Correo: <%=medico.getCorreo()%></div>
                                        <div class="location text-sm-center"><i class="fa fa-star"></i> Especialidad: <%=(medico.getEspecialidad() != null) ? (medico.getEspecialidad().getNombre()) : ""%></div>
                                        <div class="location text-sm-center"><i class="fa fa-map-marker"></i> Ciudad donde atiende: <%=(medico.getCiudad()!= null) ? (medico.getCiudad().getNombre()) : ""%></div>
                                        <br><br>                       
                                        <div class="content">
                                            <div class="animated fadeIn">
                                                <div class="buttons">
                                                    <div class="row">                         
                                                    <div class="card-header">
                                                        <h3><i class="location text-sm-center"><i class="fa fa-comment"></i></i> Presentacion:</h3><br>
                                                        <% if(medico.getPresentacion() != null){%>
                                                        <p><i class="fa"></i><%=medico.getPresentacion()%></p><br>
                                                        <%}%>
                                                    </div>             
                                                    </div>
                                                </div>
                                            </div>
                                        </div>         
                                    </div>
                                    <div class="card-text text-sm-center">
                                        <% if(medico.getEstado().equals("ACEPTADO")){%>
                                        <a href="/proyecto-1-progra-4/presentacion/perfil/medico/showAjustar">
                                        <button type="button" class="btn btn-primary btn-lg btn-block"> Ajustar Perfil</button>
                                        </a>
                                        <%}else{%>
                                        <button type="button" class="btn btn-primary btn-lg btn-block" disabled> Ajustar Perfil (Disponibe cuando sea aceptado)</button>
                                        <%}%>
                                    </div>
                                </div>
                            </div>
                        </div>                                              
            </div>
        </div>
        <%@ include file="/presentacion/footer.jsp" %>
    </body>    
</html>




