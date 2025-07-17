package azj.proyect.clinica.controller;

import azj.proyect.clinica.dto.ErrorResponseDTO;
import azj.proyect.clinica.dto.UsuarioRequestDTO;
import azj.proyect.clinica.dto.UsuarioDTO;
import azj.proyect.clinica.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UsuarioRequestDTO request) {
        return authService.autenticarUsuario(request.getEmail(), request.getPassword())
                .<ResponseEntity<Object>>map(usuario -> ResponseEntity.ok((Object) new UsuarioDTO(
                        usuario.getIdUsuario(),
                        usuario.getEmail(),
                        usuario.getEstado(),
                        usuario.getFechaCreacion() != null ? usuario.getFechaCreacion().toString() : null,
                        usuario.getRol().getIdRol()
                )))
                .orElseGet(() -> ResponseEntity
                        .status(401)
                        .body(new ErrorResponseDTO("Credenciales incorrectas")));
    }

}
