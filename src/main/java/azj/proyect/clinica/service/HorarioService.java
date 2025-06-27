package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Horario;
import azj.proyect.clinica.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> obtenerTodos() { return horarioRepository.findAll(); }

    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario actualizar(int id, Horario horarioActualizado) {
        Horario horarioExistente = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));

        horarioExistente.setDiaSemana(horarioActualizado.getDiaSemana());
        horarioExistente.setHoraInicio(horarioActualizado.getHoraInicio());
        horarioExistente.setHoraFin(horarioActualizado.getHoraFin());
        horarioExistente.setEstado(horarioActualizado.getEstado());

        return horarioRepository.save(horarioExistente);
    }
}
