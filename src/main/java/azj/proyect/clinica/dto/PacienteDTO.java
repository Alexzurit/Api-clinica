package azj.proyect.clinica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private int idPaciente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;
    private String fechaNacimiento; // opcional como String para control de formato

}
