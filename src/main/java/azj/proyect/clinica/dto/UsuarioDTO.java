package azj.proyect.clinica.dto; //Para respuestas sin password

import azj.proyect.clinica.enums.EstadoUsuario;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private int idUsuario;
    private String dni;
    private String email;
    private EstadoUsuario estado;
    private String fechaCreacion;
}
