package azj.proyect.clinica.controller;

import azj.proyect.clinica.dto.SolicitudCitaDTO;
import azj.proyect.clinica.service.RegistroCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro-cita")
public class RegistroCitaController {

    @Autowired
    private RegistroCitaService registroCitaService;

    @PostMapping
    public String registrarCita(@RequestBody SolicitudCitaDTO dto) {
        try {
            registroCitaService.registrarCita(dto);
            return "Cita registrada correctamente";
        } catch (Exception e) {
            return "Error al registrar la cita: " + e.getMessage();
        }
    }
}
