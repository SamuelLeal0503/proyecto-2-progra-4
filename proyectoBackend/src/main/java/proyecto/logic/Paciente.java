/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class Paciente {
    
    private int id;
    private String nombre;
    private String correo;
    private String sangre;
    private String genero;
    private LocalDate fecha;
    private Medicos medico;

    public Paciente(int id, String nombre, String correo, String sangre, String genero, LocalDate fecha, Medicos medico) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.sangre = sangre;
        this.genero = genero;
        this.fecha = fecha;
        this.medico = medico;
    }
    
    public Paciente(){}

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

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
        final Paciente other = (Paciente) obj;
        return this.id == other.id;
    }
    
    
    
}
