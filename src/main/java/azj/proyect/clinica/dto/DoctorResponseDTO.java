package azj.proyect.clinica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorResponseDTO {
    private int idDoctor;
    private String nombres;
    private String apellidos;
    private String dni;
    private String cmp;
    private String celular;
    private Short estadoDoctor;

    private String emailUsuario;       // extraído desde Usuario
    private String nombreRol;          // extraído desde Usuario.Rol
    private String nombreEspecialidad; // extraído desde Especialidad

}
