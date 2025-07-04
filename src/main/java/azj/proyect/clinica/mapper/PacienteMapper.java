package azj.proyect.clinica.mapper;

import azj.proyect.clinica.dto.PacienteDTO;
import azj.proyect.clinica.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    public PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setIdPaciente(paciente.getIdpaciente());
        dto.setNombres(paciente.getNombres());
        dto.setApellidos(paciente.getApellidos());
        dto.setDni(paciente.getDni());
        dto.setCelular(paciente.getCelular());

        if (paciente.getFechaNacimiento() != null) {
            dto.setFechaNacimiento(paciente.getFechaNacimiento().toString()); // o formateado
        }

        return dto;
    }

}
