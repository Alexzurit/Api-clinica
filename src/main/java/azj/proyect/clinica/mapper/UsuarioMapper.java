package azj.proyect.clinica.mapper;

import azj.proyect.clinica.dto.UsuarioDTO;
import azj.proyect.clinica.dto.UsuarioRequestDTO;
import azj.proyect.clinica.entity.Usuario;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

        String fechaFormateada = null;

        if (usuario.getFechaCreacion() != null) {
            fechaFormateada = usuario.getFechaCreacion()
                    .toInstant()
                    .atZone(ZoneId.of("America/Lima"))
                    .toLocalDateTime()
                    .format(formatear);
        }
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                //usuario.getDni(),
                usuario.getEmail(),
                usuario.getEstado(),
                //usuario.getFechaCreacion() != null ? usuario.getFechaCreacion().toString() : null
                fechaFormateada,
                //usuario.getIdUsuario()
                usuario.getRol().getIdRol(),
                usuario.getRol().getNombreRol()
                //asegura que si la fecha es null, no se lance una excepción y simplemente se envíe como null en el DTO
        );
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        //usuario.setDni(dto.getDni());
        usuario.setEmail(dto.getEmail());
        usuario.setEstado(dto.getEstado());
        return usuario;
    }
}
