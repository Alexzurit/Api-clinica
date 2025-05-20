package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> listarDoctores() { return doctorService.obtenerTodos(); }

    @PostMapping
    public Doctor crearDoctor(@RequestBody Doctor doctor){
        return doctorService.guardarDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor obtenerDoctor(@PathVariable int id){
        return doctorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
    }

    @PutMapping("/{id}")
    public Doctor actualizarDoctor(@PathVariable int id, @RequestBody Doctor doctor){
        return doctorService.actualizarDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> eliminarDoctor(@PathVariable int id){
        doctorService.eliminarDoctor(id);
        return ResponseEntity.ok("Doctor Eliminado de forma correcta");
    }
}
