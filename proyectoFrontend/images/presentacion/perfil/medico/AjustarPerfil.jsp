<%@page import="proyecto.logic.Especialidad"%>
<%@page import="proyecto.logic.Ciudades"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.logic.Medicos"%>
<%@page import="proyecto.presentacion.perfil.medico.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    Medicos medico = model.getCurrent();
    List<Ciudades> ciudades = model.getCiudades();
    List<Especialidad> especialidades = model.getEspecialidades();
%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <%@ include file="/presentacion/head.jsp" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ajustar Perfil</title>
    <meta name="description" content="Ajustar Perfil">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
    <body>
    <%@ include file="/presentacion/header.jsp" %>
        <div class="content">
            <div class="animated fadeIn">    
                <div>
                    <div class="card">
                            <div class="card-header">
                                <strong>Ajustar Perfil</strong> / Medico 
                            </div>
                            <div class="card-body card-block">
                                <form action="/proyecto-1-progra-4/presentacion/perfil/medico/update" method="post" class="form-horizontal" enctype="multipart/form-data">
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class=" form-control-label">Nombre</label></div>
                                        <div class="col-12 col-md-9">
                                            <p class="form-control-static"><%=medico.getNombre()%></p>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class=" form-control-label">Correo</label></div>
                                        <div class="col-12 col-md-9">
                                            <p class="form-control-static"><%=medico.getCorreo()%></p>
                                        </div>
                                    </div>
                                    
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Precio Consulta </label></div>
                                        <div class="col-12 col-md-9"><input type="number" id="text-input" name="costo" placeholder="precio consulta" class="form-control" required></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="select" class=" form-control-label">Ciudad</label></div>
                                        <div class="col-12 col-md-9">
                                            <select name="ciudad" id="ciudad" class="form-control" required>
                                                <option value="0">Seleccione una opcion</option>
                                                <% for(Ciudades c:ciudades){%>
                                                <option value="<%=c.getId()%>"><%=c.getNombre()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="select" class=" form-control-label">Especialidad</label></div>
                                        <div class="col-12 col-md-9">
                                            <select name="especialidad" id="especialiad" class="form-control" required>
                                                <option value="0">Seleccione una opcion</option>
                                                <% for(Especialidad e:especialidades){%>
                                                <option value="<%=e.getId()%>"><%=e.getNombre()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="textarea-input" class=" form-control-label">Presentacion</label></div>
                                        <div class="col-12 col-md-9"><textarea name="presentacion" id="textarea-input" rows="9" placeholder="Contenido..." class="form-control" required></textarea></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="file-input" class=" form-control-label">Foto de Perfil</label></div>
                                        <div class="col-12 col-md-9"><input type="file" id="file-input" name="foto" class="form-control-file" required></div>
                                    </div>
                                   <div class="card-body">
                                       <button type="submit" class="btn btn-success">Guardar</button>
                                    </div>
                     
                                </form>
                            </div>
                        </div>

                        </div>
                    </div>
                
            </div>
        <div class="content">
            <div class="animated fadeIn">    
                <div>
                    <div class="card">
                            <div class="card-header">
                                <strong>Ajustar Horario</strong> / Medico 
                            </div>
                            <div class="card-body card-block">
                                <form action="/proyecto-1-progra-4/presentacion/perfil/medico/agregarHorario" method="post" class="form-horizontal">
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Dia (1 = Lunes, 7 = Domingo)</label></div>
                                        <div class="col-12 col-md-9"><input type="number" id="text-input" name="dia" placeholder="Dia de atencion" class="form-control" required></div>
                                    </div>                                                                                   
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Hora de inicio (8 = 08:00am, reloj 24 horas)</label></div>
                                        <div class="col-12 col-md-9"><input type="number" id="text-input" name="horaEntrada" placeholder="Hora de inicio" class="form-control" required></div>
                                    </div>                                                                                   
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Hora de salida (17 = 05:00pm, reloj 24 horas)</label></div>
                                        <div class="col-12 col-md-9"><input type="number" id="text-input" name="horaSalida" placeholder="Hora de salida" class="form-control" required></div>
                                    </div>                                                                                   
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Frecuencia (Minutos: 30 = 30 minutos, 60 = 1 hora)</label></div>
                                        <div class="col-12 col-md-9"><input type="number" id="text-input" name="frecuencia" placeholder="Frecuencia" class="form-control" required></div>
                                    </div>
                                    <div class="card-body">
                                        <button type="submit" class="btn btn-warning">Agregar</button>
                                    </div>
                                </form>
                            </div>
                        </div>

                        </div>
                    </div>
                
            </div>       
    <%@ include file="/presentacion/footer.jsp" %>    
    </body>
</html>
