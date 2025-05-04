package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> obtenerTodos(){ return doctorRepository.findAll(); }

    public Doctor guardarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
