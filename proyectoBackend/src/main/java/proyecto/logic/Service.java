/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logic;

import java.time.LocalDateTime;
import java.util.List;
import java.io.InputStream;
import proyecto.data.AdministradorDao;
import proyecto.data.AntecedentesDao;
import proyecto.data.CitasDao;
import proyecto.data.CiudadesDao;
import proyecto.data.EspecialidadDao;
import proyecto.data.ExamenesDao;
import proyecto.data.HorarioDao;
import proyecto.data.MedicosDao;
import proyecto.data.PacienteDao;

/**
 *
 * @author Rodrigo, Samuel y Jose
 */
public class Service {
    
    // Singleton implementation
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
        
    AdministradorDao aDao;
    PacienteDao pDao;
    CiudadesDao cDao;
    EspecialidadDao eDao;
    MedicosDao mDao;
    CitasDao ciDao;
    HorarioDao hDao;
    AntecedentesDao anDao;
    ExamenesDao exDao;
    
    public Administrador administradorLogin(Administrador a) throws Exception{
        return aDao.login(a);
    }
    
    public Administrador administradorRead(int id) throws Exception{
        return aDao.read(id);
    }
    
    public Administrador administradorReadCorreo(String correo) throws Exception{
        return aDao.readCorreo(correo);
    }
    
    public Paciente pacienteRead(int id) throws Exception{
        return pDao.read(id);
    }
    
    public Paciente pacienteReadCorreo(String correo) throws Exception{
        return pDao.readCorreo(correo);
    }
    
    public Paciente pacienteRegister(Paciente p) throws Exception{
        return pDao.register(p);
    }
    
    public List<Paciente> pacienteAll() throws Exception{
        return pDao.allPacientes();
    }
    
    public List<Paciente> pacienteMedico(int id) throws Exception{
        return pDao.pacientesMedico(id);
    }
    
    public Ciudades ciudadRead(int id) throws Exception{
        return cDao.read(id);
    }
    
    public Ciudades ciudadReadNombre(String nombre) throws Exception{
        return cDao.readNombre(nombre);
    }
    
    public Ciudades ciudadRegister(Ciudades c) throws Exception{
        return cDao.register(c);
    }
    
    public List<Ciudades> ciudadesAll() throws Exception{
        return cDao.allCiudades();
    }
    
    public Especialidad especialidadRead(int id) throws Exception{
        return eDao.read(id);
    }
    
    public Especialidad especialidadReadNombre(String nombre) throws Exception{
        return eDao.readNombre(nombre);
    }
    
    public Especialidad especialidadRegister(Especialidad e) throws Exception{
        return eDao.register(e);
    }
    
    public List<Especialidad> especialidadesAll() throws Exception{
        return eDao.allEspecialidad();
    }
    
    public Medicos medicosLogin(Medicos m) throws Exception{
        return mDao.login(m);
    }
    
    public Medicos medicosRead(int id) throws Exception{
        return mDao.read(id);
    }
    
    public Medicos medicosReadCorreo(String correo) throws Exception{
        return mDao.readCorreo(correo);
    }
    
    public Medicos medicosRegister(Medicos m) throws Exception{
        return mDao.register(m);
    }
    
    public void medicosUpdate(Medicos m) throws Exception{
        mDao.update(m);
    }
    
    public void medicoUpdateEstado(Medicos m) throws Exception{
        mDao.updateEstado(m);
    }
    
    public List<Medicos> medicosAll() throws Exception{
        return mDao.allMedicos();
    }
    
    public Citas citasRead(int id) throws Exception{
        return ciDao.read(id);
    }
    
    public Citas citasReadFecha(LocalDateTime fecha, Medicos m) throws Exception{
        return ciDao.readFecha(fecha, m);
    }
    
    public Citas citasRegister(Citas c) throws Exception{
        return ciDao.register(c);
    }
    
    public void citasUpdatePaciente(Citas c) throws Exception{
        ciDao.updatePaciente(c);
    }
    
    public void citasUpdateEstado(Citas c) throws Exception{
        ciDao.updateEstado(c);
    }
    
    public void citasUpdateAnotaciones(Citas c) throws Exception{
        ciDao.updateAnotaciones(c);
    }
    
    public void citasUpdateAnotacionesEstado(Citas c) throws Exception{
        ciDao.updateAnotacionesEstado(c);
    }
    
    public List<Citas> citasMedico(Medicos m) throws Exception{
        return ciDao.citasMedico(m);
    }
    
    public List<Citas> citasPaciente(Paciente p) throws Exception{
        return ciDao.citasPaciente(p);
    }
    
    public List<String> pacientesMedico(Medicos m) throws Exception{
        return ciDao.pacientesMedico(m);
    }
    
    public Horario horarioRead(int id) throws Exception{
        return hDao.read(id);
    }
    
    public Horario horarioReadMedico(Medicos m) throws Exception{
        return hDao.readMedico(m);
    }
    
    public Horario horarioRegister(Horario h) throws Exception{
        return hDao.register(h);
    }
    
    public void horarioUpdate(Horario h) throws Exception{
        hDao.update(h);
    }
    
    public List<Horario> horarioAll() throws Exception{
        return hDao.allHorario();
    }
    
    public List<Horario> horarioMedicos(Medicos m) throws Exception{
        return hDao.horarioMedico(m);
    }
    
    public Antecedentes antecedentesRead(int id) throws Exception{
        return anDao.read(id);
    }
    
    public Antecedentes antecedentesPaciente(Paciente p) throws Exception{
        return anDao.readPaciente(p);
    }
    
    public Antecedentes antecedentesRegister(Antecedentes a) throws Exception{
        return anDao.register(a);
    }
    
    public void antecedentesUpdate(Antecedentes a) throws Exception{
        anDao.update(a);
    }
    
    public Examenes examenesRead(int id) throws Exception{
        return exDao.read(id);
    }
    
    public Examenes examenesRegister(Examenes e) throws Exception{
        return exDao.register(e);
    }
    
    public List<Examenes> examenesPaciente(Paciente p) throws Exception{
        return exDao.examenesPaciente(p);
    }
    
    public Service() {
        try{
              aDao = new AdministradorDao();
              pDao = new PacienteDao();
              cDao = new CiudadesDao();
              eDao = new EspecialidadDao();
              mDao = new MedicosDao();
              ciDao = new CitasDao();
              hDao = new HorarioDao();
              anDao = new AntecedentesDao();
              exDao = new ExamenesDao();
        }
        catch(Exception e){}        
    }
    
}
