/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyecto.logic.Administrador;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class AdministradorDao {
    
    private Database db;

    public AdministradorDao() {
        db = Database.instance();
    }
    
    public Administrador login(Administrador ad) throws Exception{
        String sql = "select * from administrador a where CORREO = ? and  PASSWORD = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, ad.getCorreo());
        stm.setString(2, ad.getPassword());
        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Administrador a = from(rs, "a");
            return a;
        }
        else{
            throw new Exception ("Administrador no existe o contraseña incorrecta");
        }
    }
    
    public Administrador read(int id) throws Exception{
        String sql = "select * from administrador a where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Administrador a = from(rs, "a");
            return a;
        }
        else{
            throw new Exception ("Administrador no existe");
        }
    }
    
    public Administrador readCorreo(String correo) throws Exception{
        String sql = "select * from administrador a where CORREO = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, correo);
        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Administrador a = from(rs, "a");
            return a;
        }
        else{
            throw new Exception ("Administrador no existe");
        }
    }
    
    public Administrador from(ResultSet rs, String alias){
        try {
            Administrador a = new Administrador();
            a.setId(rs.getInt(alias+".ID"));
            a.setNombre(rs.getString(alias+".NOMBRE"));
            a.setCorreo(rs.getString(alias+".CORREO"));
            a.setPassword(rs.getString(alias+".PASSWORD"));
            return a;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
