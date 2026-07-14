/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class PacienteDao {
    private Database db;
    
    public PacienteDao(){
        db = Database.instance();
    }
    
    public Paciente read(int id) throws Exception{
        String sql = "select * from pacientes p where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Paciente p = from(rs, "p");
            return p;
        }
        else{            
            throw new Exception ("Paciente no existe");
        }
    }
    
    public Paciente readCorreo(String correo) throws Exception{
        String sql = "select * from pacientes p where CORREO = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, correo);        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Paciente p = from(rs, "p");
            return p;
        }
        else{            
            throw new Exception ("Paciente no existe");
        }
    }
    
    public Paciente register(Paciente p) throws Exception{
        String sql = "insert into pacientes (ID, ID_MEDICO, NOMBRE, CORREO, SANGRE, GENERO, FECHA) values (NULL, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, p.getMedico().getId());
        stm.setString(2, p.getNombre());
        stm.setString(3, p.getCorreo());
        stm.setString(4, p.getSangre());
        stm.setString(5, p.getGenero());
        stm.setObject(6, p.getFecha());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar usuario");
        }
        return readCorreo(p.getCorreo());
    }
    
    public List<Paciente> allPacientes() throws Exception{
        String sql = "select * from pacientes p";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        List<Paciente> list = new ArrayList<>();
        Paciente p;
        while (rs.next()) {
            p = from(rs, "p");
            list.add(p);
        }
        return list;
    }
    
    public List<Paciente> pacientesMedico(int id) throws Exception{
        String sql = "select * from pacientes p where ID_MEDICO = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        List<Paciente> list = new ArrayList<>();
        Paciente p;
        while (rs.next()) {
            p = from(rs, "p");
            list.add(p);
        }
        return list;
    }
    
    public Paciente from(ResultSet rs, String alias) throws Exception{
        try {
            Paciente p = new Paciente();
            p.setId(rs.getInt(alias+".ID"));
            Service service = Service.instance();
            p.setMedico(service.medicosRead(rs.getInt(alias+".ID_MEDICO")));
            p.setNombre(rs.getString(alias+".NOMBRE"));
            p.setCorreo(rs.getString(alias+".CORREO"));
            p.setSangre(rs.getString(alias+".SANGRE"));
            p.setGenero(rs.getString(alias+".GENERO"));
            Date d = rs.getDate(alias+".FECHA");
            p.setFecha(d.toLocalDate());
            return p;
        } catch (SQLException e) {
            return null;
        }
    }
}
