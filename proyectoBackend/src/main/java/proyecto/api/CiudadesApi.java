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
import proyecto.logic.Ciudades;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/ciudades")
public class CiudadesApi {
    
    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudades> all(){
        try {
            return Service.instance().ciudadesAll();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Ciudades read(@PathParam("id") int id){
        try {
            return Service.instance().ciudadRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
}
