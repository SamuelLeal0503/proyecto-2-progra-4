/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyecto.logic.Horario;
import proyecto.logic.Medicos;
import proyecto.logic.Service;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class HorarioDao {
    private Database db;
    
    public HorarioDao(){
        db = Database.instance();
    }
    
    public Horario read(int id) throws Exception{
        String sql = "select * from horario h where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Horario h = from(rs, "h");
            return h;
        }
        else{
            throw new Exception("Horario no existe");
        }
    }
    
    public Horario readMedico(Medicos m) throws Exception{
        String sql = "select * from horario h where ID_MEDICOS = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, m.getId());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Horario h = from(rs, "h");
            return h;
        }
        else{
            throw new Exception("Horario no existe");
        }
    }
    
    public Horario register(Horario h) throws Exception{
        String sql = "insert into horario (ID, ID_MEDICOS, DIA, HORAENTRADA, HORASALIDA, FRECUENCIA) values (NULL, ?, ?, ?, ?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, h.getMedico().getId());
        stm.setInt(2, h.getDia());
        stm.setInt(3, h.getHoraEntrada());
        stm.setInt(4, h.getHoraSalida());
        stm.setInt(5, h.getFrecuencia());
        
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar el horario");
        }
        return readMedico(h.getMedico());
    }
    
    public void update(Horario h) throws Exception{
        String sql = "update horario set DIA = ?, HORAENTRADA = ?, HORASALIDA = ?, FRECUENCIA = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, h.getDia());
        stm.setInt(2, h.getHoraEntrada());
        stm.setInt(3, h.getHoraSalida());
        stm.setInt(4, h.getFrecuencia());
        stm.setInt(5, h.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario no existe");
        }
    }
    
    public List<Horario> allHorario() throws Exception{
        String sql = "select * from horario h";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        List<Horario> list = new ArrayList<>();
        Horario h;
        while (rs.next()) {            
            h = from(rs, "h");
            list.add(h);
        }
        return list;
    }
    
    public List<Horario> horarioMedico(Medicos m) throws Exception{
        String sql = "select * from horario h where ID_MEDICOS = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, m.getId());
        
        ResultSet rs = db.executeQuery(stm);
        List<Horario> list = new ArrayList<>();
        Horario h;
        while (rs.next()) {            
            h = from(rs, "h");
            list.add(h);
        }
        return list;
    }
    
    public Horario from(ResultSet rs, String alias) throws Exception{
        try {
            Horario h = new Horario();
            h.setId(rs.getInt(alias+".ID"));
            h.setDia(rs.getInt(alias+".DIA"));
            h.setHoraEntrada(rs.getInt(alias+".HORAENTRADA"));
            h.setHoraSalida(rs.getInt(alias+".HORASALIDA"));
            h.setFrecuencia(rs.getInt(alias+".FRECUENCIA"));
            Service service = Service.instance();
            h.setMedico(service.medicosRead(rs.getInt(alias+".ID_MEDICOS")));
            return h;
        } catch (Exception e) {
            return null;
        }
    }
}
