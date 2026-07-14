function especialidades(){
    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/especialidades/all",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                document.getElementById("ciudad").innerHTML += "<option value="+ ele.id +">"+ ele.nombre +"</option>"; 
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con especialidades");
        }
    });
}

function ciudades(){
    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/ciudades/all",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                document.getElementById("especialidad").innerHTML += "<option value="+ ele.id +">"+ ele.nombre +"</option>"; 
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con ciudades");
        }
    });
}

function medicos(){
    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/medicos/all",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                if (ele.estado == "DENEGADO") {
                    document.getElementById("tabla").innerHTML += "<tr> <td> <span class='id'>"+ ele.id +"</td><td class='avatar'> <div id='centro' class='round-img'> <img class='rounded-circle' src='data:image/jpg;base64,' width='50' height='50'> </div></td><td> <span class='nombre'></span>"+ ele.nombre +"</td><td> <span class='correo'></span>"+ ele.correo +"</td><td> <span class='especialidad'></span> NO ESPECIALIDAD </td><td> <span class='ciudad'></span>NO CIUDAD</td><td><span class='costo'></span>NO COSTO</td><td> <button type='button' onclick='updateEstadoMedico("+ ele.id +")' class='btn btn-primary btn-lg btn-block'>Aprobar</button> </td></tr>"; 
                }
                else if (ele.especialidad && ele.ciudad) {
                    document.getElementById("tabla").innerHTML += "<tr> <td> <span class='id'>"+ ele.id +"</td><td class='avatar'> <div id='centro' class='round-img'> <img class='rounded-circle' src='data:image/jpg;base64,"+ ele.foto +"' width='50' height='50'> </div></td><td> <span class='nombre'></span>"+ ele.nombre +"</td><td> <span class='correo'></span>"+ ele.correo +"</td><td> <span class='especialidad'></span>"+ ele.especialidad.nombre +"</td><td> <span class='ciudad'></span>"+ ele.ciudad.nombre +"</td><td><span class='costo'></span>$"+ ele.costo +"</td><td> ACEPTADO </td></tr>"; 
                }
                else {
                    document.getElementById("tabla").innerHTML += "<tr> <td> <span class='id'>"+ ele.id +"</td><td class='avatar'> <div id='centro' class='round-img'> <img class='rounded-circle' src='data:image/jpg;base64,' width='50' height='50'> </div></td><td> <span class='nombre'></span>"+ ele.nombre +"</td><td> <span class='correo'></span>"+ ele.correo +"</td><td> <span class='especialidad'></span> NO ESPECIALIDAD </td><td> <span class='ciudad'></span>NO CIUDAD</td><td><span class='costo'></span>NO COSTO</td><td> ACEPTADO </td></tr>"; 
                }
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con medicos");
        }
    });
}

function pacientes(){

    var medico = JSON.parse(localStorage.getItem("medico"));

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/medico/"+ medico.id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                document.getElementById("tabla").innerHTML += "<tr> <td> <span class='id'> "+ ele.id +" </td><td> <span class='nombre'> "+ ele.nombre +" </span> </td><td> <span class='genero'> "+ ele.genero +" </td><td> <a href='javascript:ficha("+ ele.id +")'> <button type='button' class='btn btn-info'><i class='fa fa-user-circle'></i>&nbsp;</button> </a> </td><td> <a href='javascript:antecedentes("+ ele.id +")'> <button type='button' class='btn btn-info'><i class='fa fa-file-text-o'></i>&nbsp;</button> </a> </td><td> <a href='javascript:cita("+ ele.id +")'> <button type='button' class='btn btn-info'><i class='fa fa-plus'></i>&nbsp;</button> </a> </td><td> <a href='javascript:historial("+ ele.id +")'> <button type='button' class='btn btn-info'><i class='fa fa-address-book'></i>&nbsp; Ver</button> </a> </td></tr>";
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con pacientes");
        }
    });
}

function pacientesCombo(){

    var medico = JSON.parse(localStorage.getItem("medico"));

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/pacientes/medico/"+ medico.id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                document.getElementById("pacientes").innerHTML += "<option value='"+ ele.id +"'>"+ ele.nombre +"</option>";
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con pacientes");
        }
    });
}

function citasPaciente(){
    var paciente = JSON.parse(localStorage.getItem("paciente"));

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/citas/paciente/"+ paciente.id,
        type: "GET",
        contentType: "application/x-www-form-urlencoded",
        
        success: function(data, textStatus, xhr){
            data.forEach(ele => {
                document.getElementById("tabla").innerHTML += "<tr> <td> <span class='id'>"+ ele.fecha +"</td><td> <span class='tipo'></span>"+ ele.anotaciones +"</td><td> "+ ele.estado +" </td></tr>";
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con citas");
        }
    });
}

function examenesMedico(){
    
    var medico = JSON.parse(localStorage.getItem("medico"));
    var examen = new Object();

    examen.medico = medico.id;

    $.ajax({
        
        url: "http://localhost:8080/proyectoBackend/api/examenes/all",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        data: examen,
        
        success: function(data, textStatus, xhr){

            var linkSource = "";
            var filename = "";

            data.forEach(ele => {
                linkSource = "data:application/pdf;base64," + ele.file;
                filename = ele.paciente.nombre + "-Examen-" + ele.tipo + ".pdf"; 
                document.getElementById("tabla").innerHTML += "<tr> <td> <span class='id'>"+ ele.id +"</td><td> <span class='Paciente'>"+ ele.paciente.nombre +"</td><td> <span class='nombre'></span>"+ ele.nombre +"</td><td> <span class='Etiqueta'>"+ ele.tipo +"</span></td><td> <a href="+ linkSource +" download="+ filename +"><button class='btn btn-info'>Descargar</button></a> </td></tr>";
            });  
        },
        
        error: function(xhr, textStatus, errorThrown){
            alert("Error con citas");
        }
    });

}
