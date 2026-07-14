/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyecto.logic.Antecedentes;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
public class AntecedentesDao {
    private Database db;
    
    public AntecedentesDao(){
        db = Database.instance();
    }
    
    public Antecedentes read(int id) throws Exception{
        String sql = "select * from antecedentes a where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Antecedentes a = from(rs, "a");
            return a;
        }
        else{
            throw new Exception("Antecedente no existe");
        }
    }
    
    public Antecedentes readPaciente(Paciente p) throws Exception{
        String sql = "select * from antecedentes a where ID_PACIENTE = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, p.getId());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Antecedentes a = from(rs, "a");
            return a;
        }
        else{
            throw new Exception("Antecedente no existe");
        }
    }
    
    public Antecedentes register(Antecedentes a) throws Exception{
        String sql = "insert into antecedentes (ID, ID_PACIENTE, ENFERMEDADES, ALERGIAS, CIRUGIAS) values (NULL, ?, ?, ? ,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, a.getPaciente().getId());
        stm.setString(2, a.getEnfermedades());
        stm.setString(3, a.getAlergias());
        stm.setString(4, a.getCirugias());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar el antecedente");
        }
        return readPaciente(a.getPaciente());
    }
    
    public void update(Antecedentes a) throws Exception{
        String sql = "update antecedentes set ENFERMEDADES = ?, ALERGIAS = ?, CIRUGIAS = ? where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, a.getEnfermedades());
        stm.setString(2, a.getAlergias());
        stm.setString(3, a.getCirugias());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }

    private Antecedentes from(ResultSet rs, String alias) throws Exception {
        try {
            Antecedentes a = new Antecedentes();
            a.setId(rs.getInt(alias+".ID"));
            Service service = Service.instance();
            a.setPaciente(service.pacienteRead(rs.getInt(alias+".ID_PACIENTE")));
            a.setEnfermedades(rs.getString(alias+".ENFERMEDADES"));
            a.setAlergias(rs.getString(alias+".ALERGIAS"));
            a.setCirugias(rs.getString(alias+".CIRUGIAS"));
            return a;
        } catch (SQLException e) {
            return null;
        }
    }
}
