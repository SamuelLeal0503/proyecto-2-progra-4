/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.api;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import proyecto.logic.Especialidad;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/especialidades")
public class EspecialidadesApi {
    
    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Especialidad> all(){
        try {
            return Service.instance().especialidadesAll();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Especialidad read(@PathParam("id") int id){
        try {
            return Service.instance().especialidadRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
}
