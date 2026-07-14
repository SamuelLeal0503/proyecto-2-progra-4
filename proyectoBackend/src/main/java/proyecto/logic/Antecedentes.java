/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

/**
 *
 * @author rodri
 */
public class Antecedentes {
    
    private int id;
    private String enfermedades;
    private String alergias;
    private String cirugias;
    private Paciente paciente;

    public Antecedentes(int id, String enfermedades, String alergias, String cirugias, Paciente paciente) {
        this.id = id;
        this.enfermedades = enfermedades;
        this.alergias = alergias;
        this.cirugias = cirugias;
        this.paciente = paciente;
    }
    
    public Antecedentes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCirugias() {
        return cirugias;
    }

    public void setCirugias(String cirugias) {
        this.cirugias = cirugias;
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
        final Antecedentes other = (Antecedentes) obj;
        return this.id == other.id;
    }
    
    
    
}
