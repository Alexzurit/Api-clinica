package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Horario;
import azj.proyect.clinica.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horario> listarHorarios() { return horarioService.obtenerTodos(); }

    @PostMapping
    public Horario crearHorario(@RequestBody Horario horario) {
        return horarioService.guardar(horario);
    }

    @PutMapping("/{id}")
    public Horario actualizarHorario(@PathVariable int id, @RequestBody Horario horario) {
        return horarioService.actualizar(id, horario);
    }

}
