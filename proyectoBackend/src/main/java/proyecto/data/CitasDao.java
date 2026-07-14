/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import proyecto.logic.Citas;
import proyecto.logic.Medicos;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class CitasDao {
    private Database db;
    
    public CitasDao(){
        db = Database.instance();
    }
    
    public Citas read(int id) throws Exception{
        String sql = "select * from citas c where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Citas c = from(rs, "c");
            return c;
        }
        else{
            throw new Exception("Cita no existe");
        }
    }
    
    public Citas readFecha(LocalDateTime fecha, Medicos m) throws Exception{
        String sql = "select * from citas c where FECHA = ? and ID_MEDICOS = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setObject(1, fecha);
        stm.setInt(2, m.getId());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Citas c = from(rs, "c");
            return c;
        }
        else{
            throw new Exception("Cita no existe");
        }
    }
    
    public Citas register(Citas c) throws Exception{
        String sql = "insert into citas (ID, ID_PACIENTES, ID_MEDICOS, FECHA, ESTADO) values (NULL, ?, ?, ?, 'PENDIENTE')";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getPaciente().getId());
        stm.setInt(2, c.getMedico().getId());
        stm.setObject(3, c.getFecha());
        
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar la cita");
        }
        return readFecha(c.getFecha(), c.getMedico());
    }
    
    public void updatePaciente(Citas c) throws Exception{
        String sql = "update citas set ID_PACIENTES = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getPaciente().getId());
        stm.setInt(2, c.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }
    
    public void updateEstado(Citas c) throws Exception{
        String sql = "update citas set ESTADO = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getEstado());
        stm.setInt(2, c.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }
    
    public void updateAnotaciones(Citas c) throws Exception{
        String sql = "update citas set ANOTACIONES = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getAnotaciones());
        stm.setInt(2, c.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }
    
    public void updateAnotacionesEstado(Citas c) throws Exception{
        String sql = "update citas set ANOTACIONES = ?, ESTADO = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getAnotaciones());
        stm.setString(2, c.getEstado());
        stm.setInt(3, c.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }
    
    public List<Citas> citasMedico(Medicos m) throws Exception{
        String sql = "select * from citas c where ID_MEDICOS = ? order by FECHA ASC";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, m.getId());
        ResultSet rs = db.executeQuery(stm);
        List<Citas> list = new ArrayList<>();
        Citas c;
        while (rs.next()) {            
            c = from(rs, "c");
            list.add(c);
        }
        return list;
    }
    
    public List<Citas> citasPaciente(Paciente p) throws Exception{
        String sql = "select * from citas c where ID_PACIENTES = ? order by FECHA ASC";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, p.getId());
        ResultSet rs = db.executeQuery(stm);
        List<Citas> list = new ArrayList<>();
        Citas c;
        while (rs.next()) {            
            c = from(rs, "c");
            list.add(c);
        }
        return list;
    }
    
    public List<String> pacientesMedico(Medicos m) throws Exception{
        String sql = "SELECT DISTINCT p.NOMBRE from pacientes p, citas c where c.ID_MEDICOS = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, m.getId());
        ResultSet rs = db.executeQuery(stm);
        List<String> list = new ArrayList<>();
        Citas c;
        while (rs.next()) {            
            list.add(rs.getString("p.NOMBRE"));
        }
        return list;
    }
    
    public Citas from(ResultSet rs, String alias) throws Exception{
        try {
            Citas c = new Citas();
            c.setId(rs.getInt(alias+".ID"));
            c.setFecha((LocalDateTime) rs.getObject(alias+".FECHA"));
            c.setEstado(rs.getString(alias+".ESTADO"));
            c.setAnotaciones(rs.getString(alias+".ANOTACIONES"));
            Service service = Service.instance();
            c.setPaciente(service.pacienteRead(rs.getInt(alias+".ID_PACIENTES")));
            c.setMedico(service.medicosRead(rs.getInt(alias+".ID_MEDICOS")));
            return c;
        } catch (SQLException e) {
            return null;
        }
    }
}
