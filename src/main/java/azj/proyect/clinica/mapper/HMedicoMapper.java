package azj.proyect.clinica.mapper;

import azj.proyect.clinica.dto.HMedicoDTO;
import azj.proyect.clinica.dto.HMedicoResponseDTO;
import azj.proyect.clinica.dto.PacienteResumenDTO;
import azj.proyect.clinica.entity.Cita;
import azj.proyect.clinica.entity.HMedico;
import azj.proyect.clinica.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class HMedicoMapper {
    /*public HMedicoDTO toDto(HMedico historial) {
        HMedicoDTO dto = new HMedicoDTO();
        dto.setIdHistorial(historial.getIdHistorial());
        dto.setFechaRegistro(historial.getFechaRegistro());
        dto.setDiagnostico(historial.getDiagnostico());
        dto.setTratamiento(historial.getTratamiento());
        dto.setReceta(historial.getReceta());

        if (historial.getCita() != null) {
            dto.setFechaCita(historial.getCita().getFecha());
            dto.setMotivoConsulta(historial.getCita().getMotivoCons());
            if (historial.getCita().getPaciente() != null) {
                dto.setNombresPaciente(historial.getCita().getPaciente().getNombres());
                dto.setApellidosPaciente(historial.getCita().getPaciente().getApellidos());
            }
        }

        return dto;

    }*/
    public HMedicoResponseDTO toResponseDTO(HMedico historial) {
        Cita cita = historial.getCita();
        Paciente paciente = cita.getPaciente();

        PacienteResumenDTO pacienteResumen = new PacienteResumenDTO(
                paciente.getNombres(),
                paciente.getApellidos(),
                paciente.getDni()
        );

        return new HMedicoResponseDTO(
                historial.getIdHistorial(),
                historial.getFechaRegistro(),
                historial.getDiagnostico(),
                historial.getTratamiento(),
                historial.getReceta(),
                cita.getFecha(),
                cita.getMotivoCons(),
                pacienteResumen
        );
    }

}
