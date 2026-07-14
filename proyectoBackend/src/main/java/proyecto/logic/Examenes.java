/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

/**
 *
 * @author rodri
 */
public class Examenes {
    
    private int id;
    private String nombre;
    private String tipo;
    private String file;
    private Paciente paciente;

    public Examenes(int id, String nombre, String tipo, String file, Paciente paciente) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.file = file;
        this.paciente = paciente;
    }
    
    public Examenes(){}

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        final Examenes other = (Examenes) obj;
        return this.id == other.id;
    }
    
    
    
}
