function loginAdmin(){

    var admin = new Object();

    admin.correo = document.getElementById("correo").value;
    admin.password = document.getElementById("password").value;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/admin/login",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: admin,
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("admin", JSON.stringify(data));
            window.location.replace("listadoMedicos.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Admin no existe o contraseña incorrecta");
        }
    });

}

function loginMedico(){

    var medicos = new Object();

    medicos.correo = document.getElementById("correo").value;
    medicos.password = document.getElementById("password").value;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/medicos/login",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: medicos,
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("medico", JSON.stringify(data));
            window.location.replace("principal.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Medico no existe o contraseña incorrecta");
        }
    });

}

function logout(){
    localStorage.clear();
    window.location.replace("../index.html");
}