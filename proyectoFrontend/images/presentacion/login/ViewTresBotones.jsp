<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <%@ include file="/presentacion/head.jsp" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="description" content="Login">
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
                        <div>
                            <div class="social-button">
                                <a href="/proyecto-1-progra-4/presentacion/login/paciente/show">
                                    <button type="button" class="btn btn-success btn-flat m-b-30 m-t-30 btn-flat btn-addon mt-3">Login Paciente</button>
                                </a>
                                <a href="/proyecto-1-progra-4/presentacion/login/medico/show">
                                   <button type="button" class="btn social twitter btn-flat btn-addon mt-3">Login Medico</button> 
                                </a>
                                <a href="/proyecto-1-progra-4/presentacion/login/administrador/show">
                                   <button type="button" class="btn social facebook btn-flat btn-addon mt-3">Login Administrador</button>    
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/presentacion/footer.jsp" %>
</body>
</html>
