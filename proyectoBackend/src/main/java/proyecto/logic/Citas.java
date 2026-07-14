/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

import java.time.LocalDateTime;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class Citas {
    
    private int id;
    private LocalDateTime fecha;
    private String estado;
    private String anotaciones;
    private Paciente paciente;
    private Medicos medico;

    public Citas(int id, LocalDateTime fecha, String estado, String anotaciones, Paciente paciente, Medicos medico) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.anotaciones = anotaciones;
        this.paciente = paciente;
        this.medico = medico;
    }
    
    public Citas(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
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
        final Citas other = (Citas) obj;
        return this.id == other.id;
    }
    
    
}
