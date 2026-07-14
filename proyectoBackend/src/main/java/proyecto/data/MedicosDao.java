/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.Types.BLOB;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import proyecto.logic.Medicos;
import proyecto.logic.Service;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class MedicosDao {
    private Database db;
    
    public MedicosDao(){
        db = Database.instance();
    }
    
    public Medicos login(Medicos me) throws Exception{
        String sql = "select * from medicos m where CORREO = ? and PASSWORD = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, me.getCorreo());
        stm.setString(2, me.getPassword());
        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Medicos m = from(rs, "m");
            return m;
        }
        else{
            throw new Exception("Medico no existe o contraseña incorrecta");
        }
    }
    
    public Medicos read(int id) throws Exception{
        String sql = "select * from medicos m where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Medicos m = from(rs, "m");
            return m;
        }
        else{
            throw new Exception("Medico no existe");
        }
    }
    
    public Medicos readCorreo(String correo) throws Exception{
        String sql = "select * from medicos m where CORREO = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, correo);        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Medicos m = from(rs, "m");
            return m;
        }
        else{            
            throw new Exception ("Medico no existe");
        }
    }
    
    public Medicos register(Medicos m) throws Exception{
        String sql = "insert into medicos (ID, NOMBRE, CORREO, PASSWORD, ESTADO) values (NULL, ?, ?, ?, 'DENEGADO')";
        PreparedStatement stm = db.prepareStatement(sql);
        //stm.setInt(1, m.getEspecialidad().getId());
        //stm.setInt(2, m.getCiudad().getId());
        stm.setString(1, m.getNombre());
        stm.setString(2, m.getCorreo());
        stm.setString(3, m.getPassword());
        //stm.setString(6, m.getPresentacion());
        

        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar al medico");
        }
        return readCorreo(m.getCorreo());
    }
    
    public void update(Medicos m) throws Exception{
        String sql = "update medicos set ID_ESPECIALIDAD = ?, ID_CIUDAD = ?, PRESENTACION = ?, COSTO = ?, FOTO = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, m.getEspecialidad().getId());
        stm.setInt(2, m.getCiudad().getId());
        stm.setString(3, m.getPresentacion());
        stm.setString(4, m.getCosto());
        
        if (!m.getFoto().trim().isEmpty() && m.getFoto() != null) {
            byte[] decodedByte = Base64.getDecoder().decode(m.getFoto());
            Blob b = new SerialBlob(decodedByte);
            stm.setBlob(5, b);
        }else{
            stm.setNull(5, BLOB);
        }
        
        stm.setInt(6, m.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }
    
    public void updateEstado(Medicos m) throws Exception{
        String sql = "update medicos set ESTADO = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, m.getEstado());
        stm.setInt(2, m.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }
    
    public List<Medicos> allMedicos() throws Exception{
        String sql = "select * from medicos m";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        List<Medicos> list = new ArrayList<>();
        Medicos m;
        while (rs.next()) {            
            m = from(rs, "m");
            list.add(m);
        }
        return list;
    }
    
    public Medicos from(ResultSet rs, String alias) throws Exception{
        try {
            Medicos m = new Medicos();
            m.setId(rs.getInt(alias+".ID"));
            m.setNombre(rs.getString(alias+".NOMBRE"));
            m.setCorreo(rs.getString(alias+".CORREO"));
            m.setPassword(rs.getString(alias+".PASSWORD"));
            m.setPresentacion(rs.getString(alias+".PRESENTACION"));
            m.setEstado(rs.getString(alias+".ESTADO"));
            m.setCosto(rs.getString(alias+".COSTO"));
            Blob image = rs.getBlob(alias+".FOTO");
            if (image != null) {
                byte[] imgData = image.getBytes(1,(int)image.length());
                byte[] base64 = Base64.getEncoder().encode(imgData);
                String foto = new String(base64, "UTF-8");
                m.setFoto(foto);
            }
            int idesp = rs.getInt(alias+".ID_ESPECIALIDAD");
            int idciu = rs.getInt(alias+".ID_CIUDAD");
            Service service = Service.instance();
            if (idesp != 0) {
                m.setEspecialidad(service.especialidadRead(idesp));
            }
            if (idciu != 0) {
                m.setCiudad(service.ciudadRead(idciu));
            }
            return m;
        } catch (Exception e) {
            return null;
        }
    }
}
