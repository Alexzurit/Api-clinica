package azj.proyect.clinica.controller;

import azj.proyect.clinica.dto.HMedicoDTO;
import azj.proyect.clinica.dto.HMedicoResponseDTO;
import azj.proyect.clinica.dto.HistorialRequestDTO;
import azj.proyect.clinica.entity.HMedico;
import azj.proyect.clinica.mapper.HMedicoMapper;
import azj.proyect.clinica.service.HMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hmedicos")
public class HMedicoController {
    @Autowired
    private HMedicoService hMedicoService;

    @Autowired
    private HMedicoMapper hMedicoMapper;
    @GetMapping
    public List<HMedico> listarHistoriales() {
        return hMedicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public HMedico obtenerHistorial(@PathVariable int id) {
        return hMedicoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }

    @PostMapping
    public HMedico crearHistorial(@RequestBody HMedico historial) {
        return hMedicoService.guardar(historial);
    }

    @PutMapping("/{id}")
    public HMedico actualizarHistorial(@PathVariable int id, @RequestBody HMedico datos) {
        return hMedicoService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminarHistorial(@PathVariable int id) {
        hMedicoService.eliminar(id);
    }

    /*Nuevos controlladores*/
    @GetMapping("/historial/{idPaciente}")
    public ResponseEntity<List<HMedicoResponseDTO>> verHistorial(@PathVariable int idPaciente) {
        List<HMedicoResponseDTO> response = hMedicoService.listarHistorialPorPaciente(idPaciente);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/historial/registrar")
    /*public ResponseEntity<HMedico> registrarHistorial(@RequestBody HistorialRequestDTO dto) {
        HMedico nuevo = hMedicoService.registrarHistorial(
                dto.getIdCita(),
                dto.getDiagnostico(),
                dto.getTratamiento(),
                dto.getReceta()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }*/
    public ResponseEntity<HMedicoResponseDTO> registrarHistorial(@RequestBody HistorialRequestDTO dto) {
        HMedico nuevo = hMedicoService.registrarHistorial(
                dto.getIdCita(),
                dto.getDiagnostico(),
                dto.getTratamiento(),
                dto.getReceta()
        );
        HMedicoResponseDTO responseDTO = hMedicoMapper.toResponseDTO(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
