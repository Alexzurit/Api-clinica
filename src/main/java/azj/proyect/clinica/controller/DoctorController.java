package azj.proyect.clinica.controller;

import azj.proyect.clinica.dto.DoctorResponseDTO;
import azj.proyect.clinica.dto.PacienteDTO;
import azj.proyect.clinica.dto.RegistroDoctorDTO;
import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.entity.Paciente;
import azj.proyect.clinica.mapper.DoctorMapper;
import azj.proyect.clinica.mapper.PacienteMapper;
import azj.proyect.clinica.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PacienteMapper pacienteMapper;

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

    /*Agregar usuario con doctor*/
    /*@PostMapping("/registrar")
    public ResponseEntity<Doctor> registrarDoctorConUsuario(@RequestBody RegistroDoctorDTO dto) {
        try {
            Doctor doctorRegistrado = doctorService.registrarDoctorConUsuario(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(doctorRegistrado);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // O puedes devolver un mensaje si prefieres ResponseEntity<String>
        }
    }*/
    @PostMapping("/registrar")
    public ResponseEntity<DoctorResponseDTO> registrarDoctor(@RequestBody RegistroDoctorDTO dto) {
        Doctor doctor = doctorService.registrarDoctorConUsuario(dto);
        DoctorResponseDTO responseDTO = doctorMapper.mapToDoctorResponseDTO(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{idDoctor}/pacientes")
    public ResponseEntity<List<PacienteDTO>> listarPacientesPorDoctor(@PathVariable int idDoctor) {
        List<Paciente> pacientes = doctorService.obtenerPacientesDelDoctor(idDoctor);
        List<PacienteDTO> pacienteDTOs = pacientes.stream()
                .map(pacienteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pacienteDTOs);
    }

}
