package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.repository.DoctorRepository;
import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;

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
}
