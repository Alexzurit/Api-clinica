package azj.proyect.clinica.service;

import azj.proyect.clinica.dto.UsuarioDTO;
import azj.proyect.clinica.dto.UsuarioRequestDTO;
import azj.proyect.clinica.entity.Rol;
import azj.proyect.clinica.entity.Usuario;
import azj.proyect.clinica.mapper.UsuarioMapper;
import azj.proyect.clinica.repository.RolRepository;
import azj.proyect.clinica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> obtenerPorId(int id){
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO);
    }

    public UsuarioDTO crearUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        //Agregar logica para encriptar contraseña
        usuario.setPass(passwordEncoder.encode(dto.getPassword()));
        List<Rol> roles = dto.getRolesIds().stream()
                .map(idRol -> rolRepository.findById(idRol)
                        .orElseThrow(() -> new RuntimeException("Rol No encontrado")))
                .toList();
        usuario.setRoles(roles);
        Usuario guardado = usuarioRepository.save(usuario);
        //retornarusuario despues de guardar
        guardado = usuarioRepository.findById(guardado.getIdUsuario()).orElse(guardado);
        System.out.println("Fecha de creación después de guardar: " + guardado.getFechaCreacion());
        return UsuarioMapper.toDTO(guardado);
    }

    public UsuarioDTO actualizarUsuario(int id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        //usuarioExistente.setDni(dto.getDni()); En Usuario se quito DNI
        usuarioExistente.setEmail(dto.getEmail());
        usuarioExistente.setEstado(dto.getEstado());
        //Solo actualiza la contraseña si se proporciona una nueva
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuarioExistente.setPass(passwordEncoder.encode(dto.getPassword()));
        }

        return UsuarioMapper.toDTO(usuarioRepository.save(usuarioExistente));
    }

    public void eliminarUsuario(int id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
    //Actualizar rol de usuarios
    public UsuarioDTO actualizarRolesUsuario(int idUsuario, List<Integer> rolesIds) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Obtener los roles desde la BD usando los IDs
        List<Rol> roles = new ArrayList<>(usuario.getRoles()); // ✅ Convierte la lista a una versión modificable
        roles.clear(); // Borra los roles anteriores
        roles.addAll(rolesIds.stream()
                .map(idRol -> rolRepository.findById(idRol)
                        .orElseThrow(() -> new RuntimeException("Rol no encontrado")))
                .toList()); // Agrega los nuevos roles

        usuario.setRoles(roles); // Asignar los nuevos roles
        usuarioRepository.save(usuario); // Guardar cambios

        return UsuarioMapper.toDTO(usuario); // Retornar como DTO
    }
}
