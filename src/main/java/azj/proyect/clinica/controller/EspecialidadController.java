package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> listarEspecialidades(){ return especialidadService.obtenerTodos(); }

    @GetMapping("/{id}")
    public Especialidad obtenerEspecialidad(@PathVariable int id){
        return especialidadService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
    }

    @PostMapping
    public Especialidad crearEspecialidad(@RequestBody Especialidad especialidad){
        return especialidadService.guardarEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public Especialidad actualizarEspecialidad(@PathVariable int id, @RequestBody Especialidad especialidad){
        return especialidadService.actualizarEspecialidad(id, especialidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEspecialidad(@PathVariable int id){
        especialidadService.eliminarEspecialidad(id);
        return ResponseEntity.ok("Especialidad Eliminada de manera correcta");
    }
}
