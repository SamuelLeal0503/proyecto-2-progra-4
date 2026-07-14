<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="proyecto.presentacion.registro.medico.Model"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
     <%@ include file="/presentacion/head.jsp" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registro Medico</title>
    <meta name="description" content="Registro Medico">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    
    <% Model model = (Model) request.getAttribute("model"); %>
    <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
    <% Map<String,String[]> form = (errores==null)? this.getForm(model):request.getParameterMap(); %>
    
    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-form">
                    <div class="login-logo">
                    <a href="/proyecto-1-progra-4/presentacion/index.jsp">
                        <img src="/proyecto-1-progra-4/images/logo.png" class="mt-3" class="align-content" alt="">
                    </a>
                </div>
                    <form name="form" id="registro" action="/proyecto-1-progra-4/presentacion/registro/medico/registro" method="post" onsubmit="event.preventDefault(); return checkPass();">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="nombre" class="form-control <%=erroneo("nombre",errores)%>" value="<%=form.get("nombre")[0]%>" title="<%=title("nombre",errores)%>" placeholder="Nombre" required>
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="email" name="correo" class="form-control <%=erroneo("correo",errores)%>" value="<%=form.get("correo")[0]%>" title="<%=title("correo",errores)%>" placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="password" id="contra" class="form-control <%=erroneo("password",errores)%>" value="<%=form.get("password")[0]%>" title="<%=title("password",errores)%>" placeholder="Contraseña" required>
                        </div>
                        <div class="form-group">
                            <label>Confirmar Contraseña</label>
                            <input type="password" name="checkPassword" id="contracheck" class="form-control <%=erroneo("checkPassword",errores)%>" title="<%=title("password",errores)%>" placeholder="Confirmar Contraseña" required>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" required/> Estoy de acuerdo con los terminos y condiciones.
                            </label>
                        </div>
                        <div class="social-button">
                            <button type="submit" class="btn social twitter btn-flat btn-addon mt-2">Registrarse (Medico) </button>
                        </div>
                        <div class="register-link m-t-15 text-center">
                            <p>Ya tienes una cuenta? <a href="/proyecto-1-progra-4/presentacion/login/ViewTresBotones.jsp"> Iniciar sesion</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/presentacion/footer.jsp" %>
</body>
</html>

<%! 

    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("nombre", new String[]{model.getCurrent().getNombre()});
       values.put("correo", new String[]{model.getCurrent().getCorreo()});
       values.put("password", new String[]{model.getCurrent().getPassword()});
       return values;
    }



%>