package azj.proyect.clinica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialRequestDTO {
    private int idCita;
    private String diagnostico;
    private String tratamiento;
    private String receta;

}
