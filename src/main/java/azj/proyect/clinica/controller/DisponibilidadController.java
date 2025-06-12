package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Disponibilidad;
import azj.proyect.clinica.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidades")
public class DisponibilidadController {
    @Autowired
    private DisponibilidadService disponibilidadService;

    @GetMapping
    public List<Disponibilidad> listar() {
        return disponibilidadService.listarDisponibilidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disponibilidad> obtenerPorId(@PathVariable int id) {
        return disponibilidadService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disponibilidad> guardar(@RequestBody Disponibilidad disponibilidad) {
        return ResponseEntity.ok(disponibilidadService.guardarDisponibilidad(disponibilidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        disponibilidadService.eliminarDisponibilidad(id);
        return ResponseEntity.noContent().build();
    }

}
