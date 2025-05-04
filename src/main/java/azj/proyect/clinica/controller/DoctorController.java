package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> listarDoctores() { return doctorService.obtenerTodos(); }

    @PostMapping
    public Doctor crearDoctor(@RequestBody Doctor doctor){
        return doctorService.guardarDoctor(doctor);
    }
}
