package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.HMedico;
import azj.proyect.clinica.entity.Cita;
import azj.proyect.clinica.repository.CitaRepository;
import azj.proyect.clinica.repository.HMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HMedicoService {
    @Autowired
    private HMedicoRepository hMedicoRepository;

    @Autowired
    private CitaRepository citaRepository;

    public List<HMedico> obtenerTodos() {
        return hMedicoRepository.findAll();
    }

    public Optional<HMedico> obtenerPorId(int idHMedico) {
        return hMedicoRepository.findById(idHMedico);
    }

    public HMedico guardar(HMedico historial) {
        // Verifica si la cita existe
        Cita cita = citaRepository.findById(historial.getCita().getIdCita())
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        historial.setCita(cita);
        return hMedicoRepository.save(historial);
    }

    public void eliminar(int id) {
        if (!hMedicoRepository.existsById(id)) {
            throw new RuntimeException("Historial no encontrado");
        }
        hMedicoRepository.deleteById(id);
    }

    public HMedico actualizar(int id, HMedico datos) {
        HMedico historialExistente = hMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        historialExistente.setDiagnostico(datos.getDiagnostico());
        historialExistente.setTratamiento(datos.getTratamiento());
        historialExistente.setReceta(datos.getReceta());

        return hMedicoRepository.save(historialExistente);
    }
}
