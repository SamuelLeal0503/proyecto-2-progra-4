/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import proyecto.logic.Administrador;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/admin")
public class AdminApi {
    
    @POST
    @Path("login")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Administrador login(@FormParam("correo") String correo, @FormParam("password") String password){
        try {
            Administrador a = new Administrador();
            a.setCorreo(correo);
            a.setPassword(password);
            return Service.instance().administradorLogin(a);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Administrador read(@PathParam("id") int id){
        try {
            return Service.instance().administradorRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
}
