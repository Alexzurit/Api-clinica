package azj.proyect.clinica.dto;

import azj.proyect.clinica.enums.EstadoUsuario;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegistroDoctorDTO {
    private String email;
    private String pass;
    private EstadoUsuario estado;
    private Integer rolId; // <-- nuevo

    private String nombres;
    private String apellidos;
    private String dni;
    private String cmp;
    private String celular;
    private Short estadoDoctor;
    private int idEspecialidad;

}
