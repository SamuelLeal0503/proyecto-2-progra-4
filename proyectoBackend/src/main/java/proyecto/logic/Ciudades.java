/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

import java.util.Objects;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class Ciudades {
    
    private int id;
    private String nombre;

    public Ciudades(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Ciudades(){}

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
        final Ciudades other = (Ciudades) obj;
        return this.id == other.id;
    }
}
