function updateMedico(){
    var medicoC = JSON.parse(localStorage.getItem("medico"));
    var medico = new Object();
    var optionCiudad = document.getElementById("ciudad");
    var optionEspecialidad = document.getElementById("especialidad");

    medico.id = medicoC.id;
    medico.costo = document.getElementById("costo").value;
    medico.ciudad = optionCiudad.options[optionCiudad.selectedIndex].value;
    medico.especialidad = optionEspecialidad.options[optionEspecialidad.selectedIndex].value;
    medico.presentacion = document.getElementById("presentacion").value;

    medico.foto = document.getElementById("base64").value;


    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/medicos/update",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: medico,
        
        success: function(data, textStatus, xhr){
            
            alert("Medico actualizado");
            localStorage.clear();
            window.location.replace("../index.html");
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al actualizar medico");
        }
    });
}
  
function handleFileSelect(evt) {
    var f = evt.target.files[0]; // FileList object
    var reader = new FileReader();
    // Closure to capture the file information.
    reader.onload = (function(theFile) {
      return function(e) {
        var binaryData = e.target.result;
        //Converting Binary Data to base 64
        var base64String = window.btoa(binaryData);
        //showing file converted to base64
        document.getElementById('base64').value = base64String;
      };
    })(f);
    // Read in the image file as a data URL.
    reader.readAsBinaryString(f);
  }

function updateEstadoMedico(id){

    var medico = new Object();

    medico.id = id;
    medico.estado = "ACEPTADO";

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/medicos/estado",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: medico,
        
        success: function(data, textStatus, xhr){
            
            alert("Medico actualizado");
            window.location.reload();
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al actualizar medico");
        }
    });
}

function updateCitas(){
    var cita = new Object();

    cita.id = document.getElementById("idcita").innerHTML;
    cita.estado = document.getElementById("estado").value;
    cita.anotaciones = document.getElementById("anotaciones").value;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/citas/estadoanotaciones",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: cita,
        
        success: function(data, textStatus, xhr){
            
            alert("Cita actualizada");
            window.location.reload();
            
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error al actualizar medico");
        }
    });
}
