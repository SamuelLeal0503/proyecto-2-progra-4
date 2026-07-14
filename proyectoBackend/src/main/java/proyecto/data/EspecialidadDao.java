/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.logic.Especialidad;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class EspecialidadDao {
    private Database db;
    
    public EspecialidadDao(){
        db = Database.instance();
    }
    
    public Especialidad read(int id) throws Exception{
        String sql = "select * from especialidad e where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Especialidad e = from(rs, "e");
            return e;
        }
        else{
            throw new Exception("Especialidad no existe");
        }
    }
    
    public Especialidad readNombre(String nombre) throws Exception{
        String sql = "select * from especialidad e where NOMBRE = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, nombre);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Especialidad e = from(rs, "e");
            return e;
        }
        else{
            throw new Exception("Especialidad no existe");
        }
    }
    
    public Especialidad register(Especialidad e) throws Exception{
        String sql = "insert into especialidad (ID, NOMBRE) values (NULL, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar la ciudad");
        }
        return readNombre(e.getNombre());
    }
    
    public List<Especialidad> allEspecialidad() throws Exception{
        String sql = "select * from especialidad e";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        List<Especialidad> list = new ArrayList<>();
        Especialidad e;
        while (rs.next()) {            
            e = from(rs, "e");
            list.add(e);
        }
        return list;
    }
    
    public Especialidad from(ResultSet rs, String alias){
        try {
            Especialidad e = new Especialidad();
            e.setId(rs.getInt(alias+".ID"));
            e.setNombre(rs.getString(alias+".NOMBRE"));
            return e;
        } catch (SQLException e) {
            return null;
        }
    }
}
