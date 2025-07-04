package azj.proyect.clinica.controller;

import azj.proyect.clinica.dto.UsuarioDTO;
import azj.proyect.clinica.dto.UsuarioRequestDTO;
import azj.proyect.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable int id) {
        return usuarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioDTO crearUsuario(@RequestBody UsuarioRequestDTO usuarioDTO) {
        return usuarioService.crearUsuario(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO actualizarUsuario(@PathVariable int id, @RequestBody UsuarioRequestDTO usuarioDTO) {
        return usuarioService.actualizarUsuario(id,usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

    //@PutMapping("/{idUsuario}/roles")
    /*public UsuarioDTO actualizarRoles(@PathVariable int idUsuario, @RequestBody List<Integer> rolesIds) {
        return usuarioService.actualizarRolesUsuario(idUsuario, rolesIds);
    }*/
    @PutMapping("/{idUsuario}/rol")
    public UsuarioDTO actualizarRol(@PathVariable int idUsuario, @RequestBody Integer rolId) {
        return usuarioService.actualizarRolUsuario(idUsuario, rolId);
    }
}
