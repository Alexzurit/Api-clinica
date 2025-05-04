package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> listarEspecialidades(){ return especialidadService.obtenerTodos(); }
}
