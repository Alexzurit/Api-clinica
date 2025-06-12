package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Cita;
import azj.proyect.clinica.entity.Disponibilidad;
import azj.proyect.clinica.entity.Paciente;
import azj.proyect.clinica.repository.CitaRepository;
import azj.proyect.clinica.repository.DisponibilidadRepository;
import azj.proyect.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private DisponibilidadRepository disponRepository;

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerPorId(int id) {
        return citaRepository.findById(id);
    }

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizarCita(int idCita, Cita nuevaCita) {
        Cita citaExistente = citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if (nuevaCita.getPaciente() != null) {
            Paciente paciente = pacienteRepository.findById(nuevaCita.getPaciente().getIdpaciente())
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
            citaExistente.setPaciente(paciente);
        }

        if (nuevaCita.getDisponibilidad() != null) {
            Disponibilidad dispon = disponRepository.findById(nuevaCita.getDisponibilidad().getIdDispon())
                    .orElseThrow(() -> new RuntimeException("Disponibilada no encontrada"));
            citaExistente.setDisponibilidad(dispon);
        }

        citaExistente.setFecha(nuevaCita.getFecha());
        citaExistente.setEstado(nuevaCita.getEstado());
        citaExistente.setMotivoCons(nuevaCita.getMotivoCons());

        return citaRepository.save(citaExistente);
    }
}
