package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.HMedico;
import azj.proyect.clinica.service.HMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hmedicos")
public class HMedicoController {
    @Autowired
    private HMedicoService hMedicoService;

    @GetMapping
    public List<HMedico> listarHistoriales(){
        return hMedicoService.obtenerTodos();
    }
    @GetMapping("/{id}")
    public HMedico obtenerHistorial(@PathVariable int id){
        return hMedicoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }
}
