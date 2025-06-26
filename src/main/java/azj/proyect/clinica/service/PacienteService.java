package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Paciente;
import azj.proyect.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(int id, Paciente pacienteActualizado) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNombres(pacienteActualizado.getNombres());
            paciente.setApellidos(pacienteActualizado.getApellidos());
            paciente.setDni(pacienteActualizado.getDni());
            paciente.setCorreo(pacienteActualizado.getCorreo());
            paciente.setCelular(pacienteActualizado.getCelular());
            paciente.setDireccion(pacienteActualizado.getDireccion());
            paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
            paciente.setSexo(pacienteActualizado.getSexo());
            paciente.setEstado(pacienteActualizado.getEstado());
            return pacienteRepository.save(paciente);
        }).orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + id));
    }
}
