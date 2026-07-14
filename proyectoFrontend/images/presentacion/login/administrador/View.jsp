<%@page import="java.util.HashMap"%>
<%@page import="proyecto.presentacion.login.administrador.Model"%>
<%@page import="java.util.Map"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <%@ include file="/presentacion/head.jsp" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login Administrador</title>
    <meta name="description" content="Login Administrador">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    
    <% Model model= (Model) request.getAttribute("model"); %>
    <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
    <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
    
    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-form">
                    <form name="form" action="/proyecto-1-progra-4/presentacion/login/administrador/login" method="post">
                        <div class="login-logo">
                            <a href="/proyecto-1-progra-4/presentacion/index.jsp">
                                <img src="/proyecto-1-progra-4/images/logo.png" class="mt-3" class="align-content" alt="">
                            </a>
                        </div>
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" name="correo" class="form-control <%=erroneo("correo",errores)%>" value="<%=form.get("correo")[0]%>" title="<%=title("correo",errores)%>" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control <%=erroneo("password",errores)%>" value="<%=form.get("password")[0]%>" title="<%=title("password",errores)%>" placeholder="Password">
                        </div>
                        <div class="social-button">
                            <button type="submit" class="btn social facebook btn-flat btn-addon mt-3">Iniciar sesion (Administrador) </button>
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
       values.put("correo", new String[]{model.getCurrent().getCorreo()});
       values.put("password", new String[]{model.getCurrent().getPassword()});
       return values;
    }
    
%> 