package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Sede;
import azj.proyect.clinica.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {
    @Autowired
    private SedeService sedeService;

    @GetMapping
    public List<Sede> listarSedes () { return sedeService.obtenerTodos(); }
}
