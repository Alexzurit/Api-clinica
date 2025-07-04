package azj.proyect.clinica.service;

import azj.proyect.clinica.dto.DoctorResponseDTO;
import azj.proyect.clinica.dto.RegistroDoctorDTO;
import azj.proyect.clinica.entity.*;
import azj.proyect.clinica.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    /*NOSEEE*/
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<Doctor> obtenerTodos(){ return doctorRepository.findAll(); }

    public Doctor guardarDoctor(Doctor doctor) {
        Especialidad especialidad = especialidadRepository.findById(doctor.getEspecialidad().getIdespecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        doctor.setEspecialidad(especialidad);
        return doctorRepository.save(doctor);
    }

    //Listar por id
    public Optional <Doctor> obtenerPorId(int idDoctor){
        return doctorRepository.findById(idDoctor);
    }

    //Actualizar doctor
    public Doctor actualizarDoctor(int idDoctor, Doctor nuevoDoctor) {
        Doctor doctorExistente = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        // Actualizar todos los campos relevantes
        doctorExistente.setNombres(nuevoDoctor.getNombres());
        doctorExistente.setApellidos(nuevoDoctor.getApellidos());
        doctorExistente.setDni(nuevoDoctor.getDni());
        doctorExistente.setCmp(nuevoDoctor.getCmp());
        //doctorExistente.setCorreo(nuevoDoctor.getCorreo()); correo ya no habrá en doctor, se  usará solo el de usuarios
        doctorExistente.setCelular(nuevoDoctor.getCelular());
        doctorExistente.setEstado(nuevoDoctor.getEstado());

        // Actualizar especialidad si es que se envió
        if (nuevoDoctor.getEspecialidad() != null) {
            Especialidad especialidad = especialidadRepository.findById(nuevoDoctor.getEspecialidad().getIdespecialidad())
                    .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
            doctorExistente.setEspecialidad(especialidad);
        }

        return doctorRepository.save(doctorExistente);
    }

    //Eliminar Doctor
    public void eliminarDoctor(int idDoctor){
        if (!doctorRepository.existsById(idDoctor)){
            throw new RuntimeException("Doctor no encontrado");
        }
        doctorRepository.deleteById(idDoctor);
    }

    @Transactional
    public Doctor registrarDoctorConUsuario(RegistroDoctorDTO dto) {
        Rol rol;
        if (dto.getRolId() == null) {
            rol = rolRepository.findByNombreRol("sinrolesxd")
                    .orElseThrow(() -> new RuntimeException("Rol por defecto no encontrado"));
        } else {
            rol = rolRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        }


        // Validar especialidad
        Especialidad especialidad = especialidadRepository.findById(dto.getIdEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        // Crear usuario
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPass(passwordEncoder.encode(dto.getPass())); // BCrypt aplicado aquí 👈
        usuario.setEstado(dto.getEstado());
        usuario.setRol(rol); // ¡Ahora sí con ManyToOne!
        usuario = usuarioRepository.save(usuario);

        // Crear doctor
        Doctor doctor = new Doctor();
        doctor.setNombres(dto.getNombres());
        doctor.setApellidos(dto.getApellidos());
        doctor.setDni(dto.getDni());
        doctor.setCmp(dto.getCmp());
        doctor.setCelular(dto.getCelular());
        doctor.setEstado(dto.getEstadoDoctor());
        doctor.setEspecialidad(especialidad);
        doctor.setDisponibilidades(new ArrayList<>()); // Evita posibles nulls
        doctor.setUsuario(usuario);

        // Guardar doctor
        return doctorRepository.save(doctor);
    }

    /*los pacientes que tiene un doctor"*/
    public List<Paciente> obtenerPacientesDelDoctor(int idDoctor) {
        return citaRepository.findPacientesByDoctorId(idDoctor);
    }

}
