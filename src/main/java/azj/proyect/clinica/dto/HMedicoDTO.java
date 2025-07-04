package azj.proyect.clinica.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HMedicoDTO {
    private int idHistorial;
    private LocalDateTime fechaRegistro;
    private String diagnostico;
    private String tratamiento;
    private String receta;

    private String nombresPaciente;
    private String apellidosPaciente;
    private LocalDateTime fechaCita;
    private String motivoConsulta;
}
