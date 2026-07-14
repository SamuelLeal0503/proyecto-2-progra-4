/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/pacientes")
public class pacientesApi {
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Paciente read(@PathParam("id") int id){
        try {
            return Service.instance().pacienteRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("register")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente register(@FormParam("medico") int medico, @FormParam("nombre") String nombre, @FormParam("correo") String correo, @FormParam("sangre") String sangre, @FormParam("genero") String genero, @FormParam("fecha") String fecha){
        try {
            Service service = Service.instance();
            Paciente p = new Paciente();
            p.setMedico(service.medicosRead(medico));
            p.setNombre(nombre);
            p.setCorreo(correo);
            p.setGenero(genero);
            p.setSangre(sangre);
            String dateF = fecha;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateF, formatter);
            p.setFecha(date);
            return service.pacienteRegister(p);
        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> all(){
        try {
            return Service.instance().pacienteAll();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("medico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> pacientes(@PathParam("id") int id) { 
        try {
            return Service.instance().pacienteMedico(id);
        } catch (Exception ex) {
            throw new NotFoundException();        
        }
    }
    
}
