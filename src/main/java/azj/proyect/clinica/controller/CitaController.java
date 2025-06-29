package azj.proyect.clinica.controller;

import  azj.proyect.clinica.entity.Cita;
import azj.proyect.clinica.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> listarCitas() { return citaService.listarCitas(); }

    @GetMapping("/{id}")
    public Cita obtenerCita(@PathVariable int id){
        return  citaService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita){
        return citaService.guardarCita(cita);
    }

    @PutMapping("/{id}")
    public Cita actualizarCita(@PathVariable int id, @RequestBody Cita cita) {
        return citaService.actualizarCita(id, cita);
    }

}
