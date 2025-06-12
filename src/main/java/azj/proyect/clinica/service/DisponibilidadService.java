package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Disponibilidad;
import azj.proyect.clinica.repository.DisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadService {
    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    public List<Disponibilidad> listarDisponibilidades() {
        return disponibilidadRepository.findAll();
    }

    public Optional<Disponibilidad> obtenerPorId(int id) {
        return disponibilidadRepository.findById(id);
    }

    public Disponibilidad guardarDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    public void eliminarDisponibilidad(int id) {
        disponibilidadRepository.deleteById(id);
    }

}
