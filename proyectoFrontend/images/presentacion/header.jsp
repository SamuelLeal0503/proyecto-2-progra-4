<%-- 
    Document   : header
    Created on : Apr 14, 2022, 3:09:11 PM
    Author     : Rodrigo, Samuel y Jose
--%>
<%@page import="proyecto.logic.Paciente"%>
<%@page import="proyecto.logic.Medicos"%>
<%@page import="proyecto.logic.Administrador"%>
<%

    Administrador usuarioA = null;
    Medicos usuarioM = null;
    Paciente usuarioP = null;
    try {
        usuarioA = (Administrador) session.getAttribute("usuario");
    } catch (Exception e) {
    }
    
    try {
        usuarioM = (Medicos) session.getAttribute("usuario");
    } catch (Exception e) {
    }
    
    try {
        usuarioP = (Paciente) session.getAttribute("usuario");
    } catch (Exception e) {
    }

%>
    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="/proyecto-1-progra-4/presentacion/index.jsp"><i class="menu-icon fa fa-laptop"></i>Inicio </a></li>
                    
                    <% if((usuarioA == null && usuarioM == null && usuarioP == null) || usuarioP != null){%>
                    <li class="menu-title">Pacientes</li><!-- pacientes -->
                    <li><a href="/proyecto-1-progra-4/presentacion/buscar/medico/show"><i class="menu-icon fa fa-search"></i>Buscar</a></li>
                    <%}%>
                    <% if(usuarioP != null){%>
                    <li><a href="/proyecto-1-progra-4/presentacion/listado/paciente/show"><i class="menu-icon fa fa-calendar"></i>Lista de Citas</a></li>
                    <%}%>
                    <% if(usuarioM != null){%>
                    <li class="menu-title">Medicos</li><!-- medicos -->
                    <li><a href="/proyecto-1-progra-4/presentacion/perfil/medico/show"> <i class="menu-icon fa fa-user"></i>Perfil</a></li>
                    
                    <li><a href="/proyecto-1-progra-4/presentacion/gestiondecitas/medico/show"> <i class="menu-icon fa fa-calendar"></i>Gestion de Citas</a></li>
                    <%}%>

                    <% if(usuarioA != null){%>
                    <li class="menu-title">Administrador</li><!-- administrador -->
                    <li><a href="/proyecto-1-progra-4/presentacion/listado/administrador/showCiudades"> <i class="menu-icon fa fa-building-o"></i>Ciudades</a></li>
                    
                    <li><a href="/proyecto-1-progra-4/presentacion/listado/administrador/showMedicos"> <i class="menu-icon fa fa-asterisk"></i>Medicos</a></li>
                    
                    <li><a href="/proyecto-1-progra-4/presentacion/listado/administrador/showEspecialidades"> <i class="menu-icon fa fa-briefcase"></i>Especialidades</a></li>
                    <%}%>
                    
                    <li class="menu-title">Extras</li><!-- extras -->
                    <% if(usuarioA == null && usuarioM == null && usuarioP == null){%>
                    <li><a href="/proyecto-1-progra-4/presentacion/login/ViewTresBotones.jsp"> <i class="menu-icon fa fa-sign-in"></i>Ingresar</a></li>
                    
                    <li><a href="/proyecto-1-progra-4/presentacion/registro/ViewTresBotones.jsp"> <i class="menu-icon fa fa-sign-in"></i>Registrar</a></li>
                    <%} else{ %>
                    <li><a href="/proyecto-1-progra-4/presentacion/login/administrador/logout"> <i class="menu-icon fa fa-sign-in"></i>Logout</a></li>
                    <%}%>
                </ul>
            </div>
        </nav>
    </aside>
    <div id="right-panel" class="right-panel">
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="./"><img src="/proyecto-1-progra-4/images/logo.png" alt="Logo"></a>
                    <a class="navbar-brand hidden" href="./"><img src="/proyecto-1-progra-4/images/logo2.png" alt="Logo"></a>
                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                </div>
            </div>
        </header> 
