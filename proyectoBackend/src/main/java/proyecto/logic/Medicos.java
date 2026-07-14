/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class Medicos {
    
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private String presentacion;
    private String estado;
    private String costo;
    private String foto;
    private Especialidad especialidad;
    private Ciudades ciudad;

    public Medicos(int id, String nombre, String correo, String password, String presentacion, String estado, String costo, String foto, Especialidad especialidad, Ciudades ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.presentacion = presentacion;
        this.estado = estado;
        this.costo = costo;
        this.foto = foto;
        this.especialidad = especialidad;
        this.ciudad = ciudad;
    }
    
    public Medicos(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicos other = (Medicos) obj;
        return this.id == other.id;
    }
    
    
}
