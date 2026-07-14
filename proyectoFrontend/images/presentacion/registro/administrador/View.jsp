<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <%@ include file="/presentacion/head.jsp" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registro Administrador</title>
    <meta name="description" content="Registro Administrador">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-form">
                    <div class="login-logo">
                    <a href="/proyecto-1-progra-4/presentacion/index.jsp">
                        <img src="/proyecto-1-progra-4/images/logo.png" class="mt-3" class="align-content" alt="">
                    </a>
                </div>
                    <form>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="email" class="form-control" placeholder="Nombre">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="email" class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" class="form-control" placeholder="Contraseña">
                        </div>
                        <div class="form-group">
                            <label>Confirmar Contraseña</label>
                            <input type="password" class="form-control" placeholder="Confirmar Contraseña">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Estoy de acuerdo con los terminos y condiciones.
                            </label>
                        </div>
                        <div class="social-button">
                            <button type="submit" class="btn social facebook btn-flat btn-addon mt-3">Registrarse (Administrador) </button>
                        </div>
                        <div class="register-link m-t-15 text-center">
                            <p>Ya tienes una cuenta? <a href="/proyecto-1-progra-4/presentacion/login/ViewTresBotones"> Iniciar sesion</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/presentacion/footer.jsp" %>
</body>
</html>
