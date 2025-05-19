package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.repository.DoctorRepository;
import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
