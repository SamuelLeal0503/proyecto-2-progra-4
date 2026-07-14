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
import proyecto.logic.Ciudades;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class CiudadesDao {
    private Database db;
    
    public CiudadesDao(){
        db = Database.instance();
    }
    
    public Ciudades read(int id) throws Exception{
        String sql = "select * from ciudades c where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Ciudades c = from(rs, "c");
            return c;
        }
        else{
            throw new Exception("Ciudad no existe");
        }
    }
    
    public Ciudades readNombre(String nombre) throws Exception{
        String sql = "select * from ciudades c where NOMBRE = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, nombre);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Ciudades c = from(rs, "c");
            return c;
        }
        else{
            throw new Exception("Ciudad no existe");
        }
    }
    
    public Ciudades register(Ciudades c) throws Exception{
        String sql = "insert into ciudades (ID, NOMBRE) values (NULL, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getNombre());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar la ciudad");
        }
        return readNombre(c.getNombre());
    }
    
    public List<Ciudades> allCiudades() throws Exception{
        String sql = "select * from ciudades c";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        List<Ciudades> list = new ArrayList<>();
        Ciudades c;
        while (rs.next()) {            
            c = from(rs, "c");
            list.add(c);
        }
        return list;
    }
    
    public Ciudades from(ResultSet rs, String alias){
        try {
            Ciudades c = new Ciudades();
            c.setId(rs.getInt(alias+".ID"));
            c.setNombre(rs.getString(alias+".NOMBRE"));
            return c;
        } catch (SQLException e) {
            return null;
        }
    }
}
