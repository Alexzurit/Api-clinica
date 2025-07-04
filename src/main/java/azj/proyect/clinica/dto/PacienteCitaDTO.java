package azj.proyect.clinica.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PacienteCitaDTO {
    private int idPaciente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;

    private LocalDateTime fechaCita;
    private String motivoConsulta;
    private Short estadoCita;

}
