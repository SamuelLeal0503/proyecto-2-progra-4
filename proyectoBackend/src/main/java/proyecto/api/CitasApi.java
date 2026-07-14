/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import proyecto.logic.Citas;
import proyecto.logic.Medicos;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/citas")
public class CitasApi {
    
    @POST
    @Path("register")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Citas register(@FormParam("paciente") int paciente, @FormParam("medico") int medico, @FormParam("fecha") String fecha){
        try {
            Service service = Service.instance();
            Citas c = new Citas();
            c.setPaciente(service.pacienteRead(paciente));
            c.setMedico(service.medicosRead(medico));
            String date = fecha;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
            c.setFecha(dateTime);
            return service.citasRegister(c);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @POST
    @Path("estado")
    @Consumes("application/x-www-form-urlencoded") 
    public void estado(@FormParam("id") int id, @FormParam("estado") String estado){
        try {
            Citas c = new Citas();
            c.setId(id);
            c.setEstado(estado);
            Service.instance().citasUpdateEstado(c);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @POST
    @Path("anotaciones")
    @Consumes("application/x-www-form-urlencoded") 
    public void anotaciones(@FormParam("id") int id, @FormParam("anotaciones") String anotaciones){
        try {
            Citas c = new Citas();
            c.setId(id);
            c.setAnotaciones(anotaciones);
            Service.instance().citasUpdateAnotaciones(c);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @POST
    @Path("estadoanotaciones")
    @Consumes("application/x-www-form-urlencoded")
    public void estadoAnotaciones(@FormParam("id") int id, @FormParam("anotaciones") String anotaciones, @FormParam("estado") String estado){
        try {
            Citas c = new Citas();
            c.setId(id);
            c.setAnotaciones(anotaciones);
            c.setEstado(estado);
            Service.instance().citasUpdateAnotacionesEstado(c);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @POST
    @Path("medico")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Citas> citasMedico(@FormParam("id") int id){
        try {
            Medicos m = new Medicos();
            m.setId(id);
            return Service.instance().citasMedico(m);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("paciente/{id}")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Citas> citasPaciente(@PathParam("id") int id){
        try {
            Paciente p = new Paciente();
            p.setId(id);
            return Service.instance().citasPaciente(p);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
}
