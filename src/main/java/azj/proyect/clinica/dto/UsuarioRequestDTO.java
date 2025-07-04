package azj.proyect.clinica.dto; //para crear editar usuarios

import azj.proyect.clinica.enums.EstadoUsuario;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    //private String dni;
    private String email;
    private String password;
    private EstadoUsuario estado;
    //private List<Integer> rolesIds; // Solo IDs de roles
    private Integer rolId; // 👈 Antes era List<Integer>, ahora solo uno
}
