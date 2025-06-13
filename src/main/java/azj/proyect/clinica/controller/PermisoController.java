package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Permiso;
import azj.proyect.clinica.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {
    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public List<Permiso> listarPermisos() { return permisoService.obtenerTodos(); }

    @PostMapping
    public Permiso crearPermiso(@RequestBody Permiso permiso) { return permisoService.guardarPermiso(permiso); }

    @GetMapping("/{id}")
    public Permiso obtenerPermiso(@PathVariable int id) {
        return permisoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));
    }

    @PutMapping("/{id}")
    public Permiso actualizarPermiso(@PathVariable int id, @RequestBody Permiso permiso){
        return permisoService.actualizarPermiso(id, permiso);
    }
}
