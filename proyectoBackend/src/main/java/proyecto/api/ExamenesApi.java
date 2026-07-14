/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.api;

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
import proyecto.logic.Examenes;
import proyecto.logic.Medicos;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/examenes")
public class ExamenesApi {
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Examenes read(@PathParam("id") int id){
        try {
            return Service.instance().examenesRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("register")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Examenes register(@FormParam("nombre") String nombre, @FormParam("tipo") String tipo, @FormParam("file") String file, @FormParam("paciente") int paciente){
        try {
            Service service = Service.instance();
            Examenes e = new Examenes();
            e.setNombre(nombre);
            e.setTipo(tipo);
            e.setFile(file);
            e.setPaciente(service.pacienteRead(paciente));
            return service.examenesRegister(e);
        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("all")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public List<Examenes> all(@FormParam("medico") int medico){
        try {
            Service service = Service.instance();
            Paciente p = new Paciente();
            Medicos m = new Medicos();
            m.setId(medico);
            p.setMedico(m);
            return service.examenesPaciente(p);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
}
