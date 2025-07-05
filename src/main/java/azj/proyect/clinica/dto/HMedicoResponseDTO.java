package azj.proyect.clinica.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HMedicoResponseDTO {
    private int idCita; // agregue esto
    private int idHistorial;
    private LocalDateTime fechaRegistro;
    private String diagnostico;
    private String tratamiento;
    private String receta;

    private LocalDateTime fechaCita;
    private String motivoConsulta;

    private PacienteResumenDTO paciente;

}
