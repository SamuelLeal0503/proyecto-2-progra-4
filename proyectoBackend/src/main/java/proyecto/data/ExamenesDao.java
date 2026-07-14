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
import proyecto.logic.Examenes;
import proyecto.logic.Paciente;
import proyecto.logic.Service;

/**
 *
 * @author rodri
 */
public class ExamenesDao {
    private Database db;

    public ExamenesDao() {
        db = Database.instance();
    }
    
    public Examenes read(int id) throws Exception{
        String sql = "select * from examenes e where ID = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Examenes e = from(rs, "e");
            return e;
        }
        else{
            throw new Exception("Horario no existe");
        }
    }
    
    public List<Examenes> examenesPaciente(Paciente p) throws Exception{
        String sql = "SELECT e.ID, e.ID_PACIENTE, e.NOMBRE, e.TIPO, e.FILE FROM `examenes` e, `pacientes` p WHERE e.ID_PACIENTE = p.ID and p.ID_MEDICO = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, p.getMedico().getId());
        ResultSet rs = db.executeQuery(stm);
        List<Examenes> list = new ArrayList<>();
        Examenes e;
        while (rs.next()) {
            e = from(rs, "e");
            list.add(e);
        }
        return list;
    }
    
    public Examenes readNombre(String nombre, Paciente p) throws Exception{
        String sql = "select * from examenes e where NOMBRE = ? and ID_PACIENTE = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, nombre);
        stm.setInt(2, p.getId());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Examenes e = from(rs, "e");
            return e;
        }
        else{
            throw new Exception("Antecedente no existe");
        }
    }
    
    public Examenes register(Examenes e) throws Exception{
        String sql = "insert into examenes (ID, ID_PACIENTE, NOMBRE, TIPO, FILE) values (NULL, ?, ?, ?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, e.getPaciente().getId());
        stm.setString(2, e.getNombre());
        stm.setString(3, e.getTipo());
        
        if (!e.getFile().trim().isEmpty() && e.getFile() != null) {
            byte[] decodedByte = Base64.getDecoder().decode(e.getFile());
            Blob b = new SerialBlob(decodedByte);
            stm.setBlob(4, b);
        }
        else{
            stm.setNull(4, BLOB);
        }
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No se pudo registrar el examen");
        }
        return readNombre(e.getNombre(), e.getPaciente());
    }

    private Examenes from(ResultSet rs, String alias) {
        try {
            Examenes e = new Examenes();
            e.setId(rs.getInt(alias+".ID"));
            e.setNombre(rs.getString(alias+".NOMBRE"));
            e.setTipo(rs.getString(alias+".TIPO"));
            Blob pdf = rs.getBlob(alias+".FILE");
            if (pdf != null) {
                byte[] pdfData = pdf.getBytes(1,(int)pdf.length());
                byte[] base64 = Base64.getEncoder().encode(pdfData);
                String pdf64 = new String(base64, "UTF-8");
                e.setFile(pdf64);
            }
            Service service = Service.instance();
            e.setPaciente(service.pacienteRead(rs.getInt(alias+".ID_PACIENTE")));
            return e;
        } catch (Exception e) {
            return null;
        }
    }
    
}
