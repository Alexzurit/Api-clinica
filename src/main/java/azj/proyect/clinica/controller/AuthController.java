package azj.proyect.clinica.controller;

import azj.proyect.clinica.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        if (authService.autenticarUsuario(email, password)) {
            return "Login exitoso";
        } else {
            return "Credenciales incorrectas";
        }
    }
}
