package azj.proyect.clinica.mapper;

import azj.proyect.clinica.dto.PacienteCitaDTO;
import azj.proyect.clinica.entity.Cita;
import azj.proyect.clinica.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteCitaMapper {
    public PacienteCitaDTO toDTO(Cita cita) {
        Paciente paciente = cita.getPaciente();

        PacienteCitaDTO dto = new PacienteCitaDTO();
        dto.setIdPaciente(paciente.getIdpaciente());
        dto.setNombres(paciente.getNombres());
        dto.setApellidos(paciente.getApellidos());
        dto.setDni(paciente.getDni());
        dto.setCelular(paciente.getCelular());

        dto.setFechaCita(cita.getFecha());
        dto.setMotivoConsulta(cita.getMotivoCons());
        dto.setEstadoCita(cita.getEstado());
        dto.setIdCita(cita.getIdCita()); //agregue esto

        return dto;
    }

}
