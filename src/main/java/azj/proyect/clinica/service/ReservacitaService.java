package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Reservacita;
import azj.proyect.clinica.repository.ReservacitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservacitaService {
    @Autowired
    private ReservacitaRepository reservacitaRepository;

    public List<Reservacita> obtenerTodos() { return reservacitaRepository.findAll(); }
}
