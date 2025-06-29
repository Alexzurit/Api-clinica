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

    @PutMapping("/{id}")
    public ResponseEntity<Disponibilidad> actualizar(@PathVariable int id, @RequestBody Disponibilidad disponibilidad) {
        return disponibilidadService.obtenerPorId(id)
                .map(disponibilidadExistente -> {
                    disponibilidad.setIdDispon(id); // Asegurar que se actualice la disponibilidad correcta
                    Disponibilidad actualizada = disponibilidadService.guardarDisponibilidad(disponibilidad);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
