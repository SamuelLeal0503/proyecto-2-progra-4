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
import proyecto.logic.Horario;
import proyecto.logic.Medicos;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
public class HorarioApi {
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Horario read(@PathParam("id") int id){
        try {
            return Service.instance().horarioRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("register")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Horario register(@FormParam("medico") int medico, @FormParam("dia") int dia, @FormParam("horaentrada") int horaentrada, @FormParam("horasalida") int horasalida, @FormParam("frecuencia") int frecuencia){
        try {
            Service service = Service.instance();
            Horario h = new Horario();
            h.setMedico(service.medicosRead(medico));
            h.setDia(dia);
            h.setHoraEntrada(horaentrada);
            h.setHoraSalida(horasalida);
            h.setFrecuencia(frecuencia);
            return service.horarioRegister(h);
        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("all")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Horario> all(@FormParam("medico") int medico){
        try {
            Medicos m = new Medicos();
            m.setId(medico);
            return Service.instance().horarioMedicos(m);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
}
