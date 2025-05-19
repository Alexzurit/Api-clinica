package azj.proyect.clinica.controller;

import azj.proyect.clinica.entity.Reservacita;
import azj.proyect.clinica.service.ReservacitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservacitaController {
    @Autowired
    private ReservacitaService reservacitaService;

    @GetMapping
    private List<Reservacita> listarReservas() { return reservacitaService.obtenerTodos(); }
}
