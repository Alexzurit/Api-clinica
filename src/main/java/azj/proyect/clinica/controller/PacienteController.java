package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Paciente;
import azj.proyect.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.obtenerTodos();
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@PathVariable int id, @RequestBody Paciente paciente) {
        return pacienteService.actualizarPaciente(id, paciente);
    }

}
