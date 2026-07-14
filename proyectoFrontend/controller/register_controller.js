function registerMedico(){
    var medico = new Object();

    medico.nombre = document.getElementById("nombre").value;
    medico.correo = document.getElementById("correo").value;
    medico.password = document.getElementById("password").value;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/medicos/register",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: medico,
        
        success: function(data, textStatus, xhr){
            
            localStorage.setItem("medico", JSON.stringify(data));
            window.location.replace("principal.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al crear medico");
        }
    });
}

function registerPaciente(){
    var medico = JSON.parse(localStorage.getItem("medico"));
    var paciente = new Object();
    var option = document.getElementById("sangre");

    paciente.nombre = document.getElementById("nombre").value;
    paciente.correo = document.getElementById("correo").value;
    paciente.fecha = document.getElementById("fecha").value;
    paciente.genero = document.querySelector('input[class="form-check-input"]:checked').value;
    paciente.sangre = option.options[option.selectedIndex].value;
    paciente.medico = medico.id;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/register",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: paciente,
        
        success: function(data, textStatus, xhr){
            
            alert("Paciente agregado");
            window.location.reload();
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al crear paciente");
        }
    });
}

function registerAntecendentes(){
    var antecedentes = new Object();
    var paciente = JSON.parse(localStorage.getItem("paciente"));

    antecedentes.paciente = paciente.id;
    antecedentes.enfermedades = document.getElementById("enfermedades").value;
    antecedentes.alergias = document.getElementById("alergias").value;
    antecedentes.cirugias = document.getElementById("cirugias").value;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/antecedentes/register",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: antecedentes,
        
        success: function(data, textStatus, xhr){
            
            alert("Antedente agregado");
            window.location.replace("gestionarPacientes.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al crear antecedente");
        }
    });
}

function registerCita(){
    var cita = new Object();
    var paciente = JSON.parse(localStorage.getItem("paciente"));
    var medico = JSON.parse(localStorage.getItem("medico"));

    var dia = document.getElementById("dia").value;
    var mes = document.getElementById("mes").value;
    var anio = document.getElementById("anio").value;

    var hora = document.getElementById("hora").value;

    var fecha = dia + "/" + mes + "/" + anio + " " + hora + ":00";

    cita.fecha = fecha;
    cita.paciente = paciente.id;
    cita.medico = medico.id;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/citas/register",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: cita,
        
        success: function(data, textStatus, xhr){
            
            alert("Cita agregado");
            window.location.replace("gestionarPacientes.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al crear cita");
        }
    });

}

function registerExamen(){
    var examen = new Object();
    var option = document.getElementById("pacientes");

    examen.paciente = option.options[option.selectedIndex].value;
    examen.nombre = document.getElementById("nombre").value;
    examen.tipo = document.getElementById("tipo").value;
    examen.file = document.getElementById("base64").value;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/examenes/register",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: examen,
        
        success: function(data, textStatus, xhr){
            
            alert("Examen agregado");
            window.location.reload();
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al crear examen");
        }
    });
    
}