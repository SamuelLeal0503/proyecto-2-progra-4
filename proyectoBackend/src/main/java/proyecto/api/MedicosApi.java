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
import proyecto.logic.Medicos;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
@Path("/medicos")
public class MedicosApi {
    
    @POST
    @Path("login")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Medicos login(@FormParam("correo") String correo, @FormParam("password") String password){
        try {
            Medicos m = new Medicos();
            m.setCorreo(correo);
            m.setPassword(password);
            return Service.instance().medicosLogin(m);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @GET
    @Path("read/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Medicos read(@PathParam("id") int id){
        try {
            return Service.instance().medicosRead(id);
        } catch (Exception e) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("register")
    @Consumes("application/x-www-form-urlencoded") 
    @Produces(MediaType.APPLICATION_JSON)
    public Medicos register(@FormParam("nombre") String nombre, @FormParam("correo") String correo, @FormParam("password") String password){
        try {
            Medicos m = new Medicos();
            m.setNombre(nombre);
            m.setCorreo(correo);
            m.setPassword(password);
            return Service.instance().medicosRegister(m);
        } catch (Exception e) {
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("update")
    @Consumes("application/x-www-form-urlencoded") 
    public void update(@FormParam("especialidad") int especialidad, @FormParam("ciudad") int ciudad, @FormParam("presentacion") String presentacion, @FormParam("costo") String costo, @FormParam("foto") String foto, @FormParam("id") int id){
        try {
            Service service = Service.instance();
            Medicos m = new Medicos();
            m.setEspecialidad(service.especialidadRead(especialidad));
            m.setCiudad(service.ciudadRead(ciudad));
            m.setPresentacion(presentacion);
            m.setCosto(costo);
            m.setFoto(foto);
            m.setId(id);
            service.medicosUpdate(m);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @POST
    @Path("estado")
    @Consumes("application/x-www-form-urlencoded") 
    public void estado(@FormParam("estado") String estado, @FormParam("id") int id){
        try {
            Medicos m = new Medicos();
            m.setId(id);
            m.setEstado(estado);
            Service.instance().medicoUpdateEstado(m);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicos> all(){
        try {
            return Service.instance().medicosAll();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    
    
}
