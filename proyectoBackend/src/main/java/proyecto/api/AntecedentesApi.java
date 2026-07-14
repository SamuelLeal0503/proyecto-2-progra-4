/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.api;

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
import proyecto.logic.Antecedentes;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/antecedentes")
public class AntecedentesApi {
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Antecedentes read(@PathParam("id") int id){
        try {
            return Service.instance().antecedentesRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Path("readpaciente/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Antecedentes readPaciente(@PathParam("id") int id){
        try {
            Paciente p = new Paciente();
            p.setId(id);
            return Service.instance().antecedentesPaciente(p);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("register")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Antecedentes register(@FormParam("paciente") int paciente, @FormParam("enfermedades") String enfermedades, @FormParam("alergias") String alergias, @FormParam("cirugias") String cirugias){
        try {
            Service service = Service.instance();
            Antecedentes a = new Antecedentes();
            a.setPaciente(service.pacienteRead(paciente));
            a.setEnfermedades(enfermedades);
            a.setAlergias(alergias);
            a.setCirugias(cirugias);
            return service.antecedentesRegister(a);
        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("update")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Antecedentes update(@FormParam("id") int id, @FormParam("enfermedades") String enfermedades, @FormParam("alergias") String alergias, @FormParam("cirugias") String cirugias){
        try {
            Service service = Service.instance();
            Antecedentes a = new Antecedentes();
            a.setId(id);
            a.setEnfermedades(enfermedades);
            a.setAlergias(alergias);
            a.setCirugias(cirugias);
            return service.antecedentesRegister(a);
        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
}
