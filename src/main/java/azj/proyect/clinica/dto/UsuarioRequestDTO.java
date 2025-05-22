package azj.proyect.clinica.dto; //para crear editar usuarios

import azj.proyect.clinica.enums.EstadoUsuario;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private String dni;
    private String email;
    private String password;
    private EstadoUsuario estado;
}
