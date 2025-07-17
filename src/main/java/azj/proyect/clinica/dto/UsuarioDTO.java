package azj.proyect.clinica.dto; //Para respuestas sin password

import azj.proyect.clinica.enums.EstadoUsuario;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private int idUsuario;
    //private String dni; comentamos dni porque no se utilizara en la tabla
    private String email;
    private EstadoUsuario estado;
    private String fechaCreacion;
    private Integer rolId; //para obtener el id de rol o su nombre;
    private String nombreRol;
}
