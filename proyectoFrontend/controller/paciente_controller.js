function ficha(id){

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/read/"+id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("paciente", JSON.stringify(data));
            window.location.replace("ficha.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al buscar paciente");
        }
    });
}

function antecedentes(id){

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/read/"+id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("paciente", JSON.stringify(data));
            window.location.replace("antecedentes.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al buscar paciente");
        }
    });
}

function cita(id){

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/read/"+id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("paciente", JSON.stringify(data));
            window.location.replace("cita.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al buscar paciente");
        }
    });
}

function historial(id){

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/read/"+id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("paciente", JSON.stringify(data));
            window.location.replace("historial.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al buscar paciente");
        }
    });
}

